package cn.com.architecture.shop.web;


import cn.com.architecture.shop.config.Const;
import cn.com.architecture.shop.entity.Fund;
import cn.com.architecture.shop.entity.User;
import cn.com.architecture.shop.service.FundService;
import cn.com.architecture.shop.service.UserFundService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import utils.DateUtils;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping("/fund")
public class FundController extends BaseController{

    @Resource
    FundService fundService;

    @Resource
    UserFundService userFundService;


    @RequestMapping("/")
    public String index() {
        return "redirect:/fund/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<Fund> funds=fundService.getNormalFundList();
        model.addAttribute("funds", funds);
        return "fund/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "fund/fundAdd";
    }

    @RequestMapping("/add")
    public String add(Fund fund) {
        //User user = Session
        User user = getUser();
        if(user==null){
            //return ERROR;
            return "redirect:/user/list";
        }

        //fund.setPushTime(DateUtils.getCurrentTime());

        Fund dbFund = fundService.findFundById(fund.getId());

        try{
            if(dbFund==null){
                userFundService.save(fund,user);
            }else{
                dbFund.setStatus(Const.DataStatus.NORMAL);
                userFundService.update(dbFund,user);
            }
            //getUser().getFunds().add(fund);
        }catch (Exception e){
            logger.error("添加基金失败,",e);
        }


        return "redirect:/user/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
        Fund fund=fundService.findFundById(id);
        model.addAttribute("fund", fund);
        return "fund/fundEdit";
    }

    @RequestMapping("/edit")
    public String edit(Fund fund) {
        fundService.edit(fund);
        return "redirect:/user/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        fundService.delete(id);
        return "redirect:/fund/list";
    }

    @RequestMapping("/userDelete")
    public String userDelete(Long id) {
        try{
            userFundService.delete(id,getUser());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/user/list";
    }
}