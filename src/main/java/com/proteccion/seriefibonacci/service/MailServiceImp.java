package com.proteccion.seriefibonacci.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Locale;

import javax.mail.internet.MimeMessage;

import com.proteccion.seriefibonacci.dto.GeneralResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailServiceImp {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private TemplateEngine templateEngine;

    @Value("${test.mail}")
    private String mailUser;

    
    public void sendMail(GeneralResponseDto response){
        MimeMessage mail = javaMailSender.createMimeMessage();

        try{
            List<String> mailUsers = new ArrayList<String>();
            mailUsers.add(mailUser);
            mailUsers.add("jorgei11042014@hotmail.com");
            String[] mailers = new String[mailUsers.size()];
            mailers = mailUsers.toArray(mailers);
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setFrom("root@gmail.com");
            helper.setTo(mailers);
            helper.setSubject("Fibonacci resultado");
            helper.setText(generateMailHtml("Hola,", response.getMensaje() + "AM, Sucesion: " + response.getFibonacciResultado(), "Fibonacci App"), true);
            
            System.setProperty("java.net.preferIPv4Stack", "true");
            javaMailSender.send(mail);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String generateMailHtml(String greeting, String message, String app) {
        String output = "";
        try{
            Map<String, Object> variables = new HashMap<>();
            variables.put("greeting", greeting);
            variables.put("message", message);
            variables.put("app", app);
            final String templateFileName = "mailTemplate";
            output = this.templateEngine.process(templateFileName, new Context(Locale.getDefault(), variables));
            return output;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
