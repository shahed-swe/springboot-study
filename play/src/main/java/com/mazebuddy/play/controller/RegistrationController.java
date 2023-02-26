package com.mazebuddy.play.controller;

import com.mazebuddy.play.dto.UserDto;
import com.mazebuddy.play.entity.User;
import com.mazebuddy.play.event.RegistrationPublishEvent;
import com.mazebuddy.play.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth/")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostMapping("/registerUser")
    public User registerUser(@RequestBody UserDto userDetails, final HttpServletRequest httpServletRequest){
        User user = userService.registerUser(userDetails);
        applicationEventPublisher.publishEvent(new RegistrationPublishEvent(
                user,
                applicationUrl(httpServletRequest)
        ));
        return user;
    }

    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token){
        String result = userService.validateVerification(token);
        System.out.println("result = " + result);
        if(result.equalsIgnoreCase("valid")){
            return "User Activation Successfull";
        }else{
            return "Token is not valid";
        }
    }

    @PostMapping("/resendToken/{email}")
    public String resendToken(@PathVariable String email, final HttpServletRequest httpServletRequest){
        User user = userService.sendTokenAgain(email);
        applicationEventPublisher.publishEvent(new RegistrationPublishEvent(
                user,
                applicationUrl(httpServletRequest)
        ));
        return "Token Sent Successfully";

    }

    private String applicationUrl(HttpServletRequest httpServletRequest) {
        return "http://"+httpServletRequest.getServerName()+":"+httpServletRequest.getServerPort()+"/"+ httpServletRequest.getContextPath();
    }
}
