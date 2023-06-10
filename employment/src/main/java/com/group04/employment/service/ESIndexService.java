package com.group04.employment.service;

import com.alibaba.fastjson.JSON;
import com.group04.employment.document.EmploymentInfo;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.core.TimeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.group04.employment.common.constant.INDEX_NAME;

/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/5/8 14:28
 */

@Service
public class ESIndexService {
    @Autowired
    private RestHighLevelClient client;

    //    创建索引
    public void createIndex(String indexName) {
        CreateIndexRequest request = new CreateIndexRequest(indexName);
        CreateIndexResponse response = null;
        try {
            response = client.indices().create(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response);

    }

    //    查找索引
    public boolean findIndex(String indexName) {
        GetIndexRequest request = new GetIndexRequest(indexName);
        try {
            return client.indices().exists(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //    删除索引
    public boolean deleteIndex(String indexName) {
        DeleteIndexRequest request = new DeleteIndexRequest(indexName);
        try {
            AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
            return response.isAcknowledged();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //    创建文档

    public void createDoc(String indexName, Object object,String id) {
        IndexRequest indexRequest = new IndexRequest(indexName);
        indexRequest.id(id)
                .timeout(TimeValue.timeValueSeconds(1))
                .source(JSON.toJSONString(object), XContentType.JSON);
        indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
        try {
            IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
            System.out.print(response.status()+" "+id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //    判断文档是否存在
    public boolean isExist(String indexName, String id) {
        GetRequest request = new GetRequest(indexName, id);
        //        ....
        return request.getShouldStoreResult();
    }

    //    获取文档
    public void getDoc(String indexName, String id) {
        GetRequest request = new GetRequest(indexName, id);
        //        ....
        try {
            GetResponse response = client.get(request, RequestOptions.DEFAULT);
            System.out.println(response.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //修改文档
    public String updateDoc(String indexName, String id, Object newDoc) {
        UpdateRequest updateRequest = new UpdateRequest(indexName, id);
//        System.out.println(id);
        updateRequest.timeout("1s");
        updateRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
        //        ....
        try {
            updateRequest.doc(JSON.toJSONString(newDoc), XContentType.JSON);
            UpdateResponse response = client.update(updateRequest, RequestOptions.DEFAULT);
//            System.out.println(response.status());
//            System.out.println(response.toString());
            return String.valueOf(response.status());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //删除文档
    public String deleteDoc(String indexName, String id) {
        DeleteRequest deleteRequest = new DeleteRequest(indexName, id);
        deleteRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
        deleteRequest.timeout("1s");
        //        ....
        try {
            DeleteResponse response = client.delete(deleteRequest, RequestOptions.DEFAULT);
            return String.valueOf(response.status());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //批量插入文档
    public String insertDoc(String indexName, List<EmploymentInfo> employmentInfos) {
        BulkRequest request = new BulkRequest();
        request.timeout("10s");
        for (EmploymentInfo employmentInfo : employmentInfos) {
            request.add(new IndexRequest(indexName)
                    .id(employmentInfo.getInformationId())
                    .source(JSON.toJSONString(employmentInfo), XContentType.JSON));
        }
        BulkResponse response = null;
        try {
            response = client.bulk(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.status()); //ok
        return response.status().toString();

    }
}
