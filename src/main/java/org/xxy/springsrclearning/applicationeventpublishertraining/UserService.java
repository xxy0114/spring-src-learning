package org.xxy.springsrclearning.applicationeventpublishertraining;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final static Logger log = LoggerFactory.getLogger(UserService.class);

    private final ApplicationEventPublisher publisher;


    public UserService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void UserRegister(Long userId, String userName){
        log.info("1.保存用户数据到数据库");
        publisher.publishEvent(new RegisterEvent(userId, userName));
    }
}
