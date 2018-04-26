package domain.Test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class TestController {

    @RequestMapping(value = "/list")
    public ModelAndView list()
    {
        ModelAndView mv=new ModelAndView("/show");

        return mv;
    }
}
