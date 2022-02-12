package mim.com.service;

import java.text.ParseException;



import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import mim.com.dto.StoreOTP;
import mim.com.model.User;
@Component
public class SmsService {
     private final String ACCOUNT_SID ="ACa16477d89ef39ee";

    private final String AUTH_TOKEN = "40f379954152bdf60bc";

    private final String FROM_NUMBER = "+19032";

    public void send(User sms) throws ParseException {
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      
    	
        int min = 100000;  
         int max = 999999; 
        int number=(int)(Math.random()*(max-min+1)+min);
      
        
        String msg ="Your OTP - "+number+ " please verify this OTP in your Application ~KK hoon 😅😅";
       
        
        Message message = Message.creator(new PhoneNumber(sms.getContactNumber()), new PhoneNumber(FROM_NUMBER), msg)
                .create();
       StoreOTP.setOtp(number);
      
    }

    public void receive(MultiValueMap<String, String> smscallback) {
   
    }

}