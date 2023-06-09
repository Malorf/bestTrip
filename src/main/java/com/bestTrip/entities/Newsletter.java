package com.bestTrip.entities;

import java.io.Serializable;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "NEWSLETTER", schema = "best_trip_db")
public class Newsletter implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNewsletter;
	@Temporal (TemporalType.DATE)
	private Date publicationDate;
	private URL favoriteTripOfTheMonth;
	private byte[] imageNewsletter;
	
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

	@Override
	public String toString() {
		return "Newsletter [idNewsletter=" + idNewsletter + ", publicationDate=" + publicationDate
				+ ", favoriteTripOfTheMonth=" + favoriteTripOfTheMonth + ", imageNewsletter="
				+ Arrays.toString(imageNewsletter) + "]";
	}
	
	
}
