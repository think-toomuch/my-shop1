package top.atpisher.my.shop1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import top.atpisher.my.shop1.commons.persistence.BaseEntity;
import top.atpisher.my.shop1.commons.utils.RegexpUtils;

import javax.validation.constraints.Pattern;


/**
 * @ClassName: TbUser
 * @Author: l1957
 * @Date: 2021/4/3 22:09
 * @Description: TODO
 */
@Data
public class TbUser extends BaseEntity
{
    @Length(min = 3, max = 20, message = "用户名长度必须介于 6 和 20 之间")
    private String username;
    @JsonIgnore
    @Length(min = 3, max = 20, message = "密码长度必须介于 6 和 20 之间")
    private String password;
    @Pattern(regexp = RegexpUtils.PHONE, message = "手机号格式不正确")
    private String phone;
    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式不正确")
    private String email;

}
