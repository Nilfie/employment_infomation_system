package com.group04.employment.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group04.employment.document.EmploymentInfo;
import com.group04.employment.mapper.EmploymentInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/6/1 15:11
 */
@Service
public class ChartService {
    @Autowired
    private EmploymentInfoMapper employmentInfoMapper;

    public List<EmploymentInfo> list(){
        return employmentInfoMapper.selectList(null);
    }
    public List<EmploymentInfo> listGroupByMajor(){
        QueryWrapper<EmploymentInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("student_major, count(*) as num").groupBy("student_major");
        List list = employmentInfoMapper.selectMaps(queryWrapper);
        return list;
    }

    public List<EmploymentInfo> list2(){
        QueryWrapper<EmploymentInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("count(*) as totals");
        List maps = employmentInfoMapper.selectMaps(queryWrapper);
        return maps;
    }

    public List<EmploymentInfo> listGroupByClass(){
        QueryWrapper<EmploymentInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("student_class, count(*) as num").groupBy("student_class");
        List list = employmentInfoMapper.selectMaps(queryWrapper);
        return list;
    }

    public List<EmploymentInfo> listGroupByStation(){
        QueryWrapper<EmploymentInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("employment_station, count(*) as num").groupBy("employment_station");
        List list = employmentInfoMapper.selectMaps(queryWrapper);
        return list;
    }

    public List<EmploymentInfo> listGroupByCompany(){
        QueryWrapper<EmploymentInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("company_name, count(*) as num").groupBy("company_name");
        List list = employmentInfoMapper.selectMaps(queryWrapper);
        return list;
    }


}
