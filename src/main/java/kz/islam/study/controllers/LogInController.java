package kz.islam.study.controllers;

import kz.islam.study.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/people")
public class LogInController {
    @Autowired
    private SmsService smsService;

    private String verificationCode;


    @PostMapping("/send-code")
    public String sendCode(@RequestParam("phone") String phone, Model model) {
        verificationCode = String.valueOf((int)(Math.random() * 9000) + 1000);
        smsService.sendSms(phone, "Your verification code is: " + verificationCode);
        model.addAttribute("phone", phone);
        return "people/show";
    }

    @PostMapping("/verify-code")
    public String verifyCode(@RequestParam("code") String code, Model model) {
        if (code.equals(verificationCode)) {
            model.addAttribute("message", "Verification successful!");
            model.addAttribute("messageType", "success");
        } else {
            model.addAttribute("message", "Verification failed. Please try again.");
            model.addAttribute("messageType", "error");
        }
        return "people/show";
    }
}
