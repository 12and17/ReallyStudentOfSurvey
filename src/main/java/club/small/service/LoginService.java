package club.small.service;

import club.small.dto.Result;
import club.small.entity.Charge;
import club.small.entity.Messenger;

import java.util.HashMap;
import java.util.Map;

public interface LoginService {
    /**
     * 根据信息员的账号返回一个信息员
     * @param account 信息员的账号
     * @param password 信息员的密码
     * @return 返回一个封装json数据
     */
    Result<HashMap<String, ? extends Object>> getOneMessenger(String account, String password);

    /**
     * 判断登陆的管理员账号密码是否正确
     * @param chargeAccount 管理员的账号
     * @param chargePassword 管理员的密码
     * @return 返回该管理员的信息的结果集
     */
    Result<HashMap<String, ? extends Object>> isChargeLogin(String chargeAccount, String chargePassword);

    /**
     * 判断登陆的处理教师的账号密码是否正确
     * @param processTeacherAccount 处理教师的账号
     * @param processTeacherPassword 处理教师的面
     * @return 返回封装的结果集
     */
    Result<HashMap<String, ? extends  Object>> isProcessTeacherLogin(String processTeacherAccount, String processTeacherPassword);

    /**
     * 判断登陆的领导的账号密码是否正确
     * @param leaderAccount 领导的账号
     * @param leaderPassword 领导的密码
     * @return 返回封装的结果集
     */
    Result<HashMap<String, ? extends Object>> isLeaderLogin(String leaderAccount, String leaderPassword);

}
