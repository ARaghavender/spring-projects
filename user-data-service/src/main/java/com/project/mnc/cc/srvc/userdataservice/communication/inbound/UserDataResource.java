package com.project.mnc.cc.srvc.userdataservice.communication.inbound;

import com.project.mnc.cc.srvc.userdataservice.service.pipeline.IudsPipeLine;
import com.adp.userdataservice.api.UdsApi;
import com.adp.userdataservice.model.UserDataDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserDataResource implements UdsApi {

	private final IudsPipeLine udsDataPipeline;
//	private final IpdsFeaturePipeline pdsFeaturePipeline;

	@Override
	public ResponseEntity<Void> addUserData( @Valid UserDataDTO userDataDTO) {
		log.info("Entered into addUserData");
        udsDataPipeline.addUserData(userDataDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<UserDataDTO> getUserDetails(Long userId) {
		log.info("Request received into get user details with userId {}",userId);
		UserDataDTO userDataDTO =udsDataPipeline.getUserDetails(userId);
		return new ResponseEntity<>(userDataDTO,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> updateUserData(Long userId,@Valid @RequestBody UserDataDTO userDataDTO) {
		log.info("Request received to activate Features {} ");
		udsDataPipeline.updateUserData(userId,userDataDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<UserDataDTO>> getAllUserDetails(){
		log.info("Entered into getAllUsersMethod");
		List<UserDataDTO> userDataDTOList = udsDataPipeline.getAllUserDetails();
		return new ResponseEntity<>(userDataDTOList,HttpStatus.OK);
	}
}