package com.mazebuddy.play.event;

import com.mazebuddy.play.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class RegistrationPublishEvent extends ApplicationEvent {

    private User user;
    private String applicationUrl;

    public RegistrationPublishEvent(User user, String applicationUrl){
        super(user);
        this.user = user;
        this.applicationUrl =  applicationUrl;
    }
}
