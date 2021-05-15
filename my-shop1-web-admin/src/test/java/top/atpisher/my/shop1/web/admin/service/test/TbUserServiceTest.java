package top.atpisher.my.shop1.web.admin.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;
import org.springframework.util.SocketUtils;
import top.atpisher.my.shop1.domain.TbUser;
import top.atpisher.my.shop1.web.admin.dao.TbUserDao;
import top.atpisher.my.shop1.web.admin.service.TbUserService;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: TbUserServiceTest
 * @Author: l1957
 * @Date: 2021/4/4 10:31
 * @Description: TODO
 */
/*
    为了让测试在Spring容器环境下执行。
    Spring的容器环境是啥呢？
    比如常见的 Service  Dao  Action ， 这些个东西，都在Spring容器里，junit需要将他们拿到，并且使用来测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml",
        "classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {
    @Autowired
    TbUserDao tbUserDao;
    @Autowired
    private TbUserService tbUserService;
    @Test
    public void TestSelectAll(){
        List<TbUser> tbUsers=tbUserService.selectAll();
        for(TbUser user:tbUsers)
            System.out.println(user.getUsername());
    }
    @Test
    public void testInsert() {
        TbUser tbUser = new TbUser();
        tbUser.setEmail("admin@qq.com");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("admin".getBytes()));
        tbUser.setPhone("15888888000");
        tbUser.setUsername("Lusife");
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());

        tbUserService.insert(tbUser);
    }

    @Test
    public void testDelete() {
        TbUser tbUser = new TbUser();
        tbUser.setId(37L);

        tbUserService.delete(tbUser.getId());
    }

    @Test
    public void testGetById() {
        TbUser tbUser =tbUserService.getById(36L);
        System.out.println(tbUser.toString()+"滋滋滋");
    }
    @Test
    public void testUpdate() {
        TbUser tbUser = tbUserService.getById(36L);
        tbUser.setUsername("Lusifer666");
        tbUserService.update(tbUser);
    }

    @Test
    public void testMd5(){
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
    }

}
