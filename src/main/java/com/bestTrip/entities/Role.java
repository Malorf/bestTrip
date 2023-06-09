package com.bestTrip.entities;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="ROLES", schema = "best_trip_db")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRole;
	private String nameRole;
	
	public Role() {
		
	}
	public Role(String nameRole)
	{
		this.nameRole=nameRole;
	}
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getNameRole() {
		return nameRole;
	}
	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}
	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", nameRole=" + nameRole + "]";
	}
	

}
