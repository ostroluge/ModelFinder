package org.acteacademie.modelfinder.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RoleEnum {

	ADMIN("admin"),
	MODEL("model"),
	STUDENT("student");

	private String role = "";
	
	private RoleEnum(String role) {
		this.role = role;
	}

	@JsonValue
	public String getRole() {
		return role;
	}

	@JsonCreator
	public static RoleEnum fromValue(String role) {
		for (final RoleEnum roleEnum : RoleEnum.values()) {
			if (roleEnum.getRole().equals(role)) {
				return roleEnum;
			}
		}
		throw new IllegalArgumentException();
	}
}
