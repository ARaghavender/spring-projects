package com.project.mnc.cc.srvc.kafka.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "kafka_message_log")
@Entity
@Data
public class KafkaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kafka_message_log_seq_generator")
    @SequenceGenerator(name = "kafka_message_log_seq_generator", sequenceName = "kafka_message_log_seq", allocationSize = 1)

    @Column(name = "id")
    public Long id;

    @Column(name = "message")
    public  String message;

    @Column(name="received_time")
    @CreationTimestamp
    private LocalDateTime receivedAt;

    @Column(name="userid")
    private Long userid;
}
