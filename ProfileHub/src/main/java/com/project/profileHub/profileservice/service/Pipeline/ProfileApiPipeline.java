package com.project.profileHub.profileservice.service.Pipeline;

import com.project.profileHub.profileservice.persistence.entity.UserDetailsEntity;
import com.project.profileHub.profileservice.service.Manager.ProfileApiManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.model.FirstApiDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileApiPipeline implements ProfileInterfacePipeline {

    private final ProfileApiManager firstApiManager;
    @Override
    public void addUserWithImage(Long userId, MultipartFile profileImage, String userName, String city, String zipCode, String phoneNumber) {
          UserDetailsEntity userDetailsEntity= firstApiManager.addUserDetails(userId,profileImage,userName,city,zipCode,phoneNumber);

    }

    @Override
    public FirstApiDto getUserDetails(Long userId) {
        return firstApiManager.getUserDetails(userId);
    }

    @Override
    public byte[] getUserImage(Long userId){
        return firstApiManager.getUserImage(userId);
    }
}
