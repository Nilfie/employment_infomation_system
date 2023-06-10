package com.group04.employment.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.group04.employment.document.EmploymentInfo;
import com.group04.employment.mapper.EmploymentInfoMapper;
import com.group04.employment.repository.InfoRepository;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.group04.employment.common.constant.INDEX_NAME;


@Service
public class EmploymentInfoService {
    @Autowired
    private EmploymentInfoMapper employmentInfoMapper;
    @Autowired
    private InfoRepository infoRepository;
    @Autowired
    private ESIndexService esIndexService;
    @Autowired
    private RestHighLevelClient client;


    public List<EmploymentInfo> getAllEmploymentInfo(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<EmploymentInfo> infoList = infoRepository.findAll();
        // List<EmploymentInfo> infoList = employmentInfoMapper.selectList(null);
        return infoList;
    }

    public List<EmploymentInfo> getEmploymentInfo(String q, int pageNum, int pageSize) throws IOException {
        PageHelper.startPage(pageNum, pageSize);
        q = "*" + q + "*";

        // 模糊查询 分词
        MultiMatchQueryBuilder queryBuilder = QueryBuilders
                .multiMatchQuery(q,
                        "studentMajor",
                        "studentClass", "studentGender", "companyName",
                        "employmentStation", "companyAddress", "treatment",
                        "abilityRequirement",
                        "studentName");

//        MatchPhraseQueryBuilder queryBuilder = QueryBuilders.matchPhraseQuery("_all", q).analyzer("ik_smart");
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.size(0);
        searchSourceBuilder.query(queryBuilder);
        //查询所有
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        //将SearchSourceBuilder添加到SearchRequest中
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] searchHits = response.getHits().getHits();
        List<EmploymentInfo> list = new ArrayList<>();
        for (SearchHit hit : searchHits) {
//            System.out.println(hit.getSourceAsString());
            //转换为employmentInfo对象
            EmploymentInfo employmentInfo = JSONObject.parseObject(hit.getSourceAsString(), EmploymentInfo.class);
//            System.out.println(employmentInfo);
            list.add(employmentInfo);
        }
        return list;
    }

    public void addEmploymentInfo(EmploymentInfo info) {
        esIndexService.createDoc(INDEX_NAME, info, info.getInformationId());
        employmentInfoMapper.insert(info);
    }

    public void updateEmploymentInfo(EmploymentInfo info) {
        esIndexService.updateDoc(INDEX_NAME, info.getInformationId(), info);
        employmentInfoMapper.updateById(info);
    }

    public void deleteEmploymentInfo(String infoId) {
        esIndexService.deleteDoc("infos", infoId);
        employmentInfoMapper.deleteById(infoId);
    }

    public List<Map<String, Object>> getStudentCount(String fieldName, int pageNum, int pageSize) throws IOException {
        PageHelper.startPage(pageNum, pageSize);
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.size(0);
        // 分组聚合
        searchSourceBuilder.aggregation(AggregationBuilders.terms(fieldName).field(fieldName + ".keyword").size(50));
        searchSourceBuilder.size(50);
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        Terms aggregation = response.getAggregations().get(fieldName);
        List<Map<String, Object>> result = new ArrayList<>();
//        Map<String, Object> res = new HashMap<>();
        for (Terms.Bucket bucket : aggregation.getBuckets()) {
            Map<String, Object> res = new HashMap<>();
            res.put(fieldName, bucket.getKey());
            res.put("studentCount", bucket.getDocCount());
            result.add(res);
        }

        return result;
    }

}
