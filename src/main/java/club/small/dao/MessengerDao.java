package club.small.dao;

import club.small.entity.Messenger;
import club.small.entity.Problem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessengerDao {
    /**
     * 根据信息员的一个账号返回一个信息员的信息
     * @param account 信息员的账号
     */
    public Messenger isMessangerLogin(String account);

    /**
     * 根据信息员的班级id查找对应的班级
     * @param classId 信息员的班级id
     * @return 返回一个String对象(班级名称)
     */
    String selectOneClassName(int classId);

    /**
     * 根据一个问题添加一个问题
     * @param problem 添加的问题
     */
    void addOneProblem(Problem problem);

    /**
     * 查找未处理的问题
     * @param messengerAccount 信息员的账号
     * @return 返回未处理的问题列表
     */
    List<Problem> listUnsubmitProblem(String messengerAccount);

    /**
     * 根据搜索词搜索查找出来的问题
     * @param messengerAccount 信息员的账号
     * @param describeWord 搜索词
     * @return 返回问题的列表
     */
    List<Problem> listSelectUnsubmitProblem(@Param("messengerAccount") String messengerAccount, @Param("describeWord") String describeWord);

    /**
     * 查找被驳回的问题
     * @param messengerAccount 信息员的账号
     * @return 返回被驳回的问题列表
     */
    List<Problem> listRejectProblem(String messengerAccount);

    /**
     * 查找信息员所搜索的问题的描述
     * @param messengerAccount 信息员的账号
     * @param describleWord 问题的描述词
     * @return 返回所查询到的问题列表
     */
    List<Problem> listBySelectOfProblem(@Param("messengerAccount")String messengerAccount, @Param("describleWord")String describleWord);

    /**
     * 修改信息员的密码
     * @param messengerAccount 信息员的账号
     * @param password 信息员新设置的密码
     */
    void updateOneMessenger(@Param("messengerAccount")String messengerAccount, @Param("password")String password);

    /**
     * 更新信息员的邮箱
     * @param messengerAccount 信息员的账号
     * @param email 信息员新设置的邮箱
     */
    void updateMessengerEmail(@Param("messengerAccount")String messengerAccount, @Param("email")String email);

    /**
     * 查找未处理的问题的数量
     * @return 返回查找的数量
     */
    int getUnprocessNum(String messengerAccount);

    /**
     * 查找被驳回的问题的数量
     * @return 返回查找的数量
     */
    int getReject(String messengerAccount);

    /**
     * 查找未处理的教学问题数量
     * @return 返回查找的数量
     */
    int getUnprocessOfTeachNum(String messengerAccount);

    /**
     * 查找未处理的设备问题数量
     * @return 返回查找的数量
     */
    int getUnprocessOfEquipmentNum(String messengerAccount);

    /**
     * 查找未处理的需求和建议问题数量
     * @return 返回查找的数量
     */
    int getUnprocessOfDemandNum(String messengerAccount);

    /**
     * 查找被驳回的教学问题数量
     * @return 返回查找的数量
     */
    int getRejectOfTeachNum(String messengerAccount);

    /**
     * 查找被驳回的设备问题数量
     * @return 返回查找的数量
     */
    int getRejectOfEquipmentNum(String messengerAccount);

    /**
     * 查找被驳回的需求和建议问题数量
     * @return 返回查找的数量
     */
    int getRejectOfDemandNum(String messengerAccount);

    /**
     * 查找所有的同意的问题
     * @param startIndex 开始的序列号
     * @param nums 返回的数量
     * @param searchWord 搜索描述词
     * @param messengerAccount  信息员的账号
     * @return 返回未同意的问题列表
     */
    List<Problem> listAlreadyProcessProblem(@Param("startIndex") int startIndex, @Param("nums") int nums, @Param("searchWord") String searchWord, @Param("messengerAccount") String messengerAccount);
}
