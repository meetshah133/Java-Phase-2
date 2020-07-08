package com.feedbackREST.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.feedbackREST.dao.FeedbackDAO;
import com.feedbackREST.model.Feedback;

@RestController
@RequestMapping("/ecommerce")
public class FeedbackController {
	

	
	@Autowired
	FeedbackDAO feedbackDAO;
	
	
	
	//To save feedback
	@PostMapping("/feedback")
	public Feedback createFeedback(@Valid @RequestBody Feedback feedback) {
		return feedbackDAO.save(feedback);
	}
	
	//To get all feedback
	@GetMapping("/feedback")
	public List<Feedback> getAllFeedback(){
		return feedbackDAO.readAll();
		
	}
	//To get a particular feedback by its id
	@GetMapping("/feedback/{id}")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable(value="id") int id ){
		Feedback feedback = feedbackDAO.readOne(id);
		if(feedback == null) {
			return ResponseEntity.notFound().build();
		}
		else
			return ResponseEntity.ok().body(feedback);
	}
	
	//Updating an existing feedback by id
	@PutMapping("/feedback/{id}")
	public ResponseEntity<Feedback> updateFeedbackById(@PathVariable(value = "id") int id,@Valid @RequestBody Feedback feedback){
		Feedback existingFeedback = feedbackDAO.readOne(id);
		if(existingFeedback == null) {
			return ResponseEntity.notFound().build();
		}
		
		existingFeedback.setProductName(feedback.getProductName());
		existingFeedback.setStarRating(feedback.getStarRating());
		existingFeedback.setFeedbackMsg(feedback.getFeedbackMsg());
		
		Feedback updatedFeedback = feedbackDAO.save(existingFeedback);
		return ResponseEntity.ok().body(updatedFeedback);
		
	}
	//To delete a feedback
	@DeleteMapping("/feedback/{id}")
	public ResponseEntity<Feedback> deleteFeedback(@PathVariable(value ="id") int id){
		Feedback feedback = feedbackDAO.readOne(id);
		if(feedback == null) {
			return ResponseEntity.notFound().build();
		}
		feedbackDAO.delete(feedback);
		return ResponseEntity.ok().build();
		
	}
	

	

}
