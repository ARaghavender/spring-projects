package com.project.mnc.cc.srvc.userdataservice.service.manager;

import com.project.mnc.cc.srvc.userdataservice.persistence.entity.UserDataEntity;

import com.project.mnc.cc.srvc.userdataservice.service.worker.UserDataWorker;
import com.adp.userdataservice.model.UserDataDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
@Slf4j
public class UserDataManager {

	private final UserDataWorker userDataWorker;


	public UserDataEntity addUserData(UserDataDTO userDataDTO) {

		return userDataWorker.addUserData(userDataDTO);
	}

	public UserDataDTO getUserDetails(Long userId) {
		return userDataWorker.getUserDetails(userId);
	}

	public UserDataEntity updateUserData(Long userId, UserDataDTO userDataDTO) {
		return userDataWorker.updateUserData(userId, userDataDTO);

	}

	public List<UserDataDTO> getAllUserDetails() {
		List<UserDataDTO> userDataDTOList=userDataWorker.getAllUserDetails();
		return userDataDTOList;
	}
}