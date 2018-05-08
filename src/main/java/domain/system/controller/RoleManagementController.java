package domain.system.controller;

import domain.shiro.controller.AbstractActionController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static domain.system.SystemWebForward.ROLEMANAGEMENTPANEL;
import static domain.system.SystemWebURLMapping.ROLE_MANAGEMENT_PAGE;

/**
 * 角色管理Controller
 */
@Controller
public class RoleManagementController extends AbstractActionController{


    /**
     * 去角色管理
     * @return ModelAndView
     */
    @RequestMapping(value = ROLE_MANAGEMENT_PAGE)
    public ModelAndView index(){
        return new ModelAndView(ROLEMANAGEMENTPANEL);
    }
}
