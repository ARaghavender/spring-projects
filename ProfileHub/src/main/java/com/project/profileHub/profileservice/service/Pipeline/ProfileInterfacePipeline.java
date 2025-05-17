package com.project.profileHub.profileservice.service.Pipeline;

import org.openapitools.model.FirstApiDto;

import org.springframework.web.multipart.MultipartFile;

public interface ProfileInterfacePipeline {

    void addUserWithImage(Long userId, MultipartFile profileImage,String userName,String city,String zipCode,String phoneNumber);

    FirstApiDto getUserDetails(Long userId);

    byte[] getUserImage(Long userId);
}
