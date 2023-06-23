package com.sistemi.informativi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemi.informativi.entity.Tutorial;
import com.sistemi.informativi.repository.TutorialRepository;
@Service
public class TutorialServiceImpl implements TutorialService{

		@Autowired
		TutorialRepository tutorialRepository;
	@Override
	public List<Tutorial> findAllTutorials() throws Exception {
		List<Tutorial> tutorials = new ArrayList<>();
		tutorials = tutorialRepository.findAll();
		if (tutorials.isEmpty()) {
			throw new Exception("Tutorials list Empty");
		}
		return tutorials;
	}

	@Override
	public Tutorial findTutorialById(int id) throws Exception {
		return tutorialRepository.findById(id).orElseThrow(() -> new Exception("Tutorial not found"));
	}

//	@Override
//	public Tutorial findTutorialByDate(String date) throws Exception {
//		Tutorial tutorial;
//		tutorial = tutorialRepository.findByDate(date);
//		if (tutorial!=null) {
//		return tutorial;}
//		else {
//			throw new Exception ("Tutorial not found on Date"+date);
//		}
//	}

//	@Override
//	public List<Tutorial> findTutorialsBetweenDates(String date1, String date2) throws Exception {
//		List<Tutorial> tutorials = new ArrayList<>();
//
//		tutorials = tutorialRepository.findByDateBetween(date1, date2);
//		if (tutorials.isEmpty()) {
//			throw new Exception ("Tutorial not found");
//		}
//		return tutorials;
//	}

	@Override
	public Tutorial saveOrUpdateTutorial(Tutorial tutorial) throws Exception {
		Tutorial tutorialSavedOrUpdated = tutorialRepository.save(tutorial);
		if (!tutorialSavedOrUpdated.getName().equals(tutorial.getName())) {
				throw new Exception("Save or Update Failure");
		}
		return tutorialSavedOrUpdated;
	}

	@Override
	public Map<String, Boolean> removeTutorial(int id) {
		Map<String,Boolean> deletionMap = new HashMap<>();
		try {
			tutorialRepository.deleteById(id);
			deletionMap.put("deletion", true);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			deletionMap.put("deletion", false);
		}
		return deletionMap;
	}

}
