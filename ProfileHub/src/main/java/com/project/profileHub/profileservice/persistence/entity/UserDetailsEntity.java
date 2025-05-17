package com.project.profileHub.profileservice.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Table(name = "USER_DETAILS")
@Entity
@Data
public class UserDetailsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="USER_ID")
    public long id;

    @Column(name="USERNAME")
    public String userName;

    @Column(name="CITY")
    public String city;

    @Column(name="ZIPCODE")
    public String zipCode;

    @Column(name="PHONENO")
    public String phno;
    @Lob
    @Column(name="IMAGE")
    private byte[] image;
}
