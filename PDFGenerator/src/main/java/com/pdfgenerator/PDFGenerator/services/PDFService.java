package com.pdfgenerator.PDFGenerator.services;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.swing.text.StyledEditorKit.FontFamilyAction;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.pdfgenerator.PDFGenerator.beans.DataBean;

import ch.qos.logback.classic.Logger;

@Service
public class PDFService {
	
	private Logger logger = (Logger) LoggerFactory.getLogger(PDFService.class);
	
	public ByteArrayInputStream createPdf(DataBean data) {
		
		logger.info("createPdf starts");
		
		String title = data.getTitle();
		String content = data.getContent();
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		Document document = new Document();
		
		PdfWriter.getInstance(document, outputStream);
		
		document.open();
		
		Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,25);
		Paragraph titlePara = new Paragraph(title,titleFont);
		titlePara.setAlignment(Element.ALIGN_CENTER);
		document.add(titlePara);
		
		Font contentFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,18);
		Paragraph contentPara = new Paragraph(content,contentFont);
		contentPara.setAlignment(Element.ALIGN_CENTER);
		document.add(contentPara);
		
		document.close();
		
		return new ByteArrayInputStream(outputStream.toByteArray());
		
	}

}
