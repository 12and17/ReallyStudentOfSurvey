package club.small.service.impl;

import club.small.dao.ChargeDao;
import club.small.dao.LeaderDao;
import club.small.entity.Leader;
import club.small.dao.ProcessTeacherDao;
import club.small.dto.Empty;
import club.small.dto.Result;
import club.small.entity.Problem;
import club.small.service.ProcessTeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ProcessTeacherServiceImpl implements ProcessTeacherService {
    @Autowired
    private ProcessTeacherDao processTeacherDao;
    @Autowired
    private Empty empty;
    @Autowired
    private LeaderDao leaderDao;
    @Autowired
    private ChargeDao chargeDao;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @Transactional
    public Result<Empty> bindProcessTeacherEmail(String processTeacherAccount, String email) {
        try {
            processTeacherDao.updateProcessTeacherEmail(processTeacherAccount, email);
            return new Result<Empty>(empty);
        }catch (Exception e){
            logger.info("绑定失败");
            e.printStackTrace();
            return new Result<>("绑定失败,数据库连接异常");
        }
    }

    @Override
    @Transactional
    public Result<Empty> modifyProcessTeacherPassword(String processTeacherAccount, String password) {
        try {
            processTeacherDao.updateOneProcessTeacher(processTeacherAccount, password);
            return new Result<Empty>(empty);
        }catch (Exception e){
            logger.info("修改失败");
            e.printStackTrace();
            return new Result<>("修改失败,数据库连接异常");
        }
    }

    @Override
    public Result<List<Problem>> getOrderNumUnprocessProblem(int pageIndex, int nums, String problemType, String searchWord, String processTeacherAccount) {
        int startIndex = nums * (pageIndex - 1);
        try {
            List<Problem> list = processTeacherDao.listUnprocessProblem(startIndex, nums, problemType, searchWord, processTeacherAccount);
            for (int i = 0; i < list.size(); i ++){
                list.get(i).setClassName(chargeDao.getProblemClassName(list.get(i).getMessengerAccount()));
            }
            return new Result<List<Problem>>(list);
        }catch (Exception e){
            logger.info("超找失败");
            e.printStackTrace();
            return new Result<>("数据库连接异常");
        }
    }

    @Override
    @Transactional
    public Result<Empty> makeOneProblemToProcess(int problemId, String processCourse) {
        try {
            processTeacherDao.updateProblemToProcess(problemId, processCourse, new Timestamp(System.currentTimeMillis()));
            return new Result<Empty>(empty);
        }catch (Exception e){
            logger.info("处理失败");
            e.printStackTrace();
            return new Result<>("处理失败,数据库连接异常");
        }
    }

    @Override
    public Result<List<Problem>> getOrderNumToTeacherProblem(int pageIndex, int nums, String problemType, String searchWord, String processTeacherAccount) {
        int startIndex = nums * (pageIndex - 1);
        try {
            List<Problem> list = processTeacherDao.listToTeacherProblem(startIndex, nums, problemType, searchWord, processTeacherAccount);
            for (int i = 0; i < list.size(); i ++){
                list.get(i).setClassName(chargeDao.getProblemClassName(list.get(i).getMessengerAccount()));
            }
            return new Result<List<Problem>>(list);
        }catch (Exception e){
            logger.info("超找失败");
            e.printStackTrace();
            return new Result<>("查找失败,数据库连接异常");
        }
    }

    @Override
    public Result<List<Problem>> getOrderNumUnconfirmProblem(int pageIndex, int nums, String problemType, String searchWord, String processTeacherAccount) {
        int startIndex = nums * (pageIndex - 1);
        try {
            List<Problem> list = processTeacherDao.listUnconfirmProblem(startIndex, nums, problemType, searchWord, processTeacherAccount);
            for (int i = 0; i < list.size(); i ++){
                list.get(i).setClassName(chargeDao.getProblemClassName(list.get(i).getMessengerAccount()));
            }
            return new Result<List<Problem>>(list);
        }catch (Exception e){
            logger.info("超找失败");
            e.printStackTrace();
            return new Result<>("查找失败,数据库连接异常");
        }
    }
}
