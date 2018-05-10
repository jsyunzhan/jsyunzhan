package domain.system.controller;

import domain.shiro.controller.AbstractActionController;
import domain.shiro.entity.PageQueryResult;
import domain.system.entity.RoleEntity;
import domain.system.service.RoleManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import static domain.system.SystemWebForward.ROLEMANAGEMENTPANEL;
import static domain.system.SystemWebURLMapping.ROLE_LIST_GET;
import static domain.system.SystemWebURLMapping.ROLE_MANAGEMENT_PAGE;

/**
 * 角色管理Controller
 */
@Controller
public class RoleManagementController extends AbstractActionController{

    private final RoleManagementService roleManagementService;

    @Autowired
    public RoleManagementController (RoleManagementService roleManagementService){
        this.roleManagementService = roleManagementService;
    }



    /**
     * 去角色管理
     * @return ModelAndView
     */
    @RequestMapping(value = ROLE_MANAGEMENT_PAGE)
    public ModelAndView index(){
        return new ModelAndView(ROLEMANAGEMENTPANEL);
    }

    /**
     * 角色管理分页
     * @param  查询实体
     * @return PageQueryResult
     */
    @RequestMapping(value = ROLE_LIST_GET)
    @ResponseBody
    public PageQueryResult roleListInfo(){
        RoleEntity roleEntity = new RoleEntity();
        return roleManagementService.roleListInfo(roleEntity);
    }
}
