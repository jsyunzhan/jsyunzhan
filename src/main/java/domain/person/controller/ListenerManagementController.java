package domain.person.controller;

import domain.person.entity.ListenerEntity;
import domain.person.service.ListenerManagementService;
import domain.shiro.controller.AbstractActionController;
import domain.shiro.entity.PageQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import static domain.person.PersonWebForward.LISTEER_PAGE;
import static domain.person.PersonWebURLMapping.LISTENER_MAN_LIST;
import static domain.person.PersonWebURLMapping.LISTENER_MAN_PAGE;

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
}
