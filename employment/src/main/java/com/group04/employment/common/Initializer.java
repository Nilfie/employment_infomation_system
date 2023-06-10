package com.group04.employment.common;

import com.group04.employment.document.DocUser;
import com.group04.employment.document.EmploymentInfo;
import com.group04.employment.mapper.DocUserMapper;
import com.group04.employment.mapper.EmploymentInfoMapper;
import com.group04.employment.service.ESIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

import static com.group04.employment.common.constant.INDEX_NAME;
import static com.group04.employment.common.constant.INDEX_NAME_USER;

@Component
public class Initializer {
    @Autowired
    private ESIndexService esIndexService;
    @Autowired
    private EmploymentInfoMapper employmentInfoMapper;
    @Autowired
    private DocUserMapper docUserMapper;

    @PostConstruct
    public void init() {
        //防止数据库更新后es不更新
        if (esIndexService.findIndex(INDEX_NAME)) {
            esIndexService.deleteIndex(INDEX_NAME);

        }
        if(esIndexService.findIndex(INDEX_NAME_USER)){
            esIndexService.deleteIndex(INDEX_NAME_USER);
        }
        esIndexService.createIndex(INDEX_NAME);
        esIndexService.createIndex(INDEX_NAME_USER);
        for (EmploymentInfo info : employmentInfoMapper.selectList(null)
        ) {
            if (!esIndexService.isExist(INDEX_NAME, info.getInformationId()))
                esIndexService.createDoc(INDEX_NAME,info,info.getInformationId());
//            esIndexService.getDoc(INDEX_NAME, info.getInformationId());
        }
        for (DocUser user : docUserMapper.selectList(null)
        ) {
            if (!esIndexService.isExist(INDEX_NAME_USER, user.getUserId()))
                esIndexService.createDoc(INDEX_NAME_USER,user,user.getUserId());
        }

        System.out.println("初始化完成");


    }
}
