package pl.pawel.location.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtilImpl implements EmailUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtilImpl.class);

    @Autowired
    private JavaMailSender sender;

    @Override
    public void sendEmail(String from, String to, String subject, String body) {
        LOGGER.info("=== Inside sendEmail() -> from: {}, to: {}, subject: {}, body: {}", from, to, subject, body);
        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setFrom(from);
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(body);

        sender.send(mail);
    }

}
