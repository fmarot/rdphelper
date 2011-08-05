package com.teamter.demo.rdphelper.data.dataobjects;

import java.util.Date;
import java.util.Set;
import java.util.SortedSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.ToString;

import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

@Entity
@ToString
public class SubmittedLink implements Commentable {

	@Id
	@GeneratedValue
	private Long id;

	/** Base url deduced from user submissions */
	private String webUrl;

	@OneToMany
	@OrderBy("creationDate ASC")
	private Set<UserSubmission> userSuggestions;

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