package com.group04.employment.repository;

import com.group04.employment.document.EmploymentInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoRepository extends ElasticsearchRepository<EmploymentInfo,String> {
    public List<EmploymentInfo> findAll();
}
