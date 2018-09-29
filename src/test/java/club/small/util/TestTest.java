package club.small.util;

import club.small.dao.LeaderDao;
import club.small.entity.Leader;
import club.small.service.ChargeService;
import club.small.service.LeaderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/spring-service.xml", "classpath*:spring/spring-web.xml", "classpath*:spring/spring-dao.xml"})
//@ContextConfiguration(classes={RootConfig.class})
@WebAppConfiguration
public class TestTest extends ApplicationObjectSupport{

    @Autowired
    private JavaMailSenderImpl mailSender;
    @Autowired
    private ChargeService chargeService;
    @Autowired
    private LeaderService leaderService;

    @org.junit.Test
    public void sendSimpleEmail(){
        SimpleMailMessage message = new SimpleMailMessage();//消息构造器
        message.setTo("1426302074@qq.com");//发件人
        message.setFrom("1064265810@qq.com");//收件人
        message.setSubject("验证码");//主题
        message.setText("hello world!!");//正文
        mailSender.send(message);
        System.out.println("邮件发送完毕");
    }

    @org.junit.Test
    @Rollback(false)
    public void addOneCharge(){
        try {
            System.out.println("对象是----------》" + leaderService);
//            chargeService.addOneCharge("yuchao", "123456", "俞超");
            leaderService.addOneLeader("laichuanke", "123456", "赖传可");
//            leaderService.addOneClass("15计算机1班");
            System.out.println("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("添加失败");
        }
    }

}