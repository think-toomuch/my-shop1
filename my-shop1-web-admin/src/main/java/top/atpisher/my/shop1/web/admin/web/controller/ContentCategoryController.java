package top.atpisher.my.shop1.web.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.atpisher.my.shop1.domain.TbContentCategory;
import top.atpisher.my.shop1.web.admin.service.TbContentCategoryService;

import java.util.ArrayList;
import java.util.List;

/**内容分类管理
 * @ClassName: ContentCategoryController
 * @Author: l1957
 * @Date: 2021/5/15 19:43
 * @Description: TODO
 */
@Controller
@RequestMapping(value = "content/category",method = RequestMethod.GET)
public class ContentCategoryController {
    @Autowired
    TbContentCategoryService tbContentCategoryService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<TbContentCategory> targetList=new ArrayList<>();
        List<TbContentCategory> sourceList=tbContentCategoryService.selectAll();
        softList(sourceList,targetList,0L);
        model.addAttribute("tbContentCategories",targetList);
        return "content_category_list";
    }

    /**
     * 排序
     * @param sourceList 数据源集合
     * @param targetList 排序后集合
     * @param parentId 父节点的id
     */
    private void softList(List<TbContentCategory> sourceList,List<TbContentCategory> targetList,Long parentId){
        for(TbContentCategory tbContentCategory:sourceList){
            if(tbContentCategory.getParentId().equals(parentId)){
                targetList.add(tbContentCategory);
                //判断有没有子节点，有的话继续追加
                if(tbContentCategory.getParent()){
                    for(TbContentCategory contentCategory:sourceList){
                        if(contentCategory.getParentId().equals(tbContentCategory.getId())){
                            softList(sourceList,targetList,tbContentCategory.getId());
                            break;
                        }
                    }
                }
            }
        }
    }
}
