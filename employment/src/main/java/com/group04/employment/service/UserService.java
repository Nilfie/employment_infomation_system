package com.group04.employment.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.group04.employment.document.DocUser;
import com.group04.employment.entity.User;
import com.group04.employment.mapper.DocUserMapper;
import com.group04.employment.mapper.UserMapper;
import com.group04.employment.repository.UserRepository;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.group04.employment.common.constant.INDEX_NAME_USER;


/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/5/8 14:28
 */
@Service
public class UserService {
    @Autowired
    private DocUserMapper docUserMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ESIndexService esIndexService;
    @Autowired
    private RestHighLevelClient client;
    @Autowired
    private UserMapper userMapper;

    /*
     * security
     * */
    public String register(User u) {
        int type = (u.getUserType());
        if (type == 1 || type == 0) {
            u.setAuthority("ROLE_USER");
        } else if (type == 2) {
            u.setAuthority("RECRUIT");
        }
        int update = userMapper.update(u, null);
        if (update > 0) {
            return "/employment/login";
        }
        return "/register";
    }

    /*
     * 获取当前用户名称
     * */
    private String getUname() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    /*
     * 获取当前用户权限
     * */
    private String getAuthorities() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority ga :
                authentication.getAuthorities()) {
            roles.add(ga.getAuthority());
        }
        return roles.toString();
    }

    // 没有权限访问
    public String deniedAccess(Model model) {
        model.addAttribute("user", getUname());
        model.addAttribute("role", getAuthorities());
        return "deniedAccess";
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        // 获取用户认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
    }

    /*end*/
    public DocUser getUserByAccount(String account) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().eq("useraccount", account);
        DocUser user = docUserMapper.selectOne(queryWrapper);
        return user;
    }


    public List<DocUser> getAllUsers(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
//        List<User> userList = userMapper.selectList(null);
        List<DocUser> userList = userRepository.findAll();
        return userList;
    }

    public void addUser(DocUser user) {

        esIndexService.createDoc(INDEX_NAME_USER, user, user.getUserId());
        docUserMapper.insert(user);
    }

    public void updateUser(DocUser user) {
        esIndexService.updateDoc(INDEX_NAME_USER, user.getUserId(), user);
        docUserMapper.updateById(user);
//        docUserMapper.update(user, null);
    }

    public void deleteUser(String userId) {
        esIndexService.deleteDoc(INDEX_NAME_USER, userId);
        docUserMapper.deleteById(userId);
    }

    public List<DocUser> selectAllUsersBy(DocUser user, int pageNum, int pageSize) throws IOException {
        //如果只有一个关键字,进行模糊搜索
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME_USER);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        if (user.getUserAccount() == "" && user.getAccountName() == "") {
            searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        } else if (user.getUserAccount() != ""&&user.getAccountName() == "") {
            //通配符查询wildcardQuery
            searchSourceBuilder.query(QueryBuilders.wildcardQuery("userAccount.keyword", "*"+user.getUserAccount()+"*"));
        } else if (user.getAccountName() != ""&&user.getUserAccount() == "") {
            searchSourceBuilder.query(QueryBuilders.wildcardQuery("accountName.keyword","*"+ user.getAccountName()+"*"));
        } else {
            //两个都有值，进行查询
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            boolQueryBuilder.must(QueryBuilders.wildcardQuery("accountName.keyword","*"+ user.getAccountName()+"*"))
                    .must(QueryBuilders.wildcardQuery("userAccount.keyword","*"+user.getUserAccount()+"*" ));
            searchSourceBuilder.query(boolQueryBuilder);
        }
        //es默认查询10条
        searchSourceBuilder.size(20);
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] searchHits = response.getHits().getHits();
        List<DocUser> list = new ArrayList<>();
        for (SearchHit hit : searchHits) {
            DocUser u = JSONObject.parseObject(hit.getSourceAsString(), DocUser.class);
            System.out.println(u.toString());
            list.add(u);
        }
        return list;
    }
}
