package top.atpisher.my.shop1.web.admin.service;

import top.atpisher.my.shop1.domain.TbContentCategory;

import java.util.List;

/**
 * @ClassName: TbContentCategoryService
 * @Author: l1957
 * @Date: 2021/5/15 19:39
 * @Description: TODO
 */
public interface TbContentCategoryService {
    List<TbContentCategory> selectAll();
}
