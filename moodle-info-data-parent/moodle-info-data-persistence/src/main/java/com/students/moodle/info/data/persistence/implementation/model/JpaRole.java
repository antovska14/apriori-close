package com.students.moodle.info.data.persistence.implementation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.students.moodle.info.data.persistence.interfaces.model.Role;

@Entity
@Table(name = "ROLE")

@NamedQuery(name = "find.role.id", query = "select r from JpaRole r where r.id = :id")
public class JpaRole implements Role {
	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	/**
	 * empty constructor for JPA
	 */
	protected JpaRole() {
		// JPA
	}

	public JpaRole(final Integer id, final String name) {
		this.id = id;
		this.name = name;
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
	public String getName() {
		return name;
	}

	@Override
	public void setName(final String name) {
		this.name = name;
	}

}
