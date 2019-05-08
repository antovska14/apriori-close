package com.students.moodle.info.data.persistence.implementation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.students.moodle.info.data.persistence.interfaces.model.Role;
import com.students.moodle.info.data.persistence.interfaces.model.User;

@Entity
@Table(name = "user")

@NamedQuery(name = "find.user.by.id", query = "select u from JpaUser u where u.id = :id")

public class JpaUser implements User {
	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@ManyToOne(targetEntity = JpaRole.class)
	@JoinColumn(name = "role_id", referencedColumnName = "id")
	private Role role;

	/**
	 * empty constructor for JPA
	 */
	protected JpaUser() {
		// JPA
	}

	public JpaUser(final Integer id, final String firstName, final String lastName, final Role role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(final Integer id) {
		this.id = id;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	@Override
	public Role getRole() {
		return role;
	}

	@Override
	public void setRole(final Role role) {
		this.role = role;
	}

}
