package club.small.service;

import club.small.dto.Empty;
import club.small.dto.Result;
import club.small.entity.Problem;

import java.util.List;

public interface ProcessTeacherService {
    /**
     * 绑定处理教师的邮箱
     * @param processTeacherAccount 处理教师的账号
     * @param email 新设置的邮箱
     * @return  封装的结果集
     */
    public Result<Empty> bindProcessTeacherEmail(String processTeacherAccount, String email);

    /**
     * 修改处理教师的密码
     * @param processTeacherAccount 处理教师的账号
     * @param password 新设置的密码
     * @return 封装的结果集
     */
    public Result<Empty> modifyProcessTeacherPassword(String processTeacherAccount, String password);

    /**
     * 超找指定的条数以及类型未处理的问题
     * @param pageIndex 指定的页数
     * @param nums 指定的返回数量
     * @param problemType 问题的类型
     * @param searchWord 搜索词
     * @param processTeacherAccount 处理教师的账号
     * @return 返回查询结果的结果集
     */
    Result<List<Problem>> getOrderNumUnprocessProblem(int pageIndex, int nums, String problemType, String searchWord, String processTeacherAccount);

    /**
     * 使一个问题已处理
     * @param problemId 问题的id
     * @param processCourse 问题的处理过程描述
     * @return 返回封装的结果集
     */
    Result<Empty> makeOneProblemToProcess(int problemId, String processCourse);

    /**
     * 超找指定的条数以及类型被退回的问题
     * @param pageIndex 指定的页数
     * @param nums 指定的返回数量
     * @param problemType 问题的类型
     * @param searchWord 搜索词
     * @param processTeacherAccount 处理教师的账号
     * @return 返回查询结果的结果集
     */
    Result<List<Problem>> getOrderNumToTeacherProblem(int pageIndex, int nums, String problemType, String searchWord, String processTeacherAccount);

    /**
     * 超找指定的条数以及类型未确定的问题
     * @param pageIndex 指定的页数
     * @param nums 指定的返回数量
     * @param problemType 问题的类型
     * @param searchWord 搜索词
     * @param processTeacherAccount 处理教师的账号
     * @return 返回查询结果的结果集
     */
    Result<List<Problem>> getOrderNumUnconfirmProblem(int pageIndex, int nums, String problemType, String searchWord, String processTeacherAccount);
}
