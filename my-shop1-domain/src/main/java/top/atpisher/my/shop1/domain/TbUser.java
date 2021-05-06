package top.atpisher.my.shop1.domain;

import top.atpisher.my.shop1.commons.persistence.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TbUser
 * @Author: l1957
 * @Date: 2021/4/3 22:09
 * @Description: TODO
 */
public class TbUser extends BaseEntity {
    private String username;
    private String password;
    private String phone;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "TbUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
