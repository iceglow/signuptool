package se.su.it.signuptool;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.Address;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.MessagingException;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.AddressException;
import java.nio.charset.Charset;


public class MailUtil {

  private String fromAddress;
  private String smtp;

  public MailUtil(String smtp, String fromAddress) {
      this.smtp = smtp;
      this.fromAddress = fromAddress;
  }

  public void sendEmail(String msgBody, String subject, String toAddress) throws AddressException, MessagingException {
      Properties props = System.getProperties();
      props.put("mail.smtp.host", this.getSmtpValue());
      Charset charset = Charset.forName("UTF-8");

      Session session = Session.getDefaultInstance(props, null);

      MimeMessage message = new MimeMessage(session);

      message.setSubject(subject,charset.name());
      message.setFrom(new InternetAddress(fromAddress));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
      message.setText(msgBody,charset.name());

      Transport.send(message);
  }

  public String getSmtpValue(){
      return this.smtp;
  }

  public void setSmtpValue(String smtp){
      this.smtp = smtp;
  }
}