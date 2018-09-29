package club.small.dao;

import club.small.entity.Problem;
import club.small.entity.ProcessTeacher;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.EAN;

import java.sql.Timestamp;
import java.util.List;

public interface ProcessTeacherDao {
    /**
     * 判断是否是该处理教师登录
     * @param processTeacherAccount 处理教师的账号
     * @return 返回一个处理教师
     */
    public ProcessTeacher isProcessTeacherLogin(String processTeacherAccount);

    /**
     * 查找未处理的问题的数量
     * @param processTeacherAccount 管理教师的账号
     * @return 返回查找的数量
     */
    int getUnprocessNum(String processTeacherAccount);

    /**
     * 查找被回退的问题的数量
     * @param processTeacherAccount 处理教师的账号
     * @return 返回查找的数量
     */
    int getToTeacherNum(String processTeacherAccount);

    /**
     * 查找未确认的问题的数量
     * @param processTeacherAccount 处理教师的账号
     * @return 返回查找的数量
     */
    int getUnconfirmNum(String processTeacherAccount);

    /**
     * 根据处理教师的账号，更新邮箱账号
     * @param processTeacherAccount 处理教师的账号
     * @param email 设置的邮箱
     */
    void updateProcessTeacherEmail(@Param("processTeacherAccount") String processTeacherAccount, @Param("email") String email);

    /**
     * 修改处理教师的密码
     * @param processTeacherAccount 处理教师的账号
     * @param password 处理教师新设置的密码
     */
    void updateOneProcessTeacher(@Param("processTeacherAccount")String processTeacherAccount, @Param("password")String password);

    /**
     * 返回从指定的条数开始返回指定的问题
     * @param startIndex 开始的序列号
     * @param nums 返回的数量
     * @param type 搜索问题的类型
     * @param searchWord 搜索词
     * @param processTeacherAccount 处理教师的账号
     * @return 返回的问题的结果集
     */
    List<Problem> listUnprocessProblem(@Param("startIndex") int startIndex, @Param("nums") int nums, @Param("type") String type, @Param("searchWord") String searchWord, @Param("processTeacherAccount") String processTeacherAccount);

    /**
     * 更新一个问题，使其已处理，更新其处理过程
     * @param problemId 问题的id
     * @param processCourse 问题的处理过程
     * @param processTime 处理的时间
     */
    void updateProblemToProcess(@Param("problemId") int problemId, @Param("processCourse") String processCourse, @Param("processTime")Timestamp processTime);

    /**
     * 返回从指定的条数开始返回指定的问题
     * @param startIndex 开始的序列号
     * @param nums 返回的数量
     * @param type 搜索问题的类型
     * @param searchWord 搜索词
     * @param processTeacherAccount 处理教师的账号
     * @return 返回的问题的结果集
     */
    List<Problem> listUnconfirmProblem(@Param("startIndex") int startIndex, @Param("nums") int nums, @Param("type") String type, @Param("searchWord") String searchWord, @Param("processTeacherAccount") String processTeacherAccount);


    /**
     * 返回从指定的条数开始返回指定的问题(被退回的问题)
     * @param startIndex 开始的序列号
     * @param nums 返回的数量
     * @param type 搜索问题的类型
     * @param searchWord 搜索词
     * @param processTeacherAccount 处理教师的账号
     * @return 返回的问题的结果集
     */
    List<Problem> listToTeacherProblem(@Param("startIndex") int startIndex, @Param("nums") int nums, @Param("type") String type, @Param("searchWord") String searchWord, @Param("processTeacherAccount") String processTeacherAccount);
}
