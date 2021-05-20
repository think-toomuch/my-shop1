package top.atpisher.my.shop1.web.admin.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import top.atpisher.my.shop1.commons.dto.BaseResult;
import top.atpisher.my.shop1.commons.dto.PageInfo;
import top.atpisher.my.shop1.domain.TbContent;
import top.atpisher.my.shop1.domain.TbUser;
import top.atpisher.my.shop1.web.admin.service.TbContentService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName: ContentController
 * @Author: l1957
 * @Date: 2021/5/17 10:34
 * @Description: TODO
 */
@Controller
@RequestMapping(value = "content")
public class ContentController {
    @Autowired
    TbContentService tbContentService;
    @ModelAttribute
    public TbContent getTbContent(Long id){
        TbContent tbContent=null;
        //id不为空，从数据库获取
        if (id!=null){
            tbContent=tbContentService.getById(id);
        }else
            tbContent=new TbContent();
        return tbContent;
    }
    /**
     * 跳转到内容列表页
     * @param model
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<TbContent> tbContents = tbContentService.selectAll();
        model.addAttribute("tbContents",tbContents);
        model.addAttribute("tbContent",new TbContent());
        return "content_list";
    }

    /**
     *跳转到内容信息提交页面
     * @return
     */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form( TbContent tbContent,Model model){
        model.addAttribute("tbContent",tbContent);
        return "content_form";
    }

    /**
     *表单信息提交保存
     * @param tbContent
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbContent tbContent, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = tbContentService.save(tbContent);
        //保存成功
        if(baseResult.getStatus()==BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/content/list";
        }
        //保存失败
        else{
            model.addAttribute("baseResult",baseResult);
            return "content_form";
        }
    }

    /**
     * 删除信息
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult=null;
        //返回值了就删除成功
        if(StringUtils.isNoneBlank(ids)){
            baseResult=BaseResult.success("删除内容成功");
            String[] idArray=ids.split(",");
            tbContentService.deleteUsersById(idArray);
        }else
        {
            baseResult=BaseResult.fail("删除内容失败");
        }

        return baseResult;
    }

    /**
     * 分页查询
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<TbContent> page(HttpServletRequest request, TbContent tbContent){
        String strDraw=request.getParameter("draw");
        String strStart=request.getParameter("start");
        String strLength=request.getParameter("length");
        int draw = strDraw ==null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        //封装datatable需要的结果
        PageInfo<TbContent> page = tbContentService.page(start, length, draw,tbContent);

        return page;
    }

    /**
     * 显示内容详情
     * @param tbUser
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String showdetail(TbUser tbUser) {
        return "content_detail";
    }
}
