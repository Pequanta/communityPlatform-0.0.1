package importantUtils;
import dataContainers.UserInfo;
import javax.mail.*;
import java.util.*;
import javax.mail.internet.*;
public class VerifyEmail {
    static String verCode;
    UserInfo user;
    public VerifyEmail(UserInfo userData){
        user = userData;
    }
    public String returnVerificationCode(){
        Random random= new Random();
    	String numbers="0123456789";
    	String verificationCode="";
    	for(int i=0;i<6;i++) {
    		int rand = random.nextInt(10);
    		verificationCode+=numbers.charAt(rand);
    	}
        return verificationCode;
    }
    public String sendVerificationEmail()throws Exception {
        final String senderEmail = "aaitelectricalengineers@gmail.com";
        final String senderPassword = "vxttfuojmdnfyrtg";
        String receiverEmail = user.getEmail();
        String emailSubject="Verify your email address. Action Required";
        verCode = returnVerificationCode();

        String emailBody="Dear " +user.getFname() +",\n\nThank you for signing up for our service! We're excited to have you on board. Before we can activate your account, we need to verify your email address. This step is important to ensure the security of your account.To complete the verification process, please copy the verification code and paste it into the web browser:"
                                    + "\r\n CODE: " + verCode +"\nIf you did not sign up for our service, please ignore this email. Your account will not be activated.\r\n"
                            + "\r\n"
                            + "Once you've verified your email address, you'll be able to access all the features of our service and start enjoying the benefits immediately.\r\n"
                            + "\r\n"
                            + "If you have any questions or encounter any issues during the verification process, please don't hesitate to reach out to our support team at aaitelectricalengineers@gmail.com. We're here to assist you.\r\n"
                            + "\r\n"
                            + "Thank you for choosing our service. We look forward to serving you!\r\n"
                            + "\r\n"
                            + "Best regards,\r\n"
                            + "AAiT Electrical Engineers Community";

            Properties props = new Properties();
            //props.put("mail.smtp.user",senderEmail);
    props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");

            Session session = Session.getInstance(props, new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(senderEmail,senderPassword);
            }
            });

            try {
                    MimeMessage msg = new MimeMessage(session);
                    msg.setText(emailBody);
                    msg.setSubject(emailSubject);
                    msg.setFrom(new InternetAddress(senderEmail));
                    msg.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmail));
                    Transport.send(msg);
                    System.out.println("Message sent successfully");
                    }
            catch (Exception e) {
                    e.printStackTrace();
            } 
        return verCode;
    }
	
}
