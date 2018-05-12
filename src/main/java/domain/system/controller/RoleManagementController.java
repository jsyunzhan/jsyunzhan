package domain.system.controller;

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

import static domain.shiro.entity.SystemConfig.ZERO;
import static domain.system.SystemWebForward.ROLEMANAGEMENTPANEL;
import static domain.system.SystemWebURLMapping.*;

/**
 * 角色管理Controller
 */
@Controller
public class RoleManagementController extends AbstractActionController{

    private final RoleManagementService roleManagementService;

    private static final String RESOURCE_NAME = "resourceName";
    private static final String PARENT_ID = "parentId";

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
    public List resourceList(){

        final List<ResourceEntity> list = roleManagementService.resourceList();

//        long root = 0;
//        list.get(0).setParentId(root);
//
//
//        final Map<String, Object> organizationMap = newHashMapWithExpectedSize(1);
//        organizationMap.put(ROWS, list);
//        String res = toJSONString(organizationMap);
//        res = res.replaceAll(PARENT_ID, EASYUI_PARENT_ID);
//        return JSONObject.parseObject(res);

        List treeList = null;
        try {
            treeList = createTreeGridTree(list, ZERO, ResourceEntity.class,
                    RESOURCE_NAME, PARENT_ID);
        } catch (ClassNotFoundException e) {
//            LOGGER.error("构建树反射未找到类异常:", e);
        } catch (IllegalAccessException e) {
//            LOGGER.error("构建树反射安全权限异常:", e);
        } catch (NoSuchFieldException e) {
//            LOGGER.error("构建树反射未找到文件异常:", e);
        }
        return treeList;
    }
}
