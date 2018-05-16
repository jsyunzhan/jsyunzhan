package domain.listen.controller;

import domain.listen.service.QureManagementService;
import domain.shiro.controller.AbstractActionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static domain.listen.ListenWebForward.QURE_PAGE;
import static domain.listen.ListenWebURLMapping.QURE_MAN_PAGE;

/**
 * 按听课人员查询
 */
@Controller
public class QureManagementController extends AbstractActionController{

    private QureManagementService qureManagementService;

    @Autowired
    public QureManagementController(QureManagementService qureManagementService){
        this.qureManagementService = qureManagementService;
    }


    /**
     * 去按听课人员查询
     * @return ModelAndView
     */
    @RequestMapping(value = QURE_MAN_PAGE)
    public ModelAndView index(){
        return new ModelAndView(QURE_PAGE);
    }



}
