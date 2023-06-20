package com.bestTrip.entities;

import java.io.Serializable;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "EXPERIENCES", schema = "best_trip_db")

public class Experience implements Serializable{
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idExperience;
	private URL urlTravelGuide ;
	private byte[] imageExp;

	private URL urlVideoExp;
	private String description;
	
	private enum StatusExp {waiting,approved,refused;}
	public StatusExp statusExp;
	
	@Temporal (TemporalType.DATE)
	private Date updateExp;
	
	@ManyToOne 
	@JoinColumn(name="id_account")

	
	private Account accountExperience;
	
	
	public Experience() {
		
	}



	public Experience(URL urlTravelGuide, byte[] imageExp, URL urlVideoExp, String description,

			StatusExp statusExp, Date updateExp) {
		super();
		this.urlTravelGuide = urlTravelGuide;
		this.imageExp = imageExp;

		this.urlVideoExp = urlVideoExp;

		this.description = description;
		this.statusExp = statusExp;
		this.updateExp = updateExp;
	}

	public Long getIdExperience() {
		return idExperience;
	}

	public void setIdExperience(Long idExperience) {
		this.idExperience = idExperience;
	}

	public URL getUrlTravelGuide() {
		return urlTravelGuide;
	}

	public void setUrlTravelGuide(URL urlTravelGuide2) {
		this.urlTravelGuide = urlTravelGuide2;
	}

	public byte[] getImageExp() {
		return imageExp;
	}

	public void setImageExp(byte[] imageExp) {
		this.imageExp = imageExp;
	}


	public URL getUrlVideoExp() {
		return urlVideoExp;
	}

	public void setUrlVideoExp(URL videoExp) {
		this.urlVideoExp = videoExp;
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
		return "Experience [idExperience=" + idExperience + ", urlTravelGuide=" + urlTravelGuide + ", imageExp="
				+ Arrays.toString(imageExp) + ", videoExp=" + urlVideoExp + ", description=" + description + ", statusExp="

				+ statusExp + ", updateExp=" + updateExp + ", account=" + accountExperience + "]";
	}


	


	
}
