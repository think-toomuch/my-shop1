package top.atpisher.my.shop1.web.admin.dao;

import org.springframework.stereotype.Repository;
import top.atpisher.my.shop1.domain.TbUser;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: TbUserDao
 * @Author: l1957
 * @Date: 2021/4/3 22:17
 * @Description: TODO
 */
@Repository
public interface TbUserDao {
    /**
     *查询用户表全部信息
     * @return
     */
    List<TbUser> selectAll();
    /**
     * 插入一条数据
     * @param tbUser
     */
    void insert(TbUser tbUser);
    /**
     *  根据id删除
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
     * 模糊查询用户名
     * @param username
     * @return
     */
    List<TbUser> selectByUsername(String username);

    /**
     * 根据email查询用户信息
     * @param email
     * @return
     */
    TbUser getByEmail(String email);

    /**
     * 搜索
     * @param tbUser
     * @return
     */
    List<TbUser> search(TbUser tbUser);

    /**
     * 批量删除
     * @param ids
     */
    void deleteUsersById(String[] ids);

    /**
     * 分页查询
     * @param parms 需要2个参数,start/记录开始的位置,length/每页的记录数
     * @return
     */
    List<TbUser> page(Map<String,Object> parms);

    /**
     * 查询总条数
     * @return
     */
    int count();
}
