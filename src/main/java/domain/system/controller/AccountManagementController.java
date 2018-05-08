package domain.system.controller;

import domain.shiro.controller.AbstractActionController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static domain.system.SystemWebForward.ACCOUNTMANAGEMENTPANEL;
import static domain.system.SystemWebURLMapping.ACCOUNT_MANAGEMENT_PAGE;

/**
 * 用户管理Controller
 */
@Controller
public class AccountManagementController extends AbstractActionController{

    /**
     * 去用户管理页面
     * @return ModelAndViewv
     */
    @RequestMapping(value = ACCOUNT_MANAGEMENT_PAGE)
    public ModelAndView index(){
        return new ModelAndView(ACCOUNTMANAGEMENTPANEL);
    }

}
