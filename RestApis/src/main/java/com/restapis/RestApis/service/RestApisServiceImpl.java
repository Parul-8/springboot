package com.restapis.RestApis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restapis.RestApis.beans.Courses;

@Service
public class RestApisServiceImpl implements RestApisService {
	
	List<Courses> list;
	
	Courses course = null;
	
	RestApisServiceImpl(){
		list = new ArrayList<>();
		list.add(new Courses(111,"JavaCore","Learn Java Core: Beginner's Guide"));
		list.add(new Courses(143,"ReactJS","Learn ReactJS in one short"));
	}

	@Override
	public List<Courses> getCourses() {
		
		return list;
	}

	@Override
	public Courses getCourse(long courseId) {
		
		for(Courses c:list) {
			if(c.getId() == courseId) {
				course = c;
				break;
				
			}
		}
		
		return course;
	}

	@Override
	public Courses addCourse(Courses course) {
		list.add(course);
		return course;
	}

	@Override
	public Courses updateCourse(Courses course) {
		for(Courses c:list) {
			if(c.getId() == course.getId()) {
				c.setTitle(course.getTitle());
				c.setDesc(course.getDesc());
			}
		}
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
		
		list=this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
	}

	

//	@Override
//	public void deleteCourse(long courseId) {
//		for(Courses c:list) {
//			if (c.getId() == courseId){
//				list.remove(c);
//				
//			}
//		}
//		
//	}

}
