package top.atpisher.my.shop1.web.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.atpisher.my.shop1.domain.TbContentCategory;
import top.atpisher.my.shop1.web.admin.dao.TbContentCategoryDao;
import top.atpisher.my.shop1.web.admin.service.TbContentCategoryService;

import java.util.List;

/**
 * @ClassName: TbContentCategoryServiceImpl
 * @Author: l1957
 * @Date: 2021/5/15 19:41
 * @Description: TODO
 */
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    @Autowired
    TbContentCategoryDao tbContentCategoryDao;

    @Override
    public List<TbContentCategory> selectAll() {
        return tbContentCategoryDao.selectAll();
    }

    @Override
    public List<TbContentCategory> selectByPid(Long pid) {
        return tbContentCategoryDao.selectByPid(pid);
    }
}
