package top.atpisher.my.shop1.web.admin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.atpisher.my.shop1.domain.TbContent;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: TbContentDao
 * @Author: l1957
 * @Date: 2021/5/17 08:45
 * @Description: TODO
 */
@Repository
@Mapper
public interface TbContentDao {
    /**
     *查询内容表全部信息
     * @return
     */
    List<TbContent> selectAll();
    /**
     * 插入一条数据
     * @param tbContent
     */
    void insert(TbContent tbContent);
    /**
     *  根据id删除一条内容
     * @param id
     */
    void delete(Long id);

    /**
     * 通过id查询内容信息
     * @param id
     * @return
     */
    TbContent getById(Long id);

    /**
     * 更新
     * @param tbContent
     */
    void update(TbContent tbContent);


    /**
     * 批量删除
     * @param ids
     */
    void deleteTbContentsById(String[] ids);

    /**
     * 分页查询
     * @param parms 需要2个参数,start/记录开始的位置,length/每页的记录数
     * @return
     */
    List<TbContent> page(Map<String,Object> parms);

    /**
     * 查询总条数
     * @return
     */
    int count(TbContent tbContent);
}
