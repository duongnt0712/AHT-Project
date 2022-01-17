package com.aht.filemanagement.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController {
	
	/**
     * Size of a byte buffer to read/write file
     */
    private static final int BUFFER_SIZE = 4096;
    
    /**
     * Path of the file to be downloaded, relative to application's directory
     */
    private String filePath = "/downloads/UploadShogunWallpaper.png";
    
	private String savePath = "D:/Test/Upload";
	
	/**
     * Method for handling file upload 
	 * @throws IOException 
	 * @throws IllegalStateException 
     */
	@RequestMapping(value = "/uploadFile.do", method=RequestMethod.POST)
	public String handleFileUpload(@RequestParam CommonsMultipartFile[] fileUpload, HttpServletRequest request, Model model) throws IllegalStateException, IOException {
		System.out.println("Description: " + request.getParameter("description"));
		
		if(fileUpload != null && fileUpload.length > 0) {
			for(CommonsMultipartFile file : fileUpload) {
				System.out.println("Saving file: " + file.getOriginalFilename());
				
				if(!file.getOriginalFilename().equals("")) {
					file.transferTo(new File(savePath + file.getOriginalFilename()));
				}
			}
		}
		return "Result";
	}
	
	/**
     * Method for handling file download request from client
	 * @throws IOException 
     */
    @RequestMapping(value = "/download.do", method = RequestMethod.GET)
    public void doDownload(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
    	
    	// get absolute path of the application
    	ServletContext context = request.getServletContext();
    	String appPath = context.getRealPath("");
    	System.out.println("appPath = " + appPath);
    	
    	// construct the complete absolute path of 
    	String fullPath = appPath + filePath;
    	File downloadFile = new File(fullPath);
    	FileInputStream inputStream = new FileInputStream(downloadFile);
    	
    	// get MIME type of the file
    	String mimeType = context.getMimeType(fullPath);
    	if (mimeType == null) {
    		mimeType = "application/octet-stream";
    	} 
    	System.out.println("MIME type: " + mimeType);
    	
    	// set content attribute for the response
    	response.setContentType(mimeType);
    	response.setContentLength((int) downloadFile.length());
    	
    	// set headers for the response
    	String headerKey = "Content-Disposition";
    	String headerValue = String.format("attachment; filename = \"%s\"", downloadFile.getName());
    	response.setHeader(headerKey, headerValue);
    	
    	// get output stream of the response
    	OutputStream outputStream = response.getOutputStream();
    	
    	byte[] buffer = new byte[BUFFER_SIZE];
    	int bytesRead = -1;
    	
    	// write bytes read from the input stream into the output stream
    	while((bytesRead = inputStream.read(buffer)) != -1) {
    		outputStream.write(buffer, 0, bytesRead);
    	}
    	
    	inputStream.close();
    	outputStream.close();
    }
}
