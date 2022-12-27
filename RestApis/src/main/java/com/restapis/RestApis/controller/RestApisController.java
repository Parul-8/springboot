package com.restapis.RestApis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapis.RestApis.beans.Courses;
import com.restapis.RestApis.service.RestApisService;

@RestController
public class RestApisController {
	
	@Autowired
	private RestApisService courseService;
	
	@GetMapping("/home")                //@RequestMapping(path="/home",method=RequestMethod.GET)
	public String home() {
		return "Welcome to Parul's App";
	}
	
	@GetMapping("/courses")
	public List<Courses> getCourses(){
		return this.courseService.getCourses();
		
	}
	
	@GetMapping("/courses/{courseId}")
	public Courses getCourse(@PathVariable Long courseId) {
		return this.courseService.getCourse(courseId);
		
	}
	
	@PostMapping(path="/addcourse", consumes="application/json")
	public Courses addCourse(@RequestBody Courses course) {
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/updatecourse")
	public Courses updateCourse(@RequestBody Courses course) {
		return this.courseService.updateCourse(course);
	}
	
//	@DeleteMapping("/deletecourse/{courseId}")
//	public void deleteCourse(@PathVariable long courseId) {
//		this.courseService.deleteCourse(courseId);
//	}
	
	@DeleteMapping("/deletecourse/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					
		}
		
	}
	

}
