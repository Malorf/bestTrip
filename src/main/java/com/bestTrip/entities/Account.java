package com.bestTrip.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.FetchType;



@Entity
@Table(name="ACCOUNTS", schema ="best_trip_db")
public class Account {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idAccount;
	//Start Auth
	@Column(unique=true)
	private String username;
	private String password;
	private String eMail;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="PROFILS", joinColumns=@JoinColumn(name="id_user", referencedColumnName="idAccount"),inverseJoinColumns =@JoinColumn(name="id_role",referencedColumnName="idRole"))
	private Set<Role> roles = new HashSet<>();
	//END Auth
	//UserProfil
	private String profileName="toto";
	private byte[] imageAccount;
	private int numberOfGuideContributions=0;
	private int numberOfExepriencesShared=0;
	private boolean sub; //subscribe to the newsletter
	
	//Associations
	@OneToMany(mappedBy="accountReview", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Review> reviews = new ArrayList<>();
	@OneToMany(mappedBy="accountTravelGuide", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<TravelGuide> travelGuides = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy="accountExperience", cascade = CascadeType.ALL, fetch=FetchType.LAZY)

	private List<Experience> experiences = new ArrayList<>();
	@OneToMany(mappedBy="accountNewsletter", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Newsletter> newsletters = new ArrayList<>();
	
	public Account() {
		
	}

	public Account(String username, String password, String eMail, Set<Role> roles, String profileName,
			byte[] imageAccount, int numberOfGuideContributions, int numberOfExepriencesShared, boolean sub) {
		super();
		this.username = username;
		this.password = password;
		this.eMail = eMail;
		this.roles = roles;
		this.profileName = profileName;
		this.imageAccount = imageAccount;
		this.numberOfGuideContributions = numberOfGuideContributions;
		this.numberOfExepriencesShared = numberOfExepriencesShared;
		this.sub = sub;
	}

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public byte[] getImageAccount() {
		return imageAccount;
	}

	public void setImageAccount(byte[] imageAccount) {
		this.imageAccount = imageAccount;
	}

	public int getNumberOfGuideContributions() {
		return numberOfGuideContributions;
	}

	public void setNumberOfGuideContributions(int numberOfGuideContributions) {
		this.numberOfGuideContributions = numberOfGuideContributions;
	}

	public int getNumberOfExepriencesShared() {
		return numberOfExepriencesShared;
	}

	public void setNumberOfExepriencesShared(int numberOfExepriencesShared) {
		this.numberOfExepriencesShared = numberOfExepriencesShared;
	}

	public boolean isSub() {
		return sub;
	}

	public void setSub(boolean sub) {
		this.sub = sub;
	}

	
	public List<Review> getReviews() {
		return reviews;
	}
	
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<TravelGuide> getTravelGuides() {
		return travelGuides;
	}

	public void setTravelGuides(List<TravelGuide> travelGuides) {
		this.travelGuides = travelGuides;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public List<Newsletter> getNewsletters() {
		return newsletters;
	}

	public void setNewsletters(List<Newsletter> newsletters) {
		this.newsletters = newsletters;
	}

	@Override
	public String toString() {
		return "Account [idAccount=" + idAccount + ", username=" + username + ", password=" + password + ", eMail="
				+ eMail + ", roles=" + roles + ", profileName=" + profileName + ", imageAccount="
				+ Arrays.toString(imageAccount) + ", numberOfGuideContributions=" + numberOfGuideContributions
				+ ", numberOfExepriencesShared=" + numberOfExepriencesShared + ", sub=" + sub + "]";
	}
	

}
