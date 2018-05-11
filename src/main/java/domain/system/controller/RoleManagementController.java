package domain.system.controller;

import com.alibaba.fastjson.JSONObject;
import domain.shiro.controller.AbstractActionController;
import domain.shiro.entity.JsonResponseVO;
import domain.shiro.entity.PageQueryResult;
import domain.shiro.entity.ResourceEntity;
import domain.system.entity.RoleEntity;
import domain.system.service.RoleManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import static com.alibaba.fastjson.JSON.toJSONString;
import static com.google.common.collect.Maps.newHashMapWithExpectedSize;
import static domain.shiro.entity.SystemConfig.ROWS;
import static domain.system.SystemWebForward.ROLEMANAGEMENTPANEL;
import static domain.system.SystemWebURLMapping.*;

/**
 * 角色管理Controller
 */
@Controller
public class RoleManagementController extends AbstractActionController{

    private final RoleManagementService roleManagementService;

    private static final String PARENT_ID = "parentId";
    private static final String EASYUI_PARENT_ID = "_parentId";

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

    /**
     * 新增
     */
    @RequestMapping(value = ROLE_ADD_POST)
    @ResponseBody
    public JsonResponseVO addRole(@RequestBody RoleEntity roleEntity){

        roleEntity.setCreateUserId(getLoginId());
        JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);

        final Boolean flag = roleManagementService.addRole(roleEntity);

        jsonResponseVO.setSuccess(flag);
        return jsonResponseVO;
    }

    /*
    验证roleName是否重名
     */
    @RequestMapping(value = ROLE_CHECK_ROLE_NAME)
    @ResponseBody
    public Boolean checkRoleName(@RequestParam("roleName") String roleName,
    @RequestParam(value = "id",required = false) Long id){
        return roleManagementService.checkRoleName(id,roleName);
    }

    /*
    修改
     */
    @RequestMapping(value = ROLE_EDIT_POST)
    @ResponseBody
    public JsonResponseVO editRole(@RequestBody RoleEntity roleEntity){
        roleEntity.setUpdateUserId(getLoginId());
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);
        final Boolean flag = roleManagementService.editRole(roleEntity);
        jsonResponseVO.setSuccess(flag);
        return jsonResponseVO;
    }

    /**
     * 删除
     */
    @RequestMapping(value = ROLE_DELETE_GET)
    @ResponseBody
    public JsonResponseVO deleRole(@PathVariable("id") Long id){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);
        final Boolean flag = roleManagementService.deleRole(id,getLoginId());
        jsonResponseVO.setSuccess(flag);
        return jsonResponseVO;
    }


    @RequestMapping(value = RESOURCES_LIST_GET)
    @ResponseBody
    public JSONObject resourceList(){

        final List<ResourceEntity> list = roleManagementService.resourceList();

        long root = 0;
        list.get(0).setParentId(root);


        final Map<String, Object> organizationMap = newHashMapWithExpectedSize(1);
        organizationMap.put(ROWS, list);
        String res = toJSONString(organizationMap);
        res = res.replaceAll(PARENT_ID, EASYUI_PARENT_ID);
        return JSONObject.parseObject(res);
    }
}
