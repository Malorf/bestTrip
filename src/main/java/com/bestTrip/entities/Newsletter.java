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
@Table(name = "NEWSLETTERS", schema = "best_trip_db")
public class Newsletter implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNewsletter;
	@Temporal (TemporalType.DATE)
	private Date publicationDate;
	private URL favoriteTripOfTheMonth;
	private byte[] imageNewsletter;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_account")
	private Account accountNewsletter;
	
	public Newsletter() {
		
	}

	public Newsletter(Date publicationDate, URL favoriteTripOfTheMonth, byte[] imageNewsletter) {
		
		this.publicationDate = publicationDate;
		this.favoriteTripOfTheMonth = favoriteTripOfTheMonth;
		this.imageNewsletter = imageNewsletter;
	}

	public Long getIdNewsletter() {
		return idNewsletter;
	}

	public void setIdNewsletter(Long idNewsletter) {
		this.idNewsletter = idNewsletter;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public URL getFavoriteTripOfTheMonth() {
		return favoriteTripOfTheMonth;
	}

	public void setFavoriteTripOfTheMonth(URL favoriteTripOfTheMonth) {
		this.favoriteTripOfTheMonth = favoriteTripOfTheMonth;
	}

	public byte[] getImageNewsletter() {
		return imageNewsletter;
	}

	public void setImageNewsletter(byte[] imageNewsletter) {
		this.imageNewsletter = imageNewsletter;
	}
	
	public Account getAccount() {
		return accountNewsletter;
	}

	public void setAccount(Account account) {
		this.accountNewsletter= account;
	}

	@Override
	public String toString() {
		return "Newsletter [idNewsletter=" + idNewsletter + ", publicationDate=" + publicationDate
				+ ", favoriteTripOfTheMonth=" + favoriteTripOfTheMonth + ", imageNewsletter="
				+ Arrays.toString(imageNewsletter) + ", account=" + accountNewsletter + "]";
	}

	
	
	
}
