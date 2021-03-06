package top.atpisher.my.shop1.web.admin.service;

import top.atpisher.my.shop1.commons.dto.BaseResult;
import top.atpisher.my.shop1.commons.dto.PageInfo;
import top.atpisher.my.shop1.domain.TbUser;

import java.util.List;

/**
 * @ClassName: TbUserService
 * @Author: l1957
 * @Date: 2021/4/3 22:20
 * @Description: TODO
 */
public interface TbUserService {
    /**
     * 查询用户全部信息
     * @return
     */
    List<TbUser> selectAll();

    /**
     * 插入一个用户
     * @param tbUser
     */
    void insert(TbUser tbUser);

    /**
     * 根据id删除一个用户
     * @param id
     */
    void delete(Long id);
    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    TbUser getById(Long id);

    /**
     * 更新
     * @param tbUser
     */
    void update(TbUser tbUser);


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
     * 批量删除
     * @param ids
     */
    void deleteUsersById(String[] ids);

    /**
     * 分页查询
     * @param start
     * @param length
     * @return
     */
    PageInfo<TbUser> page(int start, int length,int draw,TbUser tbUser);

    /**
     * 查询记录总条数
     * @return
     */
    int count(TbUser tbUser);
}
