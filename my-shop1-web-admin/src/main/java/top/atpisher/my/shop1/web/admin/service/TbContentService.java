package top.atpisher.my.shop1.web.admin.service;

import top.atpisher.my.shop1.commons.dto.BaseResult;
import top.atpisher.my.shop1.commons.dto.PageInfo;
import top.atpisher.my.shop1.domain.TbContent;

import java.util.List;

/**
 * @ClassName: TbContentService
 * @Author: l1957
 * @Date: 2021/5/17 08:46
 * @Description: TODO
 */
public interface TbContentService {
    /**
     * 查询全部内容信息
     * @return
     */
    List<TbContent> selectAll();

    /**
     * 插入一条内容
     * @param tbContent
     */
    void insert(TbContent tbContent);

    /**
     * 根据id删除一条内容
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
     * @param TbContent
     */
    void update(TbContent TbContent);

    /**
     *提交保存功能
     * @param TbContent
     */
    BaseResult save(TbContent TbContent);

    /**
     * 批量删除
     * @param ids
     */
    void deleteUsersById(String[] ids);

    /**
     * 分页查询
     * @param start
     * @param length
     * @param draw
     * @param tbContent
     * @return
     */
    PageInfo<TbContent> page(int start, int length, int draw, TbContent tbContent);

    /**
     * 查询记录总条数
     * @return
     */
    int count(TbContent TbContent);
}
