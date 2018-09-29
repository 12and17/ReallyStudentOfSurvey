package club.small.service;

import club.small.dto.Empty;
import club.small.dto.Result;
import club.small.entity.Charge;
import club.small.entity.ClassInfo;
import club.small.entity.Messenger;
import club.small.entity.Problem;

import java.util.List;

public interface ChargeService {
    /**
     * 增加一个管理员
     * @param chargeAccount 管理员的账号
     * @param chargePassword 管理员的密码
     * @param chargeName 管理员的姓名
     * @return 结果集
     */
    Result<Empty> addOneCharge(String chargeAccount, String chargePassword, String chargeName);

    /**
     * 修改管理员的密码
     * @param chargeAccount 管理员的账号
     * @param password 新设置的密码
     * @return 空
     */
    Result<Empty> modifyOneCharge(String chargeAccount, String password);

    /**
     * 更新信息员的邮箱
     * @param chargeAccount 信息员的账号
     * @param email 新设置的邮箱
     * @return 返回结果集
     */
    Result<Empty> updateChargeEmail(String chargeAccount, String email);

    /**
     * 超找指定的条数以及类型未分配教师的问题
     * @param pageIndex 指定的页数
     * @param nums 指定的返回数量
     * @param problemType 问题的类型
     * @return 返回查询结果的结果集
     */
    Result<List<Problem>> getOrderNumProblem(int pageIndex, int nums, String problemType, String searchWord);

    /**
     * 查找同样类型的所有的处理教师
     * @param problemType 问题的类型
     * @return 返回结果集
     */
    Result<List<Empty>> getAllSameTeacher(String problemType);

    /**
     * 给该问题分配一个处理教师
     * @param problemId 问题的id
     * @param teacherAccount 教师的账号
     * @return 返回结果集
     */
    Result<Empty> assignTeacher(int problemId, String teacherAccount);

    /**
     * 问题不合格，驳回给该学生
     * @param problemId 问题的id
     * @param rejectReason 驳回的理由
     * @return 返回结果集
     */
    Result<Empty> rejectToStudent(int problemId, String rejectReason);

    /**
     * 查找所有的班级，以及它们各自的信息员数量
     * @return 返回封装的结果集
     */
    Result<List<ClassInfo>> getAllClass();

    /**
     * 增加一个信息员的账号
     * @param classId 信息员的班级id
     * @param messengerAccount 信息员的账号
     * @param messengerPassword 信息员的密码
     * @return 返回结果集
     */
    Result<Empty> addOneMessenger(int classId, String messengerAccount, String messengerPassword);

    /**
     * 删除一个信息员
     * @param messengerAccount 信息员的账号
     * @return 返回封装的结果集
     */
    Result<Empty> detoryOneMessenger(String messengerAccount);

    /**
     * 获得一个信息员的信息
     * @param messengerAccount 信息员的账号
     * @return 返回封装的信息员的结果集
     */
    Result<Messenger> getOneMessengerInfo(String messengerAccount);

    /**
     * 超找指定的条数以及类型未分配教师的问题
     * @param pageIndex 指定的页数
     * @param nums 指定的返回数量
     * @param problemType 问题的类型
     * @return 返回查询结果的结果集
     */
    Result<List<Problem>> getOrderNumUnconfirmProblem(int pageIndex, int nums, String problemType, String searchWord);

    /**
     * 确认一个问题
     * @param problemId 问题的id
     * @return 返回结果集
     */
    Result<Empty> confirmOneProblem(int problemId);

    /**
     * 问题处理不合格，驳回给该教师
     * @param problemId 问题的id
     * @param toTeacherReason 驳回的理由
     * @return 返回结果集
     */
    Result<Empty> toTeacherProblem(int problemId, String toTeacherReason);
}
