package mim.com.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mim.com.dto.StoreOTP;
import mim.com.dto.TempOTP;

@RestController
@CrossOrigin("*")
public class VerifyOTPController {
	
	@PostMapping("/verifyOTP")
	public String verifyOTP(@RequestBody TempOTP tempOtp) {
		if (tempOtp.getOtp() == StoreOTP.getOtp()) {
			return "Correct OTP";
		} else {
			return "Not Correct OTP";
		}
	}

}
