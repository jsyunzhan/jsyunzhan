package domain.system.controller;

import domain.shiro.controller.AbstractActionController;
import domain.shiro.entity.AccountEntity;
import domain.shiro.entity.JsonResponseVO;
import domain.shiro.entity.PageQueryResult;
import domain.system.entity.RoleEntity;
import domain.system.service.AccountManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static domain.system.SystemWebForward.ACCOUNTMANAGEMENTPANEL;
import static domain.system.SystemWebURLMapping.*;

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
     * 用户管理分页
     * @param accountEntity 分页实体
     * @return PageQueryResult
     */
    @RequestMapping(value = ACCOUT_LIST_GET)
    @ResponseBody
    public PageQueryResult accountListInof(AccountEntity accountEntity){
        return accountManagementService.accountListInof(accountEntity);
    }

    /**
     * 获取所有角色-供下拉框加载
     * @return List<RoleEntity>
     */
    @RequestMapping(value = GET_ALL_ROLE)
    @ResponseBody
    public List<RoleEntity> getAllRole(){
        return accountManagementService.getAllRole();
    }

    /**
     * 用户添加
     * @param accountEntity 添加实体
     * @return JsonResponseVO
     */
    @RequestMapping(value = ACCOUNT_ADD_POST)
    @ResponseBody
    public JsonResponseVO accountAdd(@RequestBody AccountEntity accountEntity){
        accountEntity.setCreateUserId(getLoginId());
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);
        final Boolean flage = accountManagementService.accountAdd(accountEntity);
        jsonResponseVO.setSuccess(flage);
        return jsonResponseVO;
    }

    /**
     * 用户修改
     * @param accountEntity 修改实体
     * @return JsonResponseVO
     */
    @RequestMapping(value = ACCOUNT_EDIT_POST)
    @ResponseBody
    public JsonResponseVO accountEdit(@RequestBody AccountEntity accountEntity){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);
        accountEntity.setUpdateUserId(getLoginId());
        final Boolean flag = accountManagementService.accountEdit(accountEntity);

        return jsonResponseVO;

    }

    @RequestMapping(value = ACCOUNT_DELETE_POST)
    @ResponseBody
    public JsonResponseVO accountDelete(@PathVariable("id") Long id){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);

        final Boolean flag = accountManagementService.accountDelete(id,getLoginId());
        jsonResponseVO.setSuccess(flag);
        return jsonResponseVO;
    }


    /**
     * 验证登录名是否，重复
     * @param id id
     * @param loginName 登录名
     * @return Boolean 
     */
    @RequestMapping(value = CHECK_LOGIN_NAME)
    @ResponseBody
    public Boolean checkLoginName(@RequestParam(value = "id",required = false) Long id,
                                         @RequestParam("loginName") String loginName){
        return accountManagementService.checkLoginName(id,loginName);
    }
}
