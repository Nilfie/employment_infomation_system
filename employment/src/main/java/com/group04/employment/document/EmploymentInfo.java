package com.group04.employment.document;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
//@FieldNameConstants
@Component
@Document(indexName = "infos")
@TableName(schema = "public" )
public class EmploymentInfo {
    @TableId
    @Id
    @Field(type = FieldType.Keyword)
    private String informationId;
    @Field(type = FieldType.Text)
    @TableField("company_name")
    private String companyName;
    @Field(type = FieldType.Text)
    private String companyAddress;
    @Field(type = FieldType.Text)
    private String employmentStation;
    @Field(type = FieldType.Text)
    private String treatment;
    @Field(type = FieldType.Text)
    private String abilityRequirement;
    @Field(type = FieldType.Text)
    private String studentName;
    @Field(type = FieldType.Text)
    private String studentMajor;
    @Field(type = FieldType.Text)
    private String studentGender;
    @Field(type = FieldType.Text)
    private String studentClass;
    @Field(type = FieldType.Text)
    private String studentMobile;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Field(type = FieldType.Date, format = DateFormat.year_month_day)
    private LocalDate employmentTime;
    @Field(type = FieldType.Text)
    private String companyContactName;
    @Field(type = FieldType.Text)
    private String companyContactMobile;

}
