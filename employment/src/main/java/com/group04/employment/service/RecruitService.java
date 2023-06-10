package com.group04.employment.service;

import com.github.pagehelper.PageHelper;
import com.group04.employment.entity.Recruit;
import com.group04.employment.mapper.RecruitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/5/8 14:28
 */

@Service
public class RecruitService {
    @Autowired
    RecruitMapper recruitMapper;


    public List<Recruit> getAllRecruit(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Recruit> infoList = recruitMapper.selectList(null);

        return infoList;
    }

//    public List<EmploymentInfo> getEmploymentInfo(String q, int pageNum, int pageSize) throws IOException {
//        PageHelper.startPage(pageNum, pageSize);
//        q = "*" + q + "*";
//
//        // 模糊查询 分词
//        MultiMatchQueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(q, "informationId", "studentMajor",
//                        "studentClass", "studentGender", "companyName.keyword",
//                        "employmentStation.keyword", "companyAddress.keyword", "treatment.keyword", "abilityRequirement.keyword",
//                        "studentName.keyword", "studentMobile.keyword", "employmentTime.keyword")
//                .type(MultiMatchQueryBuilder.Type.BEST_FIELDS)
//                .analyzer("ik_smart")
//                .fuzziness(Fuzziness.AUTO)
//                .prefixLength(0)
//                .maxExpansions(50);
//        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
////        searchSourceBuilder.size(0);
//        searchSourceBuilder.query(queryBuilder);
//        //查询所有
//        //searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//        //将SearchSourceBuilder添加到SearchRequest中
//        searchRequest.source(searchSourceBuilder);
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHit[] searchHits = response.getHits().getHits();
//        List<EmploymentInfo> list = new ArrayList<>();
//        for (SearchHit hit : searchHits) {
////            System.out.println(hit.getSourceAsString());
//            //转换为employmentInfo对象
//            EmploymentInfo employmentInfo = JSONObject.parseObject(hit.getSourceAsString(), EmploymentInfo.class);
//            System.out.println(employmentInfo);
//            list.add(employmentInfo);
//        }
//        return list;
//    }

    public void addRecruitInfo(Recruit info) {
//        esIndexService.createDoc(INDEX_NAME, info);
        recruitMapper.insert(info);
    }

    public void updateRecruitInfo(Recruit info) {
        recruitMapper.updateById(info);
    }

    public void deleteRecruitInfo(String infoId) {

        recruitMapper.deleteById(infoId);
    }

//    public List<Map<String, Object>> getStudentCount(String fieldName, int pageNum, int pageSize) throws IOException {
//        PageHelper.startPage(pageNum, pageSize);
//        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.size(0);
//        // 分组聚合
//        searchSourceBuilder.aggregation(AggregationBuilders.terms(fieldName).field(fieldName + ".keyword"));
//        searchRequest.source(searchSourceBuilder);
//        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
//        Terms aggregation = response.getAggregations().get(fieldName);
//        List<Map<String, Object>> result = new ArrayList<>();
////        Map<String, Object> res = new HashMap<>();
//        for (Terms.Bucket bucket : aggregation.getBuckets()) {
//            Map<String, Object> res = new HashMap<>();
//            res.put(fieldName, bucket.getKey());
//            res.put("studentCount", bucket.getDocCount());
//            result.add(res);
//        }
//
//        return result;
//    }

}
