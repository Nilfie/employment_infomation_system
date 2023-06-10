package com.group04.employment.repository;

import com.group04.employment.document.DocUser;
import com.group04.employment.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<DocUser,String> {
    public List<DocUser> findAll();
}
