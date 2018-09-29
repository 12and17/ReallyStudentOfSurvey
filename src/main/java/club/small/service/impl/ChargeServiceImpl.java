package club.small.service.impl;

import club.small.dao.ChargeDao;
import club.small.dao.MessengerDao;
import club.small.dto.Empty;
import club.small.dto.Result;
import club.small.entity.*;
import club.small.service.ChargeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChargeServiceImpl implements ChargeService {
    @Autowired
    private ChargeDao chargeDao;
    @Autowired
    private MessengerDao messengerDao; //信息员dao的实例
    @Autowired
    private Empty empty;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    @Transactional
    public Result<Empty> addOneCharge(String chargeAccount, String chargePassword, String chargeName) {
        try {
            chargeDao.addOneAdministrator( chargeAccount, chargePassword, chargeName);
            return new Result<Empty>();
        }catch (Exception e){
            logger.info("添加失败");
            e.printStackTrace();
            return new Result<>("添加失败");
        }
    }

    @Override
    @Transactional
    public Result<Empty> modifyOneCharge(String chargeAccount, String password) {
        try {
            chargeDao.updateOneCharge(chargeAccount, password);
            return new Result<Empty>(empty);
        }catch (Exception e){
            logger.info("修改失败");
            e.printStackTrace();
            return new Result<>("修改失败");
        }
    }

    @Override
    @Transactional
    public Result<Empty> updateChargeEmail(String chargeAccount, String email) {
        try {
            chargeDao.updateChargeEmail(chargeAccount, email);
            return new Result<Empty>(empty);
        }catch (Exception e){
            logger.info("绑定失败");
            e.printStackTrace();
            return new Result<>("绑定失败");
        }
    }

    @Override
    public Result<List<Problem>> getOrderNumProblem(int pageIndex, int nums, String problemType, String searchWord) {
        int startIndex = nums * (pageIndex - 1);
        try {
            List<Problem> list = chargeDao.listUnassignProblem(startIndex, nums, problemType, searchWord);
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
    public Result<List<Empty>> getAllSameTeacher(String problemType) {
        List<Empty> empties = new ArrayList<>();
        try {
            List<ProcessTeacher> list = chargeDao.listSameTeacher(problemType);
            for (int i = 0; i < list.size(); i ++){
                if (i == 0) {
                    empty.setImformation("true");
                }
                empty.setProcessTeacherAccount(list.get(i).getProcessTeacherAccount());
                empty.setProcessTeacherName(list.get(i).getProcessTeacherName());
                empties.add(empty);
            }
            return new Result<List<Empty>>(empties);
        }catch (Exception e){
            logger.info("超找失败");
            e.printStackTrace();
            return new Result<>("数据库连接异常");
        }
    }

    @Override
    @Transactional
    public Result<Empty> assignTeacher(int problemId, String teacherAccount) {
        try {
            chargeDao.updateUnassignProblem(problemId, teacherAccount, new Timestamp(System.currentTimeMillis()));
            return new Result<Empty>(empty);
        }catch (Exception e){
            logger.info("更新失败");
            e.printStackTrace();
            return new Result<>("更新失败");
        }
    }

    @Override
    @Transactional
    public Result<Empty> rejectToStudent(int problemId, String rejectReason) {
        try {
            chargeDao.updateRejectProblem(problemId, rejectReason, new Timestamp(System.currentTimeMillis()));
            return new Result<Empty>(empty);
        } catch (Exception e) {
            logger.info("驳回失败");
            e.printStackTrace();
            return new Result<>("驳回失败");
        }
    }

    @Override
    public Result<List<ClassInfo>> getAllClass() {
        try {
            List<ClassInfo> listClass = chargeDao.listAllClass();
            List<Messenger> listMessenger = chargeDao.listAllMessenger();

            for (int i = 0; i < listClass.size(); i ++){
                for (int j = 0; j < listMessenger.size(); j ++){
                    if (listClass.get(i).getClassId() == listMessenger.get(j).getClassId()){
                        listClass.get(i).setMessengerNum(listClass.get(i).getMessengerNum() + 1);
                    }
                }
            }
            return new Result<List<ClassInfo>>(listClass);
        } catch (Exception e) {
            logger.info("驳回失败");
            e.printStackTrace();
            return new Result<>("驳回失败");
        }
    }

    @Override
    @Transactional
    public Result<Empty> addOneMessenger(int classId, String messengerAccount, String messengerPassword) {
        try {
            chargeDao.addOneMessenger(classId, messengerAccount, messengerPassword);
            return new Result<Empty>(empty);
        }catch (Exception e){
            logger.info("添加失败");
            e.printStackTrace();
            return new Result<>("数据库连接错误");
        }
    }

    @Override
    @Transactional
    public Result<Empty> detoryOneMessenger(String messengerAccount) {
        try {
            chargeDao.deleteOneMessenger(messengerAccount);
            return new Result<Empty>(empty);
        }catch (Exception e){
            logger.info("删除失败");
            e.printStackTrace();
            return new Result<>("数据库连接错误");
        }
    }

    @Override
    public Result<Messenger> getOneMessengerInfo(String messengerAccount) {
        try {
            Messenger messenger = messengerDao.isMessangerLogin(messengerAccount);

            if (messenger == null){
                return new Result<>("不存在该信息员");
            }else {
                messenger.setClassName(messengerDao.selectOneClassName(messenger.getClassId()));
                return new Result<Messenger>(messenger);
            }
        }catch (Exception e){
            logger.info("删除失败");
            e.printStackTrace();
            return new Result<>("数据库连接错误");
        }
    }

    @Override
    public Result<List<Problem>> getOrderNumUnconfirmProblem(int pageIndex, int nums, String problemType, String searchWord) {
        int startIndex = nums * (pageIndex - 1);
        try {
            List<Problem> list = chargeDao.listUnconfirmProblem(startIndex, nums, problemType, searchWord);
            for (int i = 0; i < list.size(); i ++){
                list.get(i).setClassName(chargeDao.getProblemClassName(list.get(i).getMessengerAccount()));
                list.get(i).setTeacherName(chargeDao.selectOneProcessTeacherName(list.get(i).getprocessTeacherAccount()));
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
    public Result<Empty> confirmOneProblem(int problemId) {
        try {
            chargeDao.updateToConfirmOneProblem(problemId, new Timestamp(System.currentTimeMillis()));
            return new Result<Empty>(empty);
        }catch (Exception e){
            logger.info("更新失败");
            e.printStackTrace();
            return new Result<>("数据库连接错误");
        }
    }

    @Override
    @Transactional
    public Result<Empty> toTeacherProblem(int problemId, String toTeacherReason) {
        try {
            chargeDao.updateToTeacherProblem(problemId, toTeacherReason, new Timestamp(System.currentTimeMillis()));
            return new Result<Empty>(empty);
        } catch (Exception e) {
            logger.info("退回失败");
            e.printStackTrace();
            return new Result<>("驳回失败,数据库连接异常!");
        }
    }
}
