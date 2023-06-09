package com.bestTrip.entities;

import java.io.Serializable;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EXPERIENCE", schema = "best_trip_db")

public class Experience implements Serializable{
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idExperience;
	private URL urlTravelGuide ;
	private byte[] imageExp;
	private URL videoExp;
	private String description;
	
	private enum statusExp {waiting,approved,refus;}
	public statusExp statusExp;
	
	@Temporal (TemporalType.DATE)
	private Date updateExp;

	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="id_account")
	private Account experience;
	
	
	public Experience() {
		
	}


	public Experience(URL urlTravelGuide, byte[] imageExp, URL videoExp, String description,
			com.bestTrip.entities.Experience.statusExp statusExp, Date updateExp) {
		super();
		this.urlTravelGuide = urlTravelGuide;
		this.imageExp = imageExp;
		this.videoExp = videoExp;
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

	public void setUrlTravelGuide(URL urlTravelGuide) {
		this.urlTravelGuide = urlTravelGuide;
	}

	public byte[] getImageExp() {
		return imageExp;
	}

	public void setImageExp(byte[] imageExp) {
		this.imageExp = imageExp;
	}

	public URL getVideoExp() {
		return videoExp;
	}

	public void setVideoExp(URL videoExp) {
		this.videoExp = videoExp;
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
	
	public statusExp getStatusExp() {
		return statusExp;
	}


	public void setStatusExp(statusExp statusExp) {
		this.statusExp = statusExp;
	}

	
	public Account getAccount() {
		return experience;
	}


	public void setAccount(Account account) {
		this.experience = account;
	}


	@Override
	public String toString() {
		return "Experience [idExperience=" + idExperience + ", urlTravelGuide=" + urlTravelGuide + ", imageExp="
				+ Arrays.toString(imageExp) + ", videoExp=" + videoExp + ", description=" + description + ", statusExp="
				+ statusExp + ", updateExp=" + updateExp + ", account=" + experience + "]";
	}


	


	
}
