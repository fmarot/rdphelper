package com.teamter.demo.rdphelper.data.dataobjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
public class User {
	@Id
	@GeneratedValue
	private Long id;
	
	private String email;
}
