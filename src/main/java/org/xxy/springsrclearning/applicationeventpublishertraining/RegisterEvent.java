package org.xxy.springsrclearning.applicationeventpublishertraining;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterEvent {
    private Long userId;
    private String userName;

}
