package club.small.dao;

import club.small.entity.Charge;
import club.small.entity.Leader;
import club.small.entity.Problem;
import club.small.entity.ProcessTeacher;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface LeaderDao {
    /**
     * 根据领导账号，查找一个领导
     * @param leaderAccount 领导的账号
     * @return 返回一个领导实例
     */
    Leader selectOneLeader(String leaderAccount);

    /**
     * 查找教师姓名
     * @param processTeacherAccount 教师的账号
     * @return 返回查询到的教师名字
     */
    public String selectProcessTeacherName(String processTeacherAccount);

    /**
     * 查找一个处理教师
     * @param processTeacherAccount 处理教师的账号
     * @return 返回查询到的教师
     */
    public ProcessTeacher selectProcessTeacher(String processTeacherAccount);

    /**
     * 查找所有还未同意的问题的数量
     * @return 返回查询到的数量
     */
    int seelectUnagreeProblemNum();

    /**
     * 查找所有还未同意的教学问题的数量
     * @return 返回查询到的数量
     */
    int seelectUnagreeProblemOfTeachNum();

    /**
     * 查找所有还未同意的设备问题的数量
     * @return 返回查询到的数量
     */
    int seelectUnagreeProblemOfEquipmentNum();

    /**
     * 查找所有还未同意的需求和建议问题的数量
     * @return 返回查询到的数量
     */
    int seelectUnagreeProblemOfDemandNum();

    /**
     * 修改领导的密码
     * @param leaderAccount 领导的账号
     * @param password 领导新设置的密码
     */
    void updateOneLeader(@Param("leaderAccount")String leaderAccount, @Param("password")String password);

    /**
     * 更新领导的邮箱
     * @param leaderAccount 领导的账号
     * @param email 领导新设置的邮箱
     */
    void updateLeaderEmail(@Param("leaderAccount")String leaderAccount, @Param("email")String email);

    /**
     * 查找所有的未同意的该类型的问题
     * @param startIndex 开始的序列号
     * @param nums 返回的数量
     * @param searchWord 搜索描述词
     * @param problemType 问题的类型
     * @return 返回未同意的问题列表
     */
    List<Problem> listUnagreeProblem(@Param("startIndex") int startIndex, @Param("nums") int nums, @Param("searchWord") String searchWord, @Param("problemType") String problemType);

    /**
     * 更新一个问题使其变为已同意
     * @param problemId 问题的id
     * @param timestamp 更新的时间
     */
    void updateOneProblemToAgree(@Param("problemId") int problemId, @Param("timestamp") Timestamp timestamp);

    /**
     * 查找日常教学问题的处理教师数量
     * @return 返回查询到的数量
     */
    int selectTeachOfTeacherNum();

    /**
     * 查找设备问题的处理教师数量
     * @return 返回查询到的数量
     */
    int selectEquipmentOfTeacherNum();

    /**
     * 查找需求和建议问题的处理教师数量
     * @return 返回查询到的数量
     */
    int selectDemandOfTeacherNum();

    /**
     * 增加一个处理教师
     * @param processTeacherAccount 处理教师的账号
     * @param password 设置的密码
     * @param processType 设置处理的类型
     * @param processTeacherName 处理教师的姓名
     */
    void insertOneProcessTeacher(@Param("processTeacherAccount") String processTeacherAccount, @Param("password") String password, @Param("processType") String processType, @Param("processTeacherName") String processTeacherName);

    /**
     * 删除一个处理教师
     * @param processTeacherAccount 处理教师账号
     */
    void deleteOneProcessTeacher(String processTeacherAccount);

    /**
     * 更新一个管理员
     * @param chargeAccount 新设置的管理员账号
     * @param chargePassword 新设置的管理员的密码
     * @param chargeName 新设置的管理员姓名
     */
    void updateOneCharge(@Param("chargeAccount") String chargeAccount, @Param("chargePassword") String chargePassword, @Param("chargeName") String chargeName);

    /**
     * 返回管理员信息
     * @return 返回一个管理员
     */
    Charge selectOneCharge();

    /**
     * 返回管理员的姓名
     * @return 返回查找的姓名
     */
    String selectChargeName();

    /**
     * 查找最近一周的处理的问题
     * @return 返回问题列表
     */
    List<Problem> listLastWeekProcessProblem();

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
    void insertOneLeader(@Param("leaderAccount") String leaderAccount, @Param("leaderPassword") String leaderPassword, @Param("leaderName") String leaderName);
}
