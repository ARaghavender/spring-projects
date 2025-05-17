package com.project.profileHub.profileservice.inbound;


import com.project.profileHub.profileservice.service.Pipeline.ProfileInterfacePipeline;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.FirstApi;
import org.openapitools.model.FirstApiDto;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@Service
@RequiredArgsConstructor
@Slf4j
@RestController
public class ProfileController implements FirstApi {
     private final ProfileInterfacePipeline fisrtsInterfacePipeline;



    @Override
    public ResponseEntity<FirstApiDto> getUserDetails(Long userId){
        FirstApiDto firstApiDto= fisrtsInterfacePipeline.getUserDetails(userId);
        return new ResponseEntity<>(firstApiDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> addUserWithImage(
            @RequestParam("userId") Long userId,
            @RequestParam("profileImage") MultipartFile profileImage,
            @RequestParam("userName") String userName,
            @RequestParam("city") String city,
            @RequestParam("zipCode") String zipCode,
            @RequestParam("phoneNumber") String phoneNumber){
         fisrtsInterfacePipeline.addUserWithImage(userId,profileImage,userName,city,zipCode,phoneNumber);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Resource> getUserImage(Long userId){
        byte[] imageData=fisrtsInterfacePipeline.getUserImage(userId);
        ByteArrayResource resource = new ByteArrayResource(imageData);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"profile_" + userId + ".jpg\"")
                .body(resource);
    }
}
