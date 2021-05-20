package top.atpisher.my.shop1.web.admin.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import top.atpisher.my.shop1.commons.dto.BaseResult;
import top.atpisher.my.shop1.commons.dto.PageInfo;
import top.atpisher.my.shop1.commons.utils.RegexpUtils;
import top.atpisher.my.shop1.domain.TbContent;
import top.atpisher.my.shop1.domain.TbUser;
import top.atpisher.my.shop1.web.admin.dao.TbContentDao;
import top.atpisher.my.shop1.web.admin.service.TbContentService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: TbContentServiceImpl
 * @Author: l1957
 * @Date: 2021/5/17 08:47
 * @Description: TODO
 */
@Service
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectAll() {
        return tbContentDao.selectAll();
    }

    @Override
    public void insert(TbContent tbContent) {
        tbContentDao.insert(tbContent);
    }

    @Override
    public void delete(Long id) {
        tbContentDao.delete(id);
    }

    @Override
    public TbContent getById(Long id) {
        return tbContentDao.getById(id);
    }

    @Override
    public void update(TbContent tbContent) {
        tbContentDao.update(tbContent);
    }

    @Override
    public BaseResult save(TbContent tbContent) {
        BaseResult baseResult = checkTbContent(tbContent);
        //通过验证
        if(baseResult.getStatus()==BaseResult.STATUS_SUCCESS){
            tbContent.setUpdated(new Date());
            //新增用户
            if(tbContent.getId()==null){

                tbContent.setCreated(new Date());
                tbContentDao.insert(tbContent);
            }
            //编辑用户
            else{
                tbContentDao.update(tbContent);
            }
            baseResult.setMessage("保存用户信息成功");
        }

        return baseResult;
    }

    @Override
    public void deleteUsersById(String[] ids) {
        tbContentDao.deleteTbContentsById(ids);
    }

    @Override
    public PageInfo<TbContent> page(int start, int length, int draw, TbContent tbContent) {
        int count=tbContentDao.count(tbContent);

        Map<String,Object> parms=new HashMap<>();
        parms.put("start",start);
        parms.put("length",length);
        parms.put("tbContent",tbContent);

        PageInfo<TbContent> pageInfo=new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbContentDao.page(parms));

        return pageInfo;
    }

    @Override
    public int count(TbContent tbContent) {
        return tbContentDao.count(tbContent);
    }

    /**
     * 内容信息的有效性验证
     * @param tbContent
     */
    private BaseResult checkTbContent(TbContent tbContent){
        BaseResult baseResult=BaseResult.success();
        //非空验证
        if (tbContent.getCategoryId()==null){
            baseResult=BaseResult.fail("内容所属分类不能为空，请重新输入");
        }
        return baseResult;
    }

}
