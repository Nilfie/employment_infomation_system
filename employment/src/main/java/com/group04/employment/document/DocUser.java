package com.group04.employment.document;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/5/8 14:28
 */

@Data
@TableName("public.user")
@Document(indexName = "users")
public class DocUser {
    @Id
    @TableField("userid")
    @TableId("userid")
    private String userId;
//    @Field(type = FieldType.Text, name = "useraccount")
    @TableField("useraccount")
    private String userAccount;
    @TableField("accountName")
    private String accountName;
    @TableField("userpwd")
    private String userPwd;
    @TableField("usertype")
    private Integer userType;
}
