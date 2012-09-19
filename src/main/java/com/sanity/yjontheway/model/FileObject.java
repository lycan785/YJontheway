package com.sanity.yjontheway.model;


public class FileObject {
	private String fileName;
	private String filePath;
	public FileObject(String fileName, String filePath) {
		super();
		this.fileName = fileName;
		this.filePath = filePath;
	}
	
	public FileObject() {
		super();
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
}
