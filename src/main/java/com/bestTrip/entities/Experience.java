package com.bestTrip.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "EXPERIENCES", schema = "best_trip_db")

public class Experience implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idExperience;
	private String urlTravelGuide ;
	/*@Lob
	private byte[] imageExp;*/

	private String urlVideoExp;
	private String description;
	
	private enum StatusExp {waiting,approved,refused;}
	public StatusExp statusExp;
	
	@Temporal (TemporalType.DATE)
	private Date updateExp;
	
	@ManyToOne (fetch= FetchType.LAZY)
	@JoinColumn(name="id_account")
	@JsonIgnore
	private Account accountExperience;
	
	
	public Experience() {
		
	}


	public Experience(String urlTravelGuide, String urlVideoExp, String description, StatusExp statusExp,
			Date updateExp, Account accountExperience) {
		
		this.urlTravelGuide = urlTravelGuide;
		this.urlVideoExp = urlVideoExp;
		this.description = description;
		this.statusExp = statusExp;
		this.updateExp = updateExp;
		//this.accountExperience = accountExperience;
	}



	public Long getIdExperience() {
		return idExperience;
	}

	public void setIdExperience(Long idExperience) {
		this.idExperience = idExperience;
	}

	public String getUrlTravelGuide() {
		return urlTravelGuide;
	}

	public void setUrlTravelGuide(String urlTravelGuide) {
		this.urlTravelGuide = urlTravelGuide;
	}

	

	public String getUrlVideoExp() {
		return urlVideoExp;
	}

	public void setUrlVideoExp(String urlVideoExp) {
		this.urlVideoExp = urlVideoExp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getUpdateExp() {
		return updateExp;
	}

	public void setUpdateExp(Date updateExp) {
		this.updateExp = updateExp;
	}
	
	public StatusExp getStatusExp() {
		return statusExp;
	}


	public void setStatusExp(StatusExp statusExp) {
		this.statusExp = statusExp;
	}

	public Long getAccount() {
		return accountExperience.getIdAccount();
	}
	

	public void setAccount(Account account) {
		this.accountExperience = account;
	}


	@Override
	public String toString() {
		return "Experience [idExperience=" + idExperience + ", urlTravelGuide=" + urlTravelGuide  + ", videoExp=" + urlVideoExp + ", description=" + description + ", statusExp="

				+ statusExp + ", updateExp=" + updateExp + ", account=" + accountExperience + "]";
	}


	


	
}
