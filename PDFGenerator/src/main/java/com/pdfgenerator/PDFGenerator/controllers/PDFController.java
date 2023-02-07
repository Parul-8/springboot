package com.pdfgenerator.PDFGenerator.controllers;


import java.io.ByteArrayInputStream;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.pdfgenerator.PDFGenerator.beans.DataBean;
import com.pdfgenerator.PDFGenerator.services.PDFService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PDFController {
	
	
	
	@Autowired
	private PDFService pdfService;
	
	@GetMapping("/pdf")
	public String home(Model model) {
		model.addAttribute("title","PDFGeneratorApp");
		model.addAttribute("data", new DataBean());
		return "index";
	}
	
	@PostMapping("/generate")
	public ResponseEntity<InputStreamResource> textToPdfConverter(@ModelAttribute("data") DataBean data, HttpSession session, Model model) {
		
			
			model.addAttribute("data", data);
			ResponseEntity<InputStreamResource> pdfEntity = createPdf(data);
			return pdfEntity;
			
		
		
	}
	
	
	public ResponseEntity<InputStreamResource> createPdf(DataBean data) {
		
		ByteArrayInputStream pdf = pdfService.createPdf(data);
		System.out.println(pdf);
		
		org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
		
		httpHeaders.add("Content-Disposition", "inline;filename=Document.pdf");
		httpHeaders.put("Content-Type",  Arrays.asList("application/pdf"));
		
		
		
		return ResponseEntity.ok()
				.headers(httpHeaders)
                .body(new InputStreamResource(pdf));
		
	}
	
	

}
