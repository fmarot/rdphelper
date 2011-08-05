package com.teamter.demo.rdphelper.data.dataobjects;

import java.util.Set;

public interface Commentable {
	void addComment(Comment newComment);
	Set<Comment> getComments();
}
