package top.atpisher.my.shop1.web.admin.service;

import top.atpisher.my.shop1.commons.dto.BaseResult;
import top.atpisher.my.shop1.domain.TbUser;

import java.util.List;

/**
 * @ClassName: TbUserService
 * @Author: l1957
 * @Date: 2021/4/3 22:20
 * @Description: TODO
 */
public interface TbUserService {
    public List<TbUser> selectAll();

    public void insert(TbUser tbUser);

    void delete(Long id);

    /*
   通过id查询用户信息
    */
    TbUser getById(Long id);
    /*
    更新
     */
    void update(TbUser tbUser);

    /**
     * 模糊查询用户名
     * @param username
     * @return
     */
    List<TbUser> selectByUsername(String username);

    /**
     * 登录验证
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email,String password);

    /**
     *提交保存功能
     * @param tbUser
     */
    BaseResult save(TbUser tbUser);

    /**
     *
     * @param tbUser
     * @return
     */
    List<TbUser> search(TbUser tbUser);
    /**
     * 批量删除
     * @param ids
     */
    void deleteUsersById(String[] ids);
}
