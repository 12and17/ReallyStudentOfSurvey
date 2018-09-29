package club.small.service;

import club.small.dto.Empty;
import club.small.dto.Result;
import club.small.entity.Problem;

import java.util.List;

public interface MessengerService {
    /**
     * 增加一个问题
     * @param messengerAccount 信息员的账号
     * @param problemDiscribe 问题的描述
     * @param problemType 问题的类型
     * @return 返回封装的json数据
     */
    Result<Empty> sumbitOnrProblem(String messengerAccount, String problemDiscribe, String problemType);

    /**
     * 查找该信息员的所有未处理的问题
     * @param messengerAccount 信息员的账号
     * @return 返回未处理的问题列表
     */
    List<Problem> getAllUnsubmitProblem(String messengerAccount);

    /**
     * 查找该信息员的查找未处理的问题
     * @param messengerAccount 信息员的账号
     * @param describeWord 搜索的描述词
     * @return 返回未处理的问题列表
     */
    Result<List<Problem>> getSelectUnsubmitProblem(String messengerAccount, String describeWord);

    /**
     * 查找该信息员的所有被驳回的问题
     * @param messengerAccount 信息员的账号
     * @return 返回未处理的问题列表
     */
    Result<List<Problem>> getAllRejectProblem(String messengerAccount);

    /**
     * 根据模糊查询查找该信息员搜索的问题
     * @param messengerAccount 信息员的账号
     * @param describleWord 问题的描述符
     * @return 返回查询到得结果集
     */
    Result<List<Problem>> getSelectProblem(String messengerAccount, String describleWord);

    /**
     * 修改信息员的密码
     * @param messengerAccount 信息员的账号
     * @param password 新设置的密码
     * @return 空
     */
    Result<Empty> modifyOneMessenger(String messengerAccount, String password);

    /**
     * 根据发送过来的绑定邮箱的账号，获取验证码
     * @param mailAccount 前台传过来的邮箱码
     * @return 返回封装的验证码集合
     */
    Result<Empty> getVerificationCode(String mailAccount);

    /**
     * 更新信息员的邮箱
     * @param messengerAccount 信息员的账号
     * @param email 新设置的邮箱
     * @return 返回结果集
     */
    Result<Empty> updateMessengerEmail(String messengerAccount, String email);

    /**
     * 超找指定的条数已同意的问题
     * @param pageIndex 指定的页数
     * @param nums 指定的返回数量
     * @param messengerAccount 问题的类型
     * @return 返回查询结果的结果集
     */
    Result<List<Problem>> getOrderNumAlreadyProcessProblem(int pageIndex, int nums, String searchWord,  String messengerAccount);
}
