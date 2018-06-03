package cn.edu.hyit.seppms.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * java mail的工具类
 * <p>
 * javax.mail.AuthenticationFailedException: 550 ÓÃ»§ÎÞÈ¨µÇÂ½ 使用java等各种语言进行操作邮箱的时候，
 * 必须要给邮箱设置客户端授权码，不然我们无法发送邮件，可以将授权码当密码来发送邮件
 * <p>
 */
public class MailUtil {
    private static String MAIL_TRANSPORT_PROTOCOL;
    // 使用的邮箱服务器
    private static String MAIL_SMTP_HOST;

    private static String MAIL_SMTP_AUTH;
    // 发件人邮箱地址
    private static String EMAIL_ADDRESS;
    // 发件人名称
    private static String NAME;
    // 发件人授权码
    private static String AUTHORIZATION_CODE;


    /**
     * 加载配置文件
     */
    static {
        Properties prop = new Properties();
        try {
            prop.load(new InputStreamReader(MailUtil.class.getClassLoader().getResourceAsStream("mail.properties"), "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        MAIL_TRANSPORT_PROTOCOL = prop.getProperty("MAIL_TRANSPORT_PROTOCOL");
        MAIL_SMTP_HOST = prop.getProperty("MAIL_SMTP_HOST");
        MAIL_SMTP_AUTH = prop.getProperty("MAIL_SMTP_AUTH");
        EMAIL_ADDRESS = prop.getProperty("EMAIL_ADDRESS");
        NAME = prop.getProperty("NAME");
        AUTHORIZATION_CODE = prop.getProperty("AUTHORIZATION_CODE");
    }

    /**
     * 发送邮件
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param toEmailAddress 目标邮件地址
     * @param userName 目标用户
     * @return 是否发送成功 true成功 false失败
     */
    public static boolean sendMail(String subject, String content, String toEmailAddress, String userName) {
        Transport t = null;
        Session session = null;
        try {
            // 会话需要的相关信息
            Properties prop = new Properties();
            prop.setProperty("mail.transport.protocol", MAIL_TRANSPORT_PROTOCOL);// 发送邮件的协议
            prop.setProperty("mail.smtp.host", MAIL_SMTP_HOST);// 使用的邮箱服务器
            prop.setProperty("mail.smtp.auth", MAIL_SMTP_AUTH);
            session = Session.getInstance(prop);
            session.setDebug(false);//开启调试模式
            // 创建邮件
            MimeMessage message = new MimeMessage(session);
            InternetAddress fromAddr = new InternetAddress(EMAIL_ADDRESS, NAME);// 发件人的信息，请填写自己的
            InternetAddress toAddr = new InternetAddress(toEmailAddress, userName);// 收件人的信息，请填写自己的
            message.setFrom(fromAddr);// 在信封上写上
            message.setRecipient(Message.RecipientType.TO, toAddr);

            message.setSubject(subject);//邮件主题
            message.setContent(content, "text/html;charset=UTF-8");//邮件正文

            // 发送邮件
            t = session.getTransport();
            t.connect(EMAIL_ADDRESS, AUTHORIZATION_CODE);//这里登陆的时候最好使用126邮箱经过认证之后的密码，请填写自己的（这里填写的是授权码）
            t.sendMessage(message, message.getAllRecipients());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (t != null) {
                    t.close();
                }
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
