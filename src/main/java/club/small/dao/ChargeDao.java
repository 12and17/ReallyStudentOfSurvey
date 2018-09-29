package club.small.dao;

import club.small.entity.*;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface ChargeDao {
    /**
     * 增加一个管理教师
     * @param chargeAccount 管理教师的账号
     * @param chargePassword 设置的密码
     * @param chargeName 教师的姓名
     */
    void addOneAdministrator(@Param("chargeAccount")String chargeAccount, @Param("chargePassword") String chargePassword, @Param("chargeName") String chargeName);

    /**
     * 根据一个管理人员的账号，返回一个管理员
     * @param chargeAccount 管理员的账号
     * @return 返回一个管理员
     */
    Charge getOneCharge(String chargeAccount);

    /**
     * 查找未分配教师的问题的数量
     * @return 返回查找的数量
     */
    int getUnassignNum();

    /**
     * 查找未确认的问题的数量
     * @return 返回查找的数量
     */
    int getNoComfirme();

    /**
     * 查找未分配老师的教学问题数量
     * @return 返回查找的数量
     */
    int getUnassignOfTeachNum();

    /**
     * 查找未分配老师的设备问题数量
     * @return 返回查找的数量
     */
    int getUnassignOfEquipmentNum();

    /**
     * 查找未分配老师的需求和建议问题数量
     * @return 返回查找的数量
     */
    int getUnassignOfDemandNum();

    /**
     * 查找未确认的教学问题数量
     * @return 返回查找的数量
     */
    int getNoComfirmeOfTeachNum();

    /**
     * 查找未确认的设备问题数量
     * @return 返回查找的数量
     */
    int getNoComfirmeOfEquipmentNum();

    /**
     * 查找未确认的需求和建议问题数量
     * @return 返回查找的数量
     */
    int getNoComfirmeOfDemandNum();

    /**
     * 修改管理员的密码
     * @param chargeAccount 管理员的账号
     * @param password 管理员新设置的密码
     */
    void updateOneCharge(@Param("chargeAccount")String chargeAccount, @Param("password")String password);

    /**
     * 更新管理员的邮箱
     * @param chargeAccount 管理员的账号
     * @param email 管理员新设置的邮箱
     */
    void updateChargeEmail(@Param("chargeAccount")String chargeAccount, @Param("email")String email);

    /**
     * 返回从指定的条数开始返回指定的问题
     * @param startIndex 开始的序列号
     * @param nums 返回的数量
     * @return 返回的问题的结果集
     */
    List<Problem> listUnassignProblem(@Param("startIndex") int startIndex, @Param("nums") int nums, @Param("type") String type, @Param("searchWord") String searchWord);

    /**
     * 查找该问题的信息员班级
     * @param messengerAccount 信息员的账号
     * @return 返回班级
     */
    String getProblemClassName(String messengerAccount);

    /**
     * 找出该类型的所有的教师
     * @param problemType 问题的类型
     * @return 返回教师列表
     */
    List<ProcessTeacher> listSameTeacher(String problemType);

    /**
     * 根据该问题的id分配给这名教师
     * @param problemId 问题的id
     * @param teacherAccount 教师的账号
     * @param timestamp 分配的时间
     */
    void updateUnassignProblem(@Param("problemId") int problemId, @Param("teacherAccount") String teacherAccount, @Param("timestamp") Timestamp timestamp);

    /**
     * 根据该问题的id驳回该问题，并且更新驳回理由
     * @param problemId
     */
    void updateRejectProblem(@Param("problemId") int problemId, @Param("rejectReason") String rejectReason, @Param("timestamp") Timestamp timestamp);

    /**
     * 获取所有的班级
     * @return 返回班级列表
     */
    List<ClassInfo> listAllClass();

    /**
     * 返回所有的信息员
     * @return 返回信息员列表
     */
    List<Messenger> listAllMessenger();

    /**
     * 增加一个信息员的账号
     * @param classId 班级的id
     * @param messengerAccount 信息员的账号
     * @param messengerPassword 信息员的密码
     */
    void addOneMessenger(@Param("classId") int classId, @Param("messengerAccount") String messengerAccount, @Param("messengerPassword") String messengerPassword);

    /**
     * 删除一个信息员
     * @param messengerAccount 信息员的账号
     */
    void deleteOneMessenger(String messengerAccount);

    /**
     * 返回从指定的条数开始返回指定的未确认问题
     * @param startIndex 开始的序列号
     * @param nums 返回的数量
     * @return 返回的问题的结果集
     */
    List<Problem> listUnconfirmProblem(@Param("startIndex") int startIndex, @Param("nums") int nums, @Param("type") String type, @Param("searchWord") String searchWord);

    /**
     * 确认一个已经处理完毕的问题
     * @param problemId 问题的id
     */
    void updateToConfirmOneProblem(@Param("problemId") int problemId, @Param("confirmTime") Timestamp confirmTime);

    /**
     * 根据处理教师的账号查找该教师的姓名
     * @param teacherAccount 处理教师的账号
     * @return 返回查询到的教师名
     */
    String selectOneProcessTeacherName(String teacherAccount);

    /**
     * 根据该问题的id退回给教师，并且更新退回理由
     * @param problemId 问题的id
     * @param toTeacherReason 退回给教师的理由
     * @param timestamp 退回的时间
     */
    void updateToTeacherProblem(@Param("problemId") int problemId, @Param("toTeacherReason") String toTeacherReason, @Param("timestamp") Timestamp timestamp);
}
