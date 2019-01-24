package com.xzy.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;
@Data
public class UserVo {
    @NotEmpty(message = "用户名不能为空")
    @Pattern(regexp = "\\w{6,10}",message = "用户名只能包含数字、字母、下划线，且长度为6-10位")
    private String username;

    @Length(min = 4,max = 10,message = "密码必须为4-10位")
    private String password;

    @Length(min = 4,max = 10,message = "密码必须为4-10位")
    private String newPassword;

//    @Pattern(regexp = "(139|133|131)\\d{8}",message = "手机号码格式不正确")
    private String phone;
    @Email(message = "邮箱格式不正确")
    private String email;

    @Range(min = 1,max = 120,message = "年龄必须在1-120之间")
    private Integer age;


}
