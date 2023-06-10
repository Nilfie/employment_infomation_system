package com.group04.employment.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group04.employment.document.EmploymentInfo;
import com.group04.employment.entity.CompanyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/6/6 21:27
 */
@Mapper
public interface CompanyInfoMapper extends BaseMapper{
    @Select("select company_name, csite, count(company_name) as pv1 " +
            "from company_info " +
            "RIGHT JOIN employment_info " +
            "on company_info.cname = employment_info.company_name " +
            "GROUP BY company_name, csite")
    List<Map<CompanyInfo, EmploymentInfo>> selectList();
}
