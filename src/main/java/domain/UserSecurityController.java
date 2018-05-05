package domain;

import domain.shiro.entity.JsonResponseVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by Mark.chen on 2018/04/26.
 * 用户认证
 */
@Controller
@RequestMapping(value = "/security")
public class UserSecurityController {

    /**
     * 去登录页面
     * @return ModelAndView
     */
    @RequestMapping(value = "/movetologin")
    public ModelAndView loginPage(){
        return new ModelAndView("login");
    }

    /**
     * 用户登录
     * @return Boolean
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public JsonResponseVO userLogin(@RequestParam("loginName") String loginName,
                             @RequestParam("password") String password){

        //登录信息验证
        final Subject securitySubject = SecurityUtils.getSubject();
        final JsonResponseVO result = new JsonResponseVO(Boolean.FALSE);

        try {

            final UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
            securitySubject.login(token);
            result.setSuccess(Boolean.TRUE);
            result.setReason("");
        }   catch (UnknownAccountException ex) {

            result.setReason("账号不存在");
        } catch (IncorrectCredentialsException ex) {

            result.setReason("密码错误");
        } catch (DisabledAccountException ex) {

            result.setReason("账号不可用");
        } catch (ExcessiveAttemptsException ex) {

            result.setReason("登录失败多次，账户锁定");
        } catch (AuthenticationException ex) {

            result.setReason("其他错误");
        } catch (Exception ex) {
            System.out.println("2");
        }

        return result;
    }

    /**
     * 去主页
     * @returnModelAndView ModelAndView
     */
    @RequestMapping(value = "/home")
    public ModelAndView toHomePage(){
        return new ModelAndView("home");
    }
}
