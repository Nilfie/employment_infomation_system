package com.group04.employment.service;

import com.group04.employment.document.EmploymentInfo;
import com.group04.employment.entity.CompanyInfo;
import com.group04.employment.mapper.CompanyInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/6/6 21:27
 */
@Service
public class CompanyInfoService {
    @Autowired
    private CompanyInfoMapper companyInfoMapper;

    public List<Map<CompanyInfo, EmploymentInfo>> selectAll(){
        List<Map<CompanyInfo, EmploymentInfo>> infoList = companyInfoMapper.selectList();
        return infoList;
    }

}
