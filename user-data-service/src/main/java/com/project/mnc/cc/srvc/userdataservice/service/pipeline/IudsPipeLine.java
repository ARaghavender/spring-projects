package com.project.mnc.cc.srvc.userdataservice.service.pipeline;


import com.adp.userdataservice.model.UserDataDTO;

import java.util.List;

public interface IudsPipeLine {

    void addUserData(UserDataDTO userDataDTO);

    UserDataDTO getUserDetails(Long userId);

    void updateUserData(Long userId,UserDataDTO userDataDTO);

    public List<UserDataDTO> getAllUserDetails();

}
//