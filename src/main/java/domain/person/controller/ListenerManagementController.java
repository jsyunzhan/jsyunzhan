package domain.person.controller;

import domain.person.entity.ListenerEntity;
import domain.person.service.ListenerManagementService;
import domain.shiro.controller.AbstractActionController;
import domain.shiro.entity.JsonResponseVO;
import domain.shiro.entity.PageQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import static domain.person.PersonWebForward.LISTEER_PAGE;
import static domain.person.PersonWebURLMapping.*;

/**
 * 听课人员管理controller
 */
@Controller
public class ListenerManagementController extends AbstractActionController{

    private ListenerManagementService listenerManagementService;

    @Autowired
    public ListenerManagementController(ListenerManagementService listenerManagementService){
        this.listenerManagementService = listenerManagementService;
    }

    @RequestMapping(value = LISTENER_MAN_PAGE)
    public ModelAndView index(){
        return new ModelAndView(LISTEER_PAGE);
    }

    /**
     * 听课人员管理分页
     * @param listenerEntity 分页实体
     * @return PageQueryResult
     */
    @RequestMapping(value = LISTENER_MAN_LIST)
    @ResponseBody
    public PageQueryResult listenerList(ListenerEntity listenerEntity){


        return listenerManagementService.listenerList(listenerEntity);
    }

    /**
     * 听课人员新增
     * @param listenerEntity 新增实体
     * @return JsonResponseVO
     */
    @RequestMapping(value = LISTENER_MAN_ADD)
    @ResponseBody
    public JsonResponseVO addListener(@RequestBody ListenerEntity listenerEntity){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);
        listenerEntity.setCreateUserId(getLoginId());
        final Boolean flag = listenerManagementService.addListener(listenerEntity);
        jsonResponseVO.setSuccess(flag);
        return jsonResponseVO;
    }

    /**
     * 听课人员修改
     * @param listenerEntity 修改实体
     * @return JsonResponseVO
     */
    @RequestMapping(value = LISTENER_MAN_EDIT)
    @ResponseBody
    public JsonResponseVO editListener(@RequestBody ListenerEntity listenerEntity){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);
        listenerEntity.setUpdateUserId(getLoginId());
        final Boolean flag = listenerManagementService.editListener(listenerEntity);
        jsonResponseVO.setSuccess(flag);
        return jsonResponseVO;
    }

    /**
     * 听课人员删除
     * @param id id
     * @return JsonResponseVO
     */
    @RequestMapping(value = LISTENER_MAN_DELETE)
    @ResponseBody
    public JsonResponseVO deleteListener(@PathVariable("id") Long id){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);
        final Boolean flag = listenerManagementService.deleteListener(id,getLoginId());
        jsonResponseVO.setSuccess(flag);
        return jsonResponseVO;
    }

    /**
     * 听课人员授权
     * @param id id
     * @return JsonResponseVO
     */
    @RequestMapping(value = LISTENER_MAN_AUTHORIZATION)
    @ResponseBody
    public JsonResponseVO  authorizationListener(@PathVariable("id") Long id){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);
        final Boolean flag = listenerManagementService.authorizationListener(id,getLoginId());
        jsonResponseVO.setSuccess(flag);
        return jsonResponseVO;
    }

    @RequestMapping(value = LISTENER_MAN_AUTHORIZATION_NOT)
    @ResponseBody
    public JsonResponseVO authorizationListenerNot(@PathVariable("id") Long id){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);
        final Boolean flag = listenerManagementService.authorizationListenerNot(id,getLoginId());
        jsonResponseVO.setSuccess(flag);
        return jsonResponseVO;
    }
}
