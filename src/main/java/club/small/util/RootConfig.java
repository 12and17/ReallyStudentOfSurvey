package club.small.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource("classpath:attributeConfigure.properties")
public class RootConfig {
    //邮箱主机名
    @Value("${EMAIL_HOST}")
    private String host;
    //发送邮箱的用户名
    @Value("${USER_NAME}")
    private String userName;
    //邮箱的授权码
    @Value("${EMAIL_PASSWORD}")
    private String emailPassword;

    /**
     * 配置邮件发送器
     * @return
     */
    @Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);//指定用来发送Email的邮件服务器主机名
        mailSender.setPort(587);//默认端口，标准的SMTP端口
        mailSender.setUsername(userName);//用户名
        mailSender.setPassword(emailPassword);//密码
        return mailSender;
    }
}
