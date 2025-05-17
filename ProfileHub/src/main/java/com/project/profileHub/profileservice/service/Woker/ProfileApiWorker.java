package com.project.profileHub.profileservice.service.Woker;

import com.project.profileHub.profileservice.persistence.entity.UserDetailsEntity;
import com.project.profileHub.profileservice.persistence.repo.UserDetailsRepo;
import com.project.kafka.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.model.FirstApiDto;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProfileApiWorker {


    public final UserDetailsRepo userDetailsRepo;
    public final KafkaProducerService kafkaProducerService;
    public UserDetailsEntity addUserDetails(Long userId, MultipartFile profileImage,
                                            String userName, String city, String zipCode, String phoneNumber) {
        try {
            UserDetailsEntity userDetailsEntity = new UserDetailsEntity();
            userDetailsEntity.setId(userId);
            userDetailsEntity.setUserName(userName);
            userDetailsEntity.setCity(city);
            userDetailsEntity.setZipCode(zipCode);
            userDetailsEntity.setPhno(phoneNumber);
            userDetailsEntity.setImage(profileImage.getBytes()); // May throw IOException
            kafkaProducerService.sendMessage("User details saved successfully with  {userId}",userId);
            return userDetailsRepo.save(userDetailsEntity);
        } catch (IOException e) {
            throw new RuntimeException("Error while reading profile image", e);
        }
    }
    public FirstApiDto getUserDetails(Long userid){


        FirstApiDto firstApiDto=new FirstApiDto();
        Optional<UserDetailsEntity> userDetailsEntityOptional= userDetailsRepo.findById(userid);
        if(userDetailsEntityOptional.isPresent()){
        UserDetailsEntity userDetailsEntity= userDetailsEntityOptional.get();
        String base64Image = Base64.getEncoder().encodeToString(userDetailsEntity.getImage());

        firstApiDto.setUserId(userDetailsEntity.getId());
        if(!base64Image.isEmpty()){
            firstApiDto.setProfileImage("Use GET-USER-IMAGE API to download the file");
        }
        else{
            firstApiDto.setProfileImage("No Image found");
        }
        firstApiDto.setUserName(userDetailsEntity.getUserName()) ;
        firstApiDto.setCity(userDetailsEntity.getCity());
        firstApiDto.setZipCode(userDetailsEntity.getZipCode());
        firstApiDto.setPhoneNumber(userDetailsEntity.getPhno());
            return firstApiDto;
        }
      else{
          throw  new RuntimeException("User Not Found");
        }

    }

    public byte[] getUserImage(Long userId){

        Optional<UserDetailsEntity> userDetailsEntityOptional= userDetailsRepo.findById(userId);
        if(userDetailsEntityOptional.isPresent()) {
            UserDetailsEntity userDetailsEntity = userDetailsEntityOptional.get();
            return userDetailsEntity.getImage();
        }
        else {
            throw  new RuntimeException("User not found");
        }
    }
}
