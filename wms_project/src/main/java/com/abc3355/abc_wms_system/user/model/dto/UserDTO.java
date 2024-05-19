package com.abc3355.abc_wms_system.user.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private int userNo;
    private String userId;
    private String userPassword;
    private String userType;
    private int whId;

}
