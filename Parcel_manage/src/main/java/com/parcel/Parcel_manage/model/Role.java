package com.parcel.Parcel_manage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	private int role_id;

	@Column(nullable = false)
	private String name; // e.g., CUSTOMER, OFFICER, ADMIN

	// Constructors
	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	public Role(int role_id, String name) {
		this.role_id = role_id;
		this.name = name;
	}

	// Getters and setters
	public int getId() {
		return role_id;
	}

	public void setId(int role_id) {
		this.role_id = role_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
