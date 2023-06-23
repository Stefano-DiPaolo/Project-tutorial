package com.sistemi.informativi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sistemi.informativi.entity.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial,Integer> {
	
//	public Tutorial findByDate (String date);
	
//	public List<Tutorial> findByDateBetween(String date1, String date2);


	

}
