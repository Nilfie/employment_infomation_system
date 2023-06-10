package com.group04.employment.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Arrays;
import java.util.List;
/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/5/8 14:28
 */

@Data
public class Recruit {
    @Id
    private String recruitId;
    private String position;
    private String salary;
    private String location;
    private String label;
    @TableField(exist = false)
    private List<String> labelList;
    private String workExperience;
    private String educationBackground;
    private Integer should;
    private String deliver;
    private String responsible;
    @TableField(exist = false)
    private List<String> responsibleList;

    private String requirement;
    @TableField(exist = false)
    private List<String> requirementList;

    public List<String> getLabelList() {
        List<String> subList= Arrays.asList(getLabel().split(";"));
        return subList;
    }

    public void setLabelList(List<String> labelList) {
        this.labelList = labelList;
    }

    public List<String> getResponsibleList() {
        List<String> subList= Arrays.asList(getResponsible().split(";"));
        return subList;
    }

    public void setResponsibleList(List<String> responsibleList) {
        this.responsibleList = responsibleList;
    }

    public List<String> getRequirementList() {
        List<String> subList= Arrays.asList(getRequirement().split(";"));
        return subList;
    }
    public void setRequirementList(List<String> requirementList) {
        this.requirementList = requirementList;
    }
}
