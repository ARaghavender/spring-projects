package com.project.mnc.cc.srvc.kafka.repo;



import com.project.mnc.cc.srvc.kafka.entity.KafkaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KafkaMessageLogRepo extends JpaRepository<KafkaEntity, Long> {
}
