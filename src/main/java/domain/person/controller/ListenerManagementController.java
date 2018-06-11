package domain.person.controller;

import domain.person.entity.ListenerEntity;
import domain.person.service.ListenerManagementService;
import domain.shiro.controller.AbstractActionController;
import domain.shiro.entity.JsonResponseVO;
import domain.shiro.entity.PageQueryResult;
import domain.shiro.entity.ParamEntity;
import domain.shiro.service.UserSecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static domain.person.PersonWebForward.LISTEER_PAGE;
import static domain.person.PersonWebURLMapping.*;

/**
 * 听课人员管理controller
 */
@Controller
public class ListenerManagementController extends AbstractActionController{

    private static final Logger LOGGER = LoggerFactory.getLogger(ListenerManagementController.class);

    final private ListenerManagementService listenerManagementService;
    final private UserSecurityService userSecurityService;

    @Autowired
    public ListenerManagementController(ListenerManagementService listenerManagementService
            ,UserSecurityService userSecurityService){
        this.listenerManagementService = listenerManagementService;
        this.userSecurityService = userSecurityService;
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

        try {
            if (LOGGER.isDebugEnabled()){
                LOGGER.debug("听课人员新增,listenerName:{}",listenerEntity.getListenerName());
            }
            listenerEntity.setCreateUserId(getLoginId());
            final Boolean flag = listenerManagementService.addListener(listenerEntity);
            jsonResponseVO.setSuccess(flag);
        }catch (Exception e){
            LOGGER.error("业务处理异常:",e);
        }

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
        try {
            if (LOGGER.isDebugEnabled()){
                LOGGER.debug("听课人员修改,listenerName:{}",listenerEntity.getListenerName());
            }
            final Boolean flag = listenerManagementService.editListener(listenerEntity);
            jsonResponseVO.setSuccess(flag);
        }catch (Exception e){
            LOGGER.error("业务处理异常:",e);
        }

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
        try {
            if (LOGGER.isDebugEnabled()){
                LOGGER.debug("听课人员删除,id:{}",id);
            }
            final Boolean flag = listenerManagementService.deleteListener(id,getLoginId());
            jsonResponseVO.setSuccess(flag);
        }catch (Exception e){
            LOGGER.error("业务处理异常:",e);
        }


        return jsonResponseVO;
    }

    /**
     * 听课人员私有笔记授权
     * @param id id
     * @return JsonResponseVO
     */
    @RequestMapping(value = LISTENER_MAN_AUTHORIZATION)
    @ResponseBody
    public JsonResponseVO  authorizationListener(@PathVariable("id") Long id){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);
        try {
            if (LOGGER.isDebugEnabled()){
                LOGGER.debug("听课人员授权,id:{}",id);
            }
            final Boolean flag = listenerManagementService.authorizationListener(id,getLoginId());
            jsonResponseVO.setSuccess(flag);
        }catch (Exception e){
            LOGGER.error("业务处理异常:",e);
        }

        return jsonResponseVO;
    }

    /**
     * 私有笔记取消授权
     * @param id id
     * @return JsonResponseVO
     */
    @RequestMapping(value = LISTENER_MAN_AUTHORIZATION_NOT)
    @ResponseBody
    public JsonResponseVO authorizationListenerNot(@PathVariable("id") Long id){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);
        try {
            if (LOGGER.isDebugEnabled()){
                LOGGER.debug("听课人员解除授权,id:{}",id);
            }
            final Boolean flag = listenerManagementService.authorizationListenerNot(id,getLoginId());
            jsonResponseVO.setSuccess(flag);
        }catch (Exception e){
            LOGGER.error("业务处理异常:",e);
        }

        return jsonResponseVO;
    }

    @RequestMapping(value = "/paramters/{paramType}")
    @ResponseBody
    public List<ParamEntity> getParams(@PathVariable("paramType") String paramType){
        return userSecurityService.getParams(paramType);
    }

    /**
     * 机关进校园授权
     * @param id id
     * @return JsonResponseVO
     */
    @RequestMapping(value = LISTENER_MAN_ORGAN)
    @ResponseBody
    public JsonResponseVO  organListener(@PathVariable("id") Long id){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);
        try {
            if (LOGGER.isDebugEnabled()){
                LOGGER.debug("听课人员授权，机关进校园,id:{}",id);
            }
            final Boolean flag = listenerManagementService.organListener(id,getLoginId());
            jsonResponseVO.setSuccess(flag);
        }catch (Exception e){
            LOGGER.error("业务处理异常:",e);
        }

        return jsonResponseVO;
    }

    @RequestMapping(value = LISTENER_MAN_ORGANNOT)
    @ResponseBody
    public JsonResponseVO  organnotListener(@PathVariable("id") Long id){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);
        try {
            if (LOGGER.isDebugEnabled()){
                LOGGER.debug("听课人员解除授权，机关进校园,id:{}",id);
            }
            final Boolean flag = listenerManagementService.organnotListener(id,getLoginId());
            jsonResponseVO.setSuccess(flag);
        }catch (Exception e){
            LOGGER.error("业务处理异常:",e);
        }

        return jsonResponseVO;
    }
}
