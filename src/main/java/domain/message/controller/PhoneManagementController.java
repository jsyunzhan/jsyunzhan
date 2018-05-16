package domain.message.controller;

import domain.message.entity.PhoneEntity;
import domain.message.service.PhoneManagementService;
import domain.shiro.entity.PageQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import static domain.message.MessageWebForward.PHONE_PAGE;
import static domain.message.MessageWebURLMapping.MESSAGE_PHONE_MAN_LIST;
import static domain.message.MessageWebURLMapping.MESSAGE_PHONE_MAN_PAGE;

/**
 * 手机公告管理Controller
 */
@Controller
public class PhoneManagementController {

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
}
