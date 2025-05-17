package com.project.mnc.cc.srvc.userdataservice.persistence.repo;

import com.project.mnc.cc.srvc.userdataservice.persistence.entity.UserDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDataRepo extends JpaRepository<UserDataEntity, Long> {
    public Optional<UserDataEntity> findById(Long id);

}
