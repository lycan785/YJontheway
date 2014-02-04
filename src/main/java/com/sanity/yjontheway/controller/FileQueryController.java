package com.sanity.yjontheway.controller;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.queryParser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sanity.yjontheway.common.ExceptionDetail;
import com.sanity.yjontheway.model.FileObject;
import com.sanity.yjontheway.service.FileQueryService;

@Controller
@RequestMapping("/fileQuery")
public class FileQueryController {
	
	@Autowired
	private FileQueryService searchFileService;
	private Logger logger = LoggerFactory.getLogger(FileQueryController.class);
	
	/**
	 * @param reservationService the reservationService to set
	 */
	public void setReservationService(FileQueryService searchFileService) {
		this.searchFileService = searchFileService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void setupForm(){
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public  String submitForm(@RequestParam("fileName") String fileName, Model model) throws CorruptIndexException, IOException, ParseException{
		List<FileObject> files = java.util.Collections.emptyList();
		if(fileName != null){
			files = searchFileService.query(fileName);
			logger.info("ExceptionDetail");
			
		}
		else{
			logger.debug(ExceptionDetail.FILENAME_IS_NULL);
		}
		model.addAttribute("files",files);
		return "fileQuery";
		
		
	}

}
