package top.atpisher.my.shop1.web.admin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.atpisher.my.shop1.domain.TbContentCategory;

import java.util.List;

/**
 * @ClassName: TbContentCategoryDao
 * @Author: l1957
 * @Date: 2021/5/15 19:34
 * @Description: TODO
 */
@Repository
@Mapper
public interface TbContentCategoryDao {
    List<TbContentCategory> selectAll();
}
