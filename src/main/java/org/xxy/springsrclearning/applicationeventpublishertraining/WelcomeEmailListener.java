package org.xxy.springsrclearning.applicationeventpublishertraining;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class WelcomeEmailListener {
    @EventListener
    private void SendWelcomeEmail(RegisterEvent registerEvent){
        System.out.println("用户" + registerEvent.getUserName() + "你好");
    }
}
