package com.feedbackREST.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//This will be our entity class to store Feedback into database

@Entity
@Table(name="feedback")
@EntityListeners(AuditingEntityListener.class)
public class Feedback {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotBlank
	private String productName;
	
	@NotBlank
	private String userName;
	
	private long starRating;
	
	private String feedbackMsg;
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getStarRating() {
		return starRating;
	}
	public void setStarRating(long starRating) {
		this.starRating = starRating;
	}
	public String getFeedbackMsg() {
		return feedbackMsg;
	}
	public void setFeedbackMsg(String feedbackMsg) {
		this.feedbackMsg = feedbackMsg;
	}
	

}
