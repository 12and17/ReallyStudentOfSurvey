package club.small.service.impl;

import club.small.dao.ChargeDao;
import club.small.dao.LeaderDao;
import club.small.dao.MessengerDao;
import club.small.dao.ProcessTeacherDao;
import club.small.dto.Result;
import club.small.entity.*;
import club.small.service.LoginService;
import club.small.service.MessengerService;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    //注入service依赖
    @Autowired
    private MessengerDao messengerDao; //信息员dao的实例
    @Autowired
    private ChargeDao chargeDao;  //管理员dao的实例
    @Autowired
    private ProcessTeacherDao processTeacherDao;  //处理教师dao的实例
    @Autowired
    private LeaderDao leaderDao; //领导dao的实例
    @Autowired
    private MessengerService messengerService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Override
//    public Messenger getOneMessenger(String account, String password) {
//        return messengerDao.isMessangerLogin(account);
//    }

    @Override
    @Transactional
    public Result<HashMap<String, ? extends Object>> getOneMessenger(String account, String password) {
        HashMap<String, Object> imformation = new HashMap<String, Object>();
        CountNum countNum = new CountNum();
        // TODO Auto-generated method stub
        if (account == null || password == null) {
            logger.info("[ADMIN LOGIN ERROR]   登陆失败，登陆账号:" + account + "  密码:" + password);
            return new Result<>("登录失败，登陆账号或者密码为空");
        } else {
            Messenger messenger = messengerDao.isMessangerLogin(account);
            if (messenger != null) {
                if (password.equals(messenger.getMessPassword())) {
                    logger.info("[ADMIN LOGIN SUCCESS]   登陆成功,登陆账号：" + account);
//                    .setAttribute("admin", messenger);
                    messenger.setClassName(messengerDao.selectOneClassName(messenger.getClassId()));
                    imformation.put("messenger_imformation", messenger);
//                    System.out.println(messenger.getClassName());
                    try {
                        imformation.put("unsumbit_problem", messengerService.getAllUnsubmitProblem(account));
                        imformation.put("reject_problem", messengerDao.listRejectProblem(account));
                        countNum.setUnprocessTeacherNum(messengerDao.getUnprocessNum(account));
                        countNum.setUnprocessOfTeachNum(messengerDao.getUnprocessOfTeachNum(account));
                        countNum.setUnprocessOfEquipmentNum(messengerDao.getUnprocessOfEquipmentNum(account));
                        countNum.setUnprocessOfDemandNum(messengerDao.getUnprocessOfDemandNum(account));
                        countNum.setRejectNum(messengerDao.getReject(account));
                        countNum.setRejectOfTeachNum(messengerDao.getRejectOfTeachNum(account));
                        countNum.setRejectOfEquipmentNum(messengerDao.getRejectOfEquipmentNum(account));
                        countNum.setRejectOfDemandNUm(messengerDao.getRejectOfDemandNum(account));
                        imformation.put("problem_num", countNum);
                    }catch (Exception e){
                        e.printStackTrace();
                        return new Result<>("添加失败");
                    }

                    return new Result<HashMap<String, ? extends Object>>(imformation);
                } else {
                    logger.info("[ADMIN LOGIN SUCCESS]   登陆失败，密码错误,登陆账号：" + account + "登陆密码：" + password);
                    return new Result<>("登录失败，密码错误");
                }
            } else {
                logger.info("[ADMIN LOGIN ERROR]   登陆失败，账号不存在,登陆账号：" + account);
                return new Result<>("登录失败，账号不存在");
            }
        }
    }

    @Override
    public Result<HashMap<String, ? extends Object>> isChargeLogin(String chargeAccount, String chargePassword) {
        Charge charge = null;
        CountNum countNum = new CountNum();
        HashMap<String, Object> imformation = new HashMap<String, Object>();
        try {
            charge = chargeDao.getOneCharge(chargeAccount);
            countNum.setNoConfiremNum(chargeDao.getNoComfirme());
            countNum.setNoConfiremOfDemandNUm(chargeDao.getNoComfirmeOfDemandNum());
            countNum.setNoConfiremOfEquipmentNum(chargeDao.getNoComfirmeOfEquipmentNum());
            countNum.setNoConfiremOfTeachNum(chargeDao.getNoComfirmeOfTeachNum());
            countNum.setUnassignOfDemandNum(chargeDao.getUnassignOfDemandNum());
            countNum.setUnassignOfEquipmentNum(chargeDao.getUnassignOfEquipmentNum());
            countNum.setUnassignOfTeachNum(chargeDao.getUnassignOfTeachNum());
            countNum.setUnassignTeacherNum(chargeDao.getUnassignNum());
        }catch (Exception e){
            logger.info("[ADMIN LOGIN ERROR]   登陆失败，数据库连接错误");
            return new Result<>("数据库连接错误");
        }

        if (charge != null){
            if (charge.getChargePassword().equals(chargePassword)){
                logger.info("[ADMIN LOGIN SUCCESS]   登陆成功,登陆账号：" + chargeAccount);
                imformation.put("charge_imformation", charge);
                imformation.put("count_num", countNum);
                return new Result<>(imformation);
            }else {
                logger.info("[ADMIN LOGIN ERROR]   登陆失败，账号不存在,登陆密码：" + chargePassword);
                return new Result<>("登录失败，密码错误");
            }
        }else {
            logger.info("[ADMIN LOGIN ERROR]   登陆失败，账号不存在,登陆账号：" + chargeAccount);
            return new Result<>("登录失败，账号不存在");
        }
    }

    @Override
    public Result<HashMap<String, ? extends Object>> isProcessTeacherLogin(String processTeacherAccount, String processTeacherPassword) {
        ProcessTeacher processTeacher = null;
        CountNum countNum = new CountNum();
        HashMap<String, Object> imformation = new HashMap<String, Object>();
        try {
            processTeacher = processTeacherDao.isProcessTeacherLogin(processTeacherAccount);
            countNum.setNoprocessNum(processTeacherDao.getUnprocessNum(processTeacherAccount));
            countNum.setToTeacherNum(processTeacherDao.getToTeacherNum(processTeacherAccount));
            countNum.setUnconfirmNum(processTeacherDao.getUnconfirmNum(processTeacherAccount));
        }catch (Exception e){
            logger.info("[ADMIN LOGIN ERROR]   登陆失败，数据库连接错误");
            return new Result<>("数据库连接错误");
        }

        if (processTeacher != null){
            if (processTeacher.getProcessTeacherPassword().equals(processTeacherPassword)){
                logger.info("[ADMIN LOGIN SUCCESS]   登陆成功,登陆账号：" + processTeacherAccount);
                imformation.put("process_teacher_imformation", processTeacher);
                imformation.put("count_num", countNum);
                return new Result<>(imformation);
            }else {
                logger.info("[ADMIN LOGIN ERROR]   登陆失败，账号不存在,登陆密码：" + processTeacherPassword);
                return new Result<>("登录失败，密码错误");
            }
        }else {
            logger.info("[ADMIN LOGIN ERROR]   登陆失败，账号不存在,登陆账号：" + processTeacherAccount);
            return new Result<>("登录失败，账号不存在");
        }
    }

    @Override
    public Result<HashMap<String, ? extends Object>> isLeaderLogin(String leaderAccount, String leaderPassword) {
        Leader leader = null;
        CountNum countNum = new CountNum();
        HashMap<String, Object> imformation = new HashMap<String, Object>();
        try {
            leader = leaderDao.selectOneLeader(leaderAccount);
            countNum.setUnagreeNum(leaderDao.seelectUnagreeProblemNum());
            countNum.setUnagreeOfTeachNum(leaderDao.seelectUnagreeProblemOfTeachNum());
            countNum.setUnagreeOfEquipmentNum(leaderDao.seelectUnagreeProblemOfEquipmentNum());
            countNum.setUnassignOfDemandNum(leaderDao.seelectUnagreeProblemOfDemandNum());
            countNum.setTeachTeacherNum(leaderDao.selectTeachOfTeacherNum());
            countNum.setEquipmentTeacherNum(leaderDao.selectEquipmentOfTeacherNum());
            countNum.setDemandTeacherNum(leaderDao.selectDemandOfTeacherNum());
        }catch (Exception e){
            logger.info("[ADMIN LOGIN ERROR]   登陆失败，数据库连接错误");
            e.printStackTrace();
            return new Result<>("数据库连接错误");
        }

        if (leader != null){
            if (leader.getLeaderPassword().equals(leaderPassword)){
                logger.info("[ADMIN LOGIN SUCCESS]   登陆成功,登陆账号：" + leaderAccount);
                imformation.put("leader_imformation", leader);
                imformation.put("count_num", countNum);
                return new Result<>(imformation);
            }else {
                logger.info("[ADMIN LOGIN ERROR]   登陆失败，账号不存在,登陆密码：" + leaderPassword);
                return new Result<>("登录失败，密码错误");
            }
        }else {
            logger.info("[ADMIN LOGIN ERROR]   登陆失败，账号不存在,登陆账号：" + leaderAccount);
            return new Result<>("登录失败，账号不存在");
        }
    }
}
