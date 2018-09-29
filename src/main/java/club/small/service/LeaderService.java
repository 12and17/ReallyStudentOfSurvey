package club.small.service;

import club.small.dto.Empty;
import club.small.dto.Result;
import club.small.entity.Messenger;
import club.small.entity.Problem;
import club.small.entity.ProcessTeacher;
import org.apache.ibatis.annotations.Param;

import javax.sql.rowset.spi.SyncResolver;
import java.sql.Timestamp;
import java.util.List;

public interface LeaderService {

    /**
     * 修改领导的密码
     * @param LeaderAccount 领导的账号
     * @param password 新设置的密码
     * @return 返回封装的结果集
     */
    public Result<Empty> modifyOneLeader(String LeaderAccount, String password);

    /**
     * 修改领导的邮箱
     * @param LeaderAccount 领导的账号
     * @param email 领导的邮箱
     * @return 返回封装的结果集
     */
    public Result<Empty> updateLeaderEmail(String LeaderAccount, String email);

    /**
     * 超找指定的条数以及类型未同意的问题
     * @param pageIndex 指定的页数
     * @param nums 指定的返回数量
     * @param problemType 问题的类型
     * @return 返回查询结果的结果集
     */
    Result<List<Problem>> getOrderNumUnagreeProblem(int pageIndex, int nums, String searchWord,  String problemType);

    /**
     * 使一个问题状态为已同意
     * @param problemId 问题的id
     * @return
     */
    Result<Empty> makeOneProblemAgree(int problemId);

    /**
     * 增加一个处理教师
     * @param processTeacherAccount 处理教师的账号
     * @param password 处理教师的密码
     * @param processType 处理的类型
     * @param processTeacherName 教师的姓名
     * @return 返回封装的结果集
     */
    Result<Empty> addOneProcessTeacher(String processTeacherAccount, String password, String processType, String processTeacherName);

    /**
     * 根据处理教师的账号查找一个处理教师
     * @param processTeacherAccount 处理教师的账号
     * @return 返回封装的结果集
     */
    Result<ProcessTeacher> getOneProcessTeacher(String processTeacherAccount);

    /**
     * 根据处理教师的账号删除一个处理教师
     * @param processTeacherAccount 处理教师的账号
     * @return 返回封装的结果集
     */
    Result<Empty> deleteOneProcessTeacher(String processTeacherAccount);

    /**
     * 更新一个管理员
     * @param chargeAccount 新设置的管理员账号
     * @param chargePassword 新设置的管理员的密码
     * @param chargeName 新设置的管理员姓名
     */
    Result<Empty> replaceOneCharge(String chargeAccount, String chargePassword, String chargeName);

    /**
     * 查找管理员的姓名
     * @return 返回封装的结果集
     */
    Result<Empty> getChargeName();

    /**
     * 增加一个班级
     * @param className 班级的名称
     */
    void addOneClass(String className);

    /**
     * 增加一个领导
     * @param leaderAccount 领导的账号
     * @param leaderPassword 领导的密码
     * @param leaderName 领导的姓名
     */
    void addOneLeader(@Param("leaderAccount") String leaderAccount, @Param("leaderPassword") String leaderPassword, @Param("leaderName") String leaderName);
}
