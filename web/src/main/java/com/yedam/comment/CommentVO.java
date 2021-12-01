package com.yedam.comment;

public class CommentVO {
	private String id;
	private String name;
	private String cotent;
	
	

	public CommentVO(String id, String name, String cotent) {
		super();
		this.id = id;
		this.name = name;
		this.cotent = cotent;
	}



	public CommentVO() {
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCotent() {
		return cotent;
	}

	public void setCotent(String cotent) {
		this.cotent = cotent;
	}

	@Override
	public String toString() {
		return "CommentVO [id=" + id + ", name=" + name + ", cotent=" + cotent + "]";
	}

}