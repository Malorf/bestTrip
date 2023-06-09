package com.bestTrip.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name = "REVIEWS", schema = "best_trip_db")
public class Review implements Serializable  {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReview;
	private String comment;
	private float userRating;
	private Long reviewObjectId; 
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn (name="idAccount")
	private Account account;
	public enum reviewObjectType {TravelGuide, Place, Transport};
	
	public Review() {
		
	}
	public Review(String comment, float userRating, Long reviewObjectId, Account account) {
		super();
		this.comment = comment;
		this.userRating = userRating;
		this.reviewObjectId = reviewObjectId;
		this.account = account;
	}
	public Long getIdReview() {
		return idReview;
	}
	public void setIdReview(Long idReview) {
		this.idReview = idReview;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public float getUserRating() {
		return userRating;
	}
	public void setUserRating(float userRating) {
		this.userRating = userRating;
	}
	public Long getReviewObjectId() {
		return reviewObjectId;
	}
	public void setReviewObjectId(Long reviewObjectId) {
		this.reviewObjectId = reviewObjectId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	@Override
	public String toString() {
		return "Review [idReview=" + idReview + ", comment=" + comment + ", userRating=" + userRating
				+ ", reviewObjectId=" + reviewObjectId + "]";
	}
	
	}

	
	


