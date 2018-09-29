package club.small.service.impl;

import club.small.dao.ChargeDao;
import club.small.dao.LeaderDao;
import club.small.dao.MessengerDao;
import club.small.dto.Empty;
import club.small.dto.Result;
import club.small.entity.Problem;
import club.small.service.MessengerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@PropertySource("classpath:attributeConfigure.properties")
@Service
public class MessengerServiceImpl implements MessengerService {
    @Value("${DAILY_PROBLEM}")
    private String driver;
    //发送邮箱的用户名
    @Value("${USER_NAME}")
    private String userName;
    //注入service依赖
    @Autowired
    private MessengerDao messengerDao;
    @Autowired
    private JavaMailSenderImpl mailSender;
    @Autowired
    private LeaderDao leaderDao;
    @Autowired
    private ChargeDao chargeDao;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Empty empty;
    @Override
    @Transactional
    public Result<Empty> sumbitOnrProblem(String messengerAccount, String problemDiscribe, String problemType) {
        Problem problem = new Problem();
        problem.setMessengerAccount(messengerAccount);
        problem.setProblemDescribe(problemDiscribe);
        problem.setProblemType(problemType);
//        System.out.println("账号是:" + problem.getMessengerAccount() + "," + problemDiscribe);
//        problem.setProblemProgress(driver);
        problem.setSumbitTime(new Timestamp(System.currentTimeMillis()));
        try {
            messengerDao.addOneProblem(problem);
            return new Result<Empty>(empty);
        }catch (Exception e){
            logger.info("添加失败");
            e.printStackTrace();
            return new Result<>("添加失败");
        }
    }

    @Override
    public List<Problem> getAllUnsubmitProblem(String messengerAccount) {
        try {
            List<Problem> result = messengerDao.listUnsubmitProblem(messengerAccount);
            for (int i = 0; i < result.size(); i ++){
                String teacherName = chargeDao.selectOneProcessTeacherName(result.get(i).getprocessTeacherAccount());
                if (teacherName == null){
                    result.get(i).setTeacherName("暂无");
                }else {
                    result.get(i).setTeacherName(teacherName);
                }
            }
            return result;
        }catch (Exception e){
            logger.info("查找失败");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Result<List<Problem>> getSelectUnsubmitProblem(String messengerAccount, String describeWord) {
        try {
            List<Problem> result = messengerDao.listSelectUnsubmitProblem(messengerAccount, describeWord);
            for (int i = 0; i < result.size(); i ++){
                String teacherName = chargeDao.selectOneProcessTeacherName(result.get(i).getprocessTeacherAccount());
                if (teacherName == null){
                    result.get(i).setTeacherName("暂无");
                }else if (teacherName != null){
                    result.get(i).setTeacherName(teacherName);
                }
            }
            return new Result<List<Problem>>(result);
        }catch (Exception e){
            logger.info("查找失败");
            e.printStackTrace();
            return new Result<>("查找失败");
        }
    }

    @Override
    public Result<List<Problem>> getAllRejectProblem(String messengerAccount) {
        try {
            return new Result<List<Problem>>(messengerDao.listRejectProblem(messengerAccount));
        }catch (Exception e){
            logger.info("查找失败");
            e.printStackTrace();
            return new Result<>("数据库连接异常");
        }
    }

    @Override
    public Result<List<Problem>> getSelectProblem(String messengerAccount, String describleWord) {
        try {
            return new Result<List<Problem>>(messengerDao.listBySelectOfProblem(messengerAccount, describleWord));
        }catch (Exception e){
            logger.info("查找失败");
            e.printStackTrace();
            return new Result<>("查找失败");
        }
    }

    @Override
    public Result<Empty> modifyOneMessenger(String messengerAccount, String password) {
        try {
            messengerDao.updateOneMessenger(messengerAccount, password);
            return new Result<Empty>(empty);
        }catch (Exception e){
            logger.info("修改失败");
            e.printStackTrace();
            return new Result<>("修改失败");
        }
    }

    @Override
    public Result<Empty> getVerificationCode(String mailAccount) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();//消息构造器
            //生成六位随机验证码
            String code = Integer.toString((int) ((Math.random() * 9 + 1) * 100000));
            empty = new Empty(code);
            message.setTo(mailAccount);//收件人
            message.setFrom(userName);//发件人
            message.setSubject("验证码");//主题
            message.setText(code);//正文
            mailSender.send(message);
            System.out.println("邮件发送完毕");
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>("获取失败");
        }

        return new Result<Empty>(empty);
    }

    @Override
    public Result<Empty> updateMessengerEmail(String messengerAccount, String email) {
        try {
            messengerDao.updateMessengerEmail(messengerAccount, email);
            return new Result<Empty>(empty);
        }catch (Exception e){
            logger.info("绑定失败");
            e.printStackTrace();
            return new Result<>("绑定失败");
        }
    }

    @Override
    public Result<List<Problem>> getOrderNumAlreadyProcessProblem(int pageIndex, int nums, String searchWord, String messengerAccount) {
        int startIndex = nums * (pageIndex - 1);
        try {
            List<Problem> list = messengerDao.listAlreadyProcessProblem(startIndex, nums, searchWord, messengerAccount);
            for (int i = 0; i < list.size(); i ++){
                list.get(i).setTeacherName(leaderDao.selectProcessTeacherName(list.get(i).getprocessTeacherAccount()));
            }
            return new Result<List<Problem>>(list);
        }catch (Exception e){
            logger.info("查找失败");
            e.printStackTrace();
            return new Result<>("查找失败,数据库连接异常");
        }
    }
}
