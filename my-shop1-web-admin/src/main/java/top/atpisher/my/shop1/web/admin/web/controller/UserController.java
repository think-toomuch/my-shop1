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
import top.atpisher.my.shop1.domain.TbUser;
import top.atpisher.my.shop1.web.admin.service.TbUserService;

import java.util.List;

/**用户管理
 * @ClassName: UserController
 * @Author: l1957
 * @Date: 2021/4/6 16:25
 * @Description: TODO
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private TbUserService tbUserService;

//    @ModelAttribute
//    public TbUser getTbUser(Long id){
//        TbUser tbUser=null;
//        //id不为空，从数据库获取
//        if (id!=null){
//            tbUser=tbUserService.getById(id);
//        }else
//            tbUser=new TbUser();
//        return tbUser;
//    }
    /**
     * 跳转到用户列表页
     * @param model
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers",tbUsers);
        model.addAttribute("tbUser",new TbUser());
        return "user_list";
    }

    /**
     *跳转到用户信息提交页面
     * @return
     */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form( TbUser tbUser,Model model){
        model.addAttribute("tbUser",tbUser);
        return "user_form";
    }

    /**
     *用户表单信息提交
     * @param tbUser
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model,RedirectAttributes redirectAttributes){
        BaseResult baseResult = tbUserService.save(tbUser);
        //保存成功
        if(baseResult.getStatus()==BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/user/list";
        }
        //保存失败
        else{
            model.addAttribute("baseResult",baseResult);
            return "user_form";
        }
    }

    /**
     * 返回所有搜索到的用户信息
     * @param tbUser
     * @param model
     * @return
     */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String search(TbUser tbUser, Model model){
        List<TbUser> tbUsers=tbUserService.search(tbUser);
        model.addAttribute("tbUsers",tbUsers);
        return "user_list";
    }
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult=null;
        //返回值了就删除成功，小缺陷，肚子饿了，先吃饭
        if(StringUtils.isNoneBlank(ids)){
            baseResult=BaseResult.success("删除数据成功");
            String[] idArray=ids.split(",");
            tbUserService.deleteUsersById(idArray);
        }else
        {
            baseResult=BaseResult.fail("删除失败");
        }

        return baseResult;
    }
}
