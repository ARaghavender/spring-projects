package com.project.mnc.cc.srvc.userdataservice.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Table(name = "USER_DATA")
@Entity
@Data
//@NoArgsConstructor
public class UserDataEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USERID")
	private Long id;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "EMAILADDRESS")
	private String emailAddress;

	@Column(name = "CITY")
	private String city;

}
