package com.teamter.demo.rdphelper.data.dataobjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
public class Comment {
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private User commenter;
	private String content;
}
