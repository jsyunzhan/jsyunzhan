package domain.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static domain.message.MessageWebForward.PHONE_PAGE;
import static domain.message.MessageWebURLMapping.MESSAGE_PHONE_MAN_PAGE;

/**
 * 手机公告管理Controller
 */
@Controller
public class PhoneManagementController {

    @RequestMapping(value = MESSAGE_PHONE_MAN_PAGE)
    public ModelAndView index(){
        return new ModelAndView(PHONE_PAGE);
    }
}
