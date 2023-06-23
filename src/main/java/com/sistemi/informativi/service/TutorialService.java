package com.sistemi.informativi.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sistemi.informativi.entity.Tutorial;

public interface TutorialService {
	
	public List<Tutorial> findAllTutorials () throws Exception;
	
	public Tutorial findTutorialById (int id) throws Exception;
	
//	public Tutorial findTutorialByDate (String date) throws Exception;
	
//	public List<Tutorial> findTutorialsBetweenDates (String date1,String date2) throws Exception;

	public Tutorial saveOrUpdateTutorial (Tutorial tutorial) throws Exception;
	
	public Map<String,Boolean> removeTutorial (int id);
}
