package com.sistemi.informativi.controller;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemi.informativi.entity.Tutorial;
import com.sistemi.informativi.service.TutorialService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {

		@Autowired
		TutorialService tutorialService;
		
	@GetMapping("")
	public List<Tutorial> findAllTutorials () throws Exception{
		
		return tutorialService.findAllTutorials();
	}
	@GetMapping("/tutorial-id/{id}")
	public Tutorial findTutorialById (@PathVariable int id) throws Exception {
		
		return tutorialService.findTutorialById(id);
		
	}
//	@GetMapping("/date/{date}")
//	public Tutorial findTutorialByDate ( @PathVariable String date) throws Exception {
//		
//		return tutorialService.findTutorialByDate(date);
//	}
//	@GetMapping("/date/{date1}/{date2}")
//	public List<Tutorial> findTutorialsBetweenDates (@PathVariable String date1,@PathVariable String date2) throws Exception{
//		return tutorialService.findTutorialsBetweenDates(date1, date2);
//	}
	
	@PostMapping
	public Tutorial saveTutorial (@RequestBody Tutorial tutorial) throws Exception {
		return tutorialService.saveOrUpdateTutorial(tutorial);
	}
	
	@PutMapping
	public Tutorial updateTutorial (@RequestBody Tutorial tutorial) throws Exception {
		return tutorialService.saveOrUpdateTutorial(tutorial);
	}
	@DeleteMapping("/tutorial-id/{id}")
	public Map<String,Boolean> removeTutorial (@PathVariable int id){
		
		return tutorialService.removeTutorial(id);
	}
	
}
