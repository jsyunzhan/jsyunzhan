package domain.system.controller;

import domain.shiro.controller.AbstractActionController;
import domain.shiro.entity.JsonResponseVO;
import domain.shiro.entity.PageQueryResult;
import domain.system.entity.RoleEntity;
import domain.system.service.RoleManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import static domain.system.SystemWebForward.ROLEMANAGEMENTPANEL;
import static domain.system.SystemWebURLMapping.*;

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
     * @param roleEntity 查询实体 roleEntity
     * @return PageQueryResult
     */
    @RequestMapping(value = ROLE_LIST_GET)
    @ResponseBody
    public PageQueryResult roleListInfo(RoleEntity roleEntity ){

        return roleManagementService.roleListInfo(roleEntity);
    }

    @RequestMapping(value = ROLE_ADD_POST)
    @ResponseBody
    public JsonResponseVO addRole(@RequestBody RoleEntity roleEntity){
        JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);

        final Boolean flag = roleManagementService.addRole(roleEntity);

        jsonResponseVO.setSuccess(flag);
        return jsonResponseVO;
    }
}
