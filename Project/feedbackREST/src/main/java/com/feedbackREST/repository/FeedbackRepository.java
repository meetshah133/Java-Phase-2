package com.feedbackREST.repository;
import com.feedbackREST.model.*;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {

}
