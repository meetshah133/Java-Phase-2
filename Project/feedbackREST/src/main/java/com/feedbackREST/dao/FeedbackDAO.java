package com.feedbackREST.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedbackREST.model.Feedback;
import com.feedbackREST.repository.FeedbackRepository;

@Service
public class FeedbackDAO {
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	
	//Create a new feedback
	
	public Feedback save(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}
	
	
	
	
	
	//read all feedbacks
	public List<Feedback> readAll(){
		return feedbackRepository.findAll();
	}
	
	//Read a particular feedback (by id)
	public Feedback readOne(int id) {
		return feedbackRepository.findOne(id);
	}
	
	
	//Delete feedback 
	public void delete(Feedback feedback) {
		feedbackRepository.delete(feedback);
	}
	
	
	

}
