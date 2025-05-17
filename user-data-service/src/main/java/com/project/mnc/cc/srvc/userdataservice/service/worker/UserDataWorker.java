package com.project.mnc.cc.srvc.userdataservice.service.worker;
import com.project.mnc.cc.srvc.userdataservice.persistence.entity.UserDataEntity;
import com.project.mnc.cc.srvc.userdataservice.persistence.repo.UserDataRepo;
import com.adp.userdataservice.model.UserDataDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserDataWorker {

	private final UserDataRepo userDataRepo;



	public UserDataEntity addUserData(UserDataDTO userDataDTO) {
		UserDataEntity userDataEntity=new UserDataEntity();
		userDataEntity.setId(userDataDTO.getUserId());
		userDataEntity.setFirstName(userDataDTO.getFirstName());
		userDataEntity.setLastName(userDataDTO.getLastName());
		userDataEntity.setEmailAddress(userDataDTO.getEmailAddress());
		userDataEntity.setCity(userDataDTO.getCity());
		return userDataRepo.save(userDataEntity);
	}

	public UserDataDTO getUserDetails(Long userId) {
		UserDataDTO userDataDTO=new UserDataDTO();
		Optional<UserDataEntity> userDataEntityOptional=userDataRepo.findById(userId);
		UserDataEntity userDataEntity=userDataEntityOptional.get();
		userDataDTO.setUserId(userDataEntity.getId());
		userDataDTO.setCity(userDataEntity.getCity());
		userDataDTO.setEmailAddress(userDataEntity.getEmailAddress());
		userDataDTO.setFirstName(userDataEntity.getFirstName());
		userDataDTO.setLastName(userDataEntity.getLastName());
		return userDataDTO;
	}

	public UserDataEntity updateUserData(Long userId, UserDataDTO userDataDTO) {
		UserDataEntity updateUserDataEntity=null;
		Optional<UserDataEntity> userDataEntityOptional=userDataRepo.findById(userId);
		updateUserDataEntity=userDataEntityOptional.get();
		updateUserDataEntity.setCity(userDataDTO.getCity());
		updateUserDataEntity.setEmailAddress(userDataDTO.getEmailAddress());
		updateUserDataEntity.setFirstName(userDataDTO.getFirstName());
		updateUserDataEntity.setLastName(userDataDTO.getLastName());
//		updateUserDataEntity.setId(userDataDTO.getUserId());

		return userDataRepo.save(updateUserDataEntity);

	}

	public List<UserDataDTO> getAllUserDetails() {

		List<UserDataEntity> userDataEntities=userDataRepo.findAll();
		List<UserDataDTO> userDataDTOList= new ArrayList<>();
		for(UserDataEntity user : userDataEntities){
			UserDataDTO userDataDTO=new UserDataDTO();
			userDataDTO.setUserId(user.getId());
			userDataDTO.setCity(user.getCity());
			userDataDTO.setEmailAddress(user.getEmailAddress());
			userDataDTO.setFirstName(user.getFirstName());
			userDataDTO.setLastName(user.getLastName());
			userDataDTOList.add(userDataDTO);

		}

		return userDataDTOList;
	}
}