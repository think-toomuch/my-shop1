package top.atpisher.my.shop1.web.admin.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import top.atpisher.my.shop1.commons.dto.BaseResult;
import top.atpisher.my.shop1.commons.dto.PageInfo;
import top.atpisher.my.shop1.commons.utils.RegexpUtils;
import top.atpisher.my.shop1.commons.validator.BeanValidator;
import top.atpisher.my.shop1.domain.TbUser;
import top.atpisher.my.shop1.web.admin.dao.TbUserDao;
import top.atpisher.my.shop1.web.admin.service.TbUserService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: TbUserServiceImpl
 * @Author: l1957
 * @Date: 2021/4/3 22:21
 * @Description: TODO
 */
@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserDao tbUserDao;

    /**
     * 查询全部用户信息
     *
     * @return
     */
    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }

    /**
     * 插入一条用户信息
     *
     * @param tbUser
     */
    @Override
    public void insert(TbUser tbUser) {
        tbUserDao.insert(tbUser);
    }

    /**
     * 根据id删除一条用户信息
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        tbUserDao.delete(id);
    }

    /**
     * 根据id获取一条用户信息
     *
     * @param id
     * @return
     */
    @Override
    public TbUser getById(Long id) {
        return tbUserDao.getById(id);
    }

    /**
     * 更新一条用户信息
     *
     * @param tbUser
     */
    @Override
    public void update(TbUser tbUser) {
        tbUserDao.update(tbUser);
    }

    /**
     * 登录验证
     *
     * @param email
     * @param password
     * @return
     */
    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = tbUserDao.getByEmail(email);
        if (tbUser != null) {
            //明文密码加密
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            //判断加密后的密码和数据库中存放的密码是否匹配，匹配则允许登录
            if (md5Password.equals(tbUser.getPassword())) {
                return tbUser;
            }
        }
        return null;
    }

    /**
     * 用户信息保存
     *
     * @param tbUser
     */
    @Override
    public BaseResult save(TbUser tbUser) {
        String validator = BeanValidator.validator(tbUser);
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        //验证通过
        else {
                tbUser.setUpdated(new Date());
                //新增用户
                if (tbUser.getId() == null) {
                    //密码加密
                    tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                    tbUser.setCreated(new Date());
                    tbUserDao.insert(tbUser);
                }
                //编辑用户
                else {
                    tbUserDao.update(tbUser);
                }
                return BaseResult.success("保存用户信息成功");
            }
    }

    /**
     * 根据id批量删除
     *
     * @param ids
     */
    @Override
    public void deleteUsersById(String[] ids) {
        tbUserDao.deleteUsersById(ids);
    }

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @param draw
     * @param tbUser
     * @return
     */
    @Override
    public PageInfo<TbUser> page(int start, int length, int draw, TbUser tbUser) {
        int count = tbUserDao.count(tbUser);

        Map<String, Object> parms = new HashMap<>();
        parms.put("start", start);
        parms.put("length", length);
        parms.put("tbUser", tbUser);

        PageInfo<TbUser> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbUserDao.page(parms));

        return pageInfo;
    }

    /**
     * 分页总条数
     *
     * @param tbUser
     * @return
     */
    @Override
    public int count(TbUser tbUser) {
        return tbUserDao.count(tbUser);
    }

    /**
     * 用户信息的有效性验证
     *
     * @param tbUser
     */
    private BaseResult checkTbUser(TbUser tbUser) {
        BaseResult baseResult = BaseResult.success();
        //非空验证
        if (StringUtils.isBlank(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱不能为空，请重新输入");
        } else if (!RegexpUtils.checkEmail(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱格式不正确，请重新输入");
        } else if (StringUtils.isBlank(tbUser.getPassword())) {
            baseResult = BaseResult.fail("密码不能为空，请重新输入");
        } else if (StringUtils.isBlank(tbUser.getUsername())) {
            baseResult = BaseResult.fail("姓名不能为空，请重新输入");
        } else if (StringUtils.isBlank(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机不能为空，请重新输入");
        } else if (!RegexpUtils.checkPhone(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机格式不正确，请重新输入");
        }
        return baseResult;
    }

}
