package com.project.profileHub.profileservice.service.Manager;

import com.project.profileHub.profileservice.persistence.entity.UserDetailsEntity;
import com.project.profileHub.profileservice.service.Woker.ProfileApiWorker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.model.FirstApiDto;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
@Slf4j


public class ProfileApiManager {

    private final ProfileApiWorker firstapiworker;
    public UserDetailsEntity addUserDetails(Long userId, MultipartFile profileImage, String userName, String city, String zipCode, String phoneNumber) {

        return firstapiworker.addUserDetails(userId, profileImage, userName, city, zipCode, phoneNumber);
    }

    public FirstApiDto getUserDetails(Long userid){

        return firstapiworker.getUserDetails(userid);
    }

    public byte[] getUserImage(Long userId){
        return firstapiworker.getUserImage(userId);
    }
}
