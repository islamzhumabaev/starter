package kz.islam.study.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SmsService {

    @Value("#{twilioAccountSid}")
    private String accountSid;

    @Value("#{twilioAuthToken}")
    private String authToken;

    @Value("#{twilioPhoneNumber}")
    private String fromPhoneNumber;

    @PostConstruct
    public void init() {
        System.out.println("Twilio SID: " + accountSid);
        System.out.println("Twilio Auth Token: " + authToken);
        System.out.println("Twilio Phone Number: " + fromPhoneNumber);
        Twilio.init(accountSid, authToken);
    }

    public void sendSms(String to, String message) {
        Message.creator(new PhoneNumber(to), new PhoneNumber(fromPhoneNumber), message).create();
    }
}
