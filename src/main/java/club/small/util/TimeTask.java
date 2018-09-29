package club.small.util;

import club.small.dao.ChargeDao;
import club.small.dao.LeaderDao;
import club.small.dao.MessengerDao;
import club.small.entity.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.util.List;

@PropertySource("classpath:attributeConfigure.properties")
@Component
public class TimeTask {
    //邮箱发送实例
    @Autowired
    private JavaMailSenderImpl mailSender;
    //发送邮箱的用户名
    @Value("${USER_NAME}")
    private String userName;
    //发送给领导的邮箱账号
    @Value("${LEADER_NAME}")
    private String leaderName;
    //发送给管理员的邮箱账号
    @Value("${CHARGE_NAME}")
    private String chargeName;
    @Autowired
    private MessengerDao messengerDao;
    @Autowired
    private LeaderDao leaderDao;
    @Autowired
    private ChargeDao chargeDao;
    //空格
    String space = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";

    @Scheduled(cron = "0 0 10 ? * MON") // 间隔5秒执行
//    @Scheduled(cron = "0 0/1 * * * ? ")
    public void toLeaderEmail() throws  Exception{
        //建立邮件消息,发送简单邮件和html邮件的区别
        MimeMessage mailMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, "UTF-8");
        System.out.println("开始了");
        String reportText = "<html><head></head><body>";
        reportText += "尊敬的领导您好，以下是本周处理的情况：<br>";
        reportText += "提交日期" + space + "问题类型" + space + "提交班级" + space + "问题描述" + space + "处理时间" + space + "处理教师" +  space + "处理过程<br>";
        List<Problem> list = messengerDao.listAlreadyProcessProblem(0, 4, "", "20151943");
        for (int i = 0; i < list.size(); i ++){
            list.get(i).setTeacherName(leaderDao.selectProcessTeacherName(list.get(i).getprocessTeacherAccount()));
            list.get(i).setClassName(chargeDao.getProblemClassName(list.get(i).getMessengerAccount()));
            reportText += list.get(i).getSubmitTime().toString() + space + list.get(i).getProblemType()
                    + space + "14计算机1班" + space + list.get(i).getProblemDescribe() + space
                    + list.get(i).getProcessTime() + space + "jyf" +  space + list.get(i).getProcessCourse() + "<br><hr />";
        }
        reportText += "</body></html>";
            messageHelper.setTo(userName);//收件人
            messageHelper.setFrom(userName);//发件人
            messageHelper.setSubject("本周处理情况");//主题
            messageHelper.setText(reportText, true);//正文
            mailSender.send(mailMessage);
            System.out.println("邮件发送完毕");
    }
}
