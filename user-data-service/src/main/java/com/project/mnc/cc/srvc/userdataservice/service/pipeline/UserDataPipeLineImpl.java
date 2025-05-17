package com.project.mnc.cc.srvc.userdataservice.service.pipeline;
import com.project.mnc.cc.srvc.userdataservice.persistence.entity.UserDataEntity;
import com.project.mnc.cc.srvc.userdataservice.service.manager.UserDataManager;
import com.adp.userdataservice.model.UserDataDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDataPipeLineImpl implements IudsPipeLine {

	private final UserDataManager userDataManager;
//	private final PDSAsyncTaskManager pdsAsyncTaskManager;
//	private final PdsFeaturePipeLineValidator pdsDataPipeLineHelper;
//	private final AuthorizationProcessor authProcessor;
//	private final PersonaProcessor personaProcessor;
//	private final ValidationProcessManager validationManager;
//	private final PDSDocumentManager pdsDocumentManager;


	@Override
	public void addUserData(UserDataDTO userDataDTO) {
		UserDataEntity userDataEntity = userDataManager.addUserData(userDataDTO);

	}

	@Override
	public UserDataDTO getUserDetails(Long userId) {
		log.info("process entered into get user data with userId {}", userId);
		UserDataDTO dto = null;
		dto = userDataManager.getUserDetails(userId);
		return dto;
	}

	@Override
	public void updateUserData(Long userId, UserDataDTO userDataDTO) {
		log.info("process entered into activateOrInactivateFeatures method to activate/inactivate features");

		UserDataEntity userDataEntity = userDataManager.updateUserData(userId, userDataDTO);
	}
	@Override
	public List<UserDataDTO> getAllUserDetails() {
		log.info("Process entered into get all user details");
		List<UserDataDTO> userDataDTOList = userDataManager.getAllUserDetails(); // Assuming this returns a List<UserDataDTO>
		return userDataDTOList;
	}

}