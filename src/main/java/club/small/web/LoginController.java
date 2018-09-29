package club.small.web;

import club.small.dto.Result;
import club.small.entity.Charge;
import club.small.entity.Messenger;
import club.small.service.LoginService;
import club.small.service.MessengerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginService loginService;

    /**
     * 信息员登录
     * @param account 信息员账号
     * @param password 信息员密码
     * @return 返回查询结果集
     */
    @RequestMapping(value = "/messenger", method = RequestMethod.GET, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<HashMap<String, ? extends Object>> messengerLogin(String account, String password){
        return loginService.getOneMessenger(account, password);
    }

    /**
     * 管理员登录
     * @param account 管理员账号
     * @param password 管理员密码
     * @return 返回查询的结果集
     */
    @RequestMapping(value = "/charge", method = RequestMethod.GET, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<HashMap<String, ? extends Object>> chargeLogin(String account, String password){
        return loginService.isChargeLogin(account, password);
    }

    /**
     * 处理教师登录
     * @param account 处理教师账号
     * @param password 处理教师密码
     * @return 返回查询的结果集
     */
    @RequestMapping(value = "/processTeacher", method = RequestMethod.GET, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<HashMap<String, ? extends Object>> processTeacherLogin(String account, String password){
        return loginService.isProcessTeacherLogin(account, password);
    }

    /**
     * 领导登录
     * @param account 领导账号
     * @param password 领导密码
     * @return 返回查询的结果集
     */
    @RequestMapping(value = "/leader", method = RequestMethod.GET, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<HashMap<String, ? extends Object>> leaderLogin(String account, String password){
        return loginService.isLeaderLogin(account, password);
    }
}
