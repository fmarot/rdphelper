package com.teamter.demo.rdphelper.data.dataobjects;

import java.util.Date;
import java.util.SortedSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.ToString;

import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

@Entity
@ToString
public class UserSubmission implements Commentable {

	@Id
	@GeneratedValue
	private Long id;

	/** Original submitted url */
	private String url;
	private String comment;
	@ManyToOne
	private User submiter;
	
	@Getter
	@OneToMany
	@Sort(type=SortType.NATURAL)
	//@OrderBy("creationDate ASC")
	private SortedSet<Comment> comments;

	private Date creationDate;
	private Date lastModifiedDate;
	
	@PreUpdate
	private void preUpdate() {
		lastModifiedDate = new Date();
	}
	
	@PrePersist
	private void prePersist() {
		creationDate = new Date();
	}
	@Override
	public void addComment(Comment newComment) {
		comments.add(newComment);
	}
}