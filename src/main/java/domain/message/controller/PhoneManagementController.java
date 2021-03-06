package domain.message.controller;

import domain.message.entity.PhoneEntity;
import domain.message.service.PhoneManagementService;
import domain.shiro.controller.AbstractActionController;
import domain.shiro.entity.JsonResponseVO;
import domain.shiro.entity.PageQueryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import static domain.message.MessageWebForward.PHONE_PAGE;
import static domain.message.MessageWebURLMapping.*;

/**
 * 手机公告管理Controller
 */
@Controller
public class PhoneManagementController extends AbstractActionController{
    private static final Logger LOGGER = LoggerFactory.getLogger(PhoneManagementController.class);

    final private PhoneManagementService phoneManagementService;

    @Autowired
    public PhoneManagementController(PhoneManagementService phoneManagementService){
        this.phoneManagementService = phoneManagementService;
    }

    /**
     * 去手机管理页面
     * @return ModelAndView
     */
    @RequestMapping(value = MESSAGE_PHONE_MAN_PAGE)
    public ModelAndView index(){
        return new ModelAndView(PHONE_PAGE);
    }

    /**
     * 手机消息管理页面分页
     * @return PageQueryResult
     */
    @RequestMapping(value = MESSAGE_PHONE_MAN_LIST)
    @ResponseBody
    public PageQueryResult phoneMessInfo(PhoneEntity phoneEntity){
        return  phoneManagementService.phoneMessInfo(phoneEntity);
    }

    /**
     * 手机消息增加
     * @param phoneEntity 新增实体
     * @return JsonResponseVO
     */
    @RequestMapping(value = MESSAGE_PHONE_MAN_ADD)
    @ResponseBody
    public JsonResponseVO phoneMessAdd(@RequestBody PhoneEntity phoneEntity){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);

        phoneEntity.setCreateUserId(getLoginId());

        try {

            if (LOGGER.isDebugEnabled()){
                LOGGER.debug("手机消息新增,title:{}",phoneEntity.getTitle());
            }
            final Boolean flag = phoneManagementService.phoneMessAdd(phoneEntity);
            jsonResponseVO.setSuccess(flag);
        }catch (Exception e){
            LOGGER.error("业务处理异常:",e);
        }

        return jsonResponseVO;
    }

    /**
     * 手机消息管理修改
     * @param phoneEntity 修改实体
     * @return JsonResponseVO
     */
    @RequestMapping(value = MESSAGE_PHONE_MAN_EDIT)
    @ResponseBody
    public JsonResponseVO phoneMessEdit(@RequestBody PhoneEntity phoneEntity){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);

        phoneEntity.setUpdateUserId(getLoginId());

        try {
            if (LOGGER.isDebugEnabled()){
                LOGGER.debug("手机消息修改,title:{}",phoneEntity.getTitle());
            }
            final Boolean flag = phoneManagementService.phoneMessEdit(phoneEntity);
            jsonResponseVO.setSuccess(flag);
        }catch (Exception e){
            LOGGER.error("业务处理异常:",e);
        }

        return jsonResponseVO;
    }

    @RequestMapping(value = MESSAGE_PHONE_MAN_DELETE)
    @ResponseBody
    public JsonResponseVO phoneMessDelete(@PathVariable("id") Long id){
        final JsonResponseVO jsonResponseVO = new JsonResponseVO(Boolean.FALSE);

        try {
            if (LOGGER.isDebugEnabled()){
                LOGGER.debug("手机消息删除,id:{}",id);
            }
            final Boolean flag = phoneManagementService.phoneMessDelete(id,getLoginId());
            jsonResponseVO.setSuccess(flag);
        }catch (Exception e){
            LOGGER.error("业务处理异常:",e);
        }

        return jsonResponseVO;
    }
}
