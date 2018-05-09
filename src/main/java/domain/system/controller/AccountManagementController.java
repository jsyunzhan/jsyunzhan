package domain.system.controller;

import domain.shiro.controller.AbstractActionController;
import domain.shiro.entity.AccountEntity;
import domain.shiro.entity.PageQueryResult;
import domain.system.service.AccountManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import static domain.system.SystemWebForward.ACCOUNTMANAGEMENTPANEL;
import static domain.system.SystemWebURLMapping.ACCOUNT_MANAGEMENT_PAGE;
import static domain.system.SystemWebURLMapping.ACCOUT_LIST_GET;

/**
 * 用户管理Controller
 */
@Controller
public class AccountManagementController extends AbstractActionController{

    private final AccountManagementService accountManagementService;

    @Autowired
    public AccountManagementController(AccountManagementService accountManagementService){
        this.accountManagementService = accountManagementService;
    }

    /**
     * 去用户管理页面
     * @return ModelAndViewv
     */
    @RequestMapping(value = ACCOUNT_MANAGEMENT_PAGE)
    public ModelAndView index(){
        return new ModelAndView(ACCOUNTMANAGEMENTPANEL);
    }

    /**
     * 角色管理分页
     * @param accountEntity
     * @return
     */
    @RequestMapping(value = ACCOUT_LIST_GET)
    @ResponseBody
    public PageQueryResult accountListInof(AccountEntity accountEntity){


        return accountManagementService.accountListInof(accountEntity);

    }

}
