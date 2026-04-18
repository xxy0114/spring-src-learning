package org.xxy.springsrclearning.applicationeventpublishertraining;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RewardPointsListener {

    @EventListener
    private void AddRewardPoints(RegisterEvent registerEvent){
        System.out.println("给用户" + registerEvent.getUserName() + "添加积分");

    }

}
