package club.small.service.impl;

import club.small.dao.ChargeDao;
import club.small.dao.LeaderDao;
import club.small.dao.ProcessTeacherDao;
import club.small.dto.Empty;
import club.small.dto.Result;
import club.small.entity.Charge;
import club.small.entity.Problem;
import club.small.entity.ProcessTeacher;
import club.small.service.LeaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class LeaderServiceImpl implements LeaderService {
    @Autowired
    private Empty empty;
    @Autowired
    private LeaderDao leaderDao;
    @Autowired
    private ChargeDao chargeDao;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    @Transactional
    public Result<Empty> modifyOneLeader(String LeaderAccount, String password) {
        try {
            leaderDao.updateOneLeader(LeaderAccount, password);
            return new Result<Empty>(empty);
        }catch (Exception e){
            logger.info("修改失败");
            e.printStackTrace();
            return new Result<>("修改失败");
        }
    }

    @Override
    @Transactional
    public Result<Empty> updateLeaderEmail(String LeaderAccount, String email) {
        try {
            leaderDao.updateLeaderEmail(LeaderAccount, email);
            return new Result<Empty>(empty);
        }catch (Exception e){
            logger.info("绑定失败");
            e.printStackTrace();
            return new Result<>("绑定失败");
        }
    }

    @Override
    public Result<List<Problem>> getOrderNumUnagreeProblem(int pageIndex, int nums, String searchWord, String problemType) {
        int startIndex = nums * (pageIndex - 1);
        try {
            List<Problem> list = leaderDao.listUnagreeProblem(startIndex, nums, searchWord, problemType);
            for (int i = 0; i < list.size(); i ++){
                list.get(i).setClassName(chargeDao.getProblemClassName(list.get(i).getMessengerAccount()));
                list.get(i).setTeacherName(leaderDao.selectProcessTeacherName(list.get(i).getprocessTeacherAccount()));
            }
            return new Result<List<Problem>>(list);
        }catch (Exception e){
            logger.info("超找失败");
            e.printStackTrace();
            return new Result<>("查找失败,数据库连接异常");
        }
    }

    @Override
    @Transactional
    public Result<Empty> makeOneProblemAgree(int problemId) {
        try {
            leaderDao.updateOneProblemToAgree(problemId, new Timestamp(System.currentTimeMillis()));
            return new Result<Empty>(empty);
        }catch (Exception e){
            logger.info("更新失败");
            e.printStackTrace();
            return new Result<>("更新失败,数据库连接异常!");
        }
    }

    @Override
    @Transactional
    public Result<Empty> addOneProcessTeacher(String processTeacherAccount, String password, String processType, String processTeacherName) {
        try {
            leaderDao.insertOneProcessTeacher(processTeacherAccount, password, processType, processTeacherName);
            return new Result<Empty>(empty);
        }catch (Exception e){
            logger.info("增加失败");
            e.printStackTrace();
            return new Result<>("增加失败,数据库连接异常!");
        }
    }

    @Override
    public Result<ProcessTeacher> getOneProcessTeacher(String processTeacherAccount) {
        ProcessTeacher processTeacher;
        try {
            processTeacher = leaderDao.selectProcessTeacher(processTeacherAccount);
        }catch (Exception e){
            logger.info("查找失败");
            e.printStackTrace();
            return new Result<>("查找失败,数据库连接异常!");
        }

        if (processTeacher != null) {
            return new Result<ProcessTeacher>(processTeacher);
        }

        return new Result<>("该账号不存在教师信息!");
    }

    @Override
    @Transactional
    public Result<Empty> deleteOneProcessTeacher(String processTeacherAccount) {
        try {
            leaderDao.deleteOneProcessTeacher(processTeacherAccount);
            return new Result<Empty>(empty);
        }catch (Exception e){
            logger.info("删除失败");
            e.printStackTrace();
            return new Result<>("删除失败,数据库连接异常!");
        }
    }

    @Override
    @Transactional
    public Result<Empty> replaceOneCharge(String chargeAccount, String chargePassword, String chargeName) {
        Charge charge = null;
        try {
            if (chargeAccount == null || chargeAccount.equals("")){
                charge = leaderDao.selectOneCharge();
                chargeAccount = charge.getChargeAccount();
            }

            if (chargePassword == null || chargePassword.equals("")){
                if (charge == null){
                    charge = leaderDao.selectOneCharge();
                    chargePassword = charge.getChargePassword();
                }else {
                    chargePassword = charge.getChargePassword();
                }
            }

            if (chargeName == null || chargeName.equals("")){
                if (charge == null){
                    charge = leaderDao.selectOneCharge();
                    chargeName = charge.getChargeName();
                }else {
                    chargeName = charge.getChargeName();
                }
            }
            leaderDao.updateOneCharge(chargeAccount, chargePassword, chargeName);
            return new Result<Empty>(empty);
        }catch (Exception e){
            logger.info("更换失败");
            e.printStackTrace();
            return new Result<>("更换失败,数据库连接异常!");
        }
    }

    @Override
    public Result<Empty> getChargeName() {
        try {
            empty.setImformation(leaderDao.selectChargeName());
            return new Result<Empty>(empty);
        }catch (Exception e){
            logger.info("查找失败");
            e.printStackTrace();
            return new Result<>("获取教师姓名失败,数据库连接异常!");
        }
    }

    @Override
    @Transactional
    public void addOneClass(String className) {
        leaderDao.addOneClass(className);
    }

    @Override
    public void addOneLeader(String leaderAccount, String leaderPassword, String leaderName) {
        leaderDao.insertOneLeader(leaderAccount, leaderPassword, leaderName);
    }
}
