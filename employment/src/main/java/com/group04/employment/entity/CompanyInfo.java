package com.group04.employment.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/6/6 21:23
 */
@Data
@TableName("public.company_info")
public class CompanyInfo {
    @TableField("cid")
    private int cid;
    @TableField("cname")
    private String cname;
    @TableField("csite")
    private String csite;
}
