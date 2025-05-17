package com.project.profileHub.profileservice.persistence.repo;

import com.project.profileHub.profileservice.persistence.entity.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetailsEntity,Long> {
      public Optional<UserDetailsEntity> findById(Long id);
}
