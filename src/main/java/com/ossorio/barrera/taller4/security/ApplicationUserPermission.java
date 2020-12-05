package com.ossorio.barrera.taller4.security;

public enum ApplicationUserPermission {

	INSTITUTION_READ("institution:read"), INSTITUTION_WRITE("institution:write"), POLL_READ("poll:read"),
	POLL_WRITE("poll:write"), QUESTION_READ("question:read"), QUESTION_WRITE("question:write"),
	WEIGHT_READ("weight:read"), WEIGHT_WRITE("weight:write");

	private final String permission;

	private ApplicationUserPermission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}

}
