package com.problem2;

import java.io.File;
import java.util.List;

public class ReadWriteCenter {
	
	File file;
	String contentToWrite;
	String contentToAppend;

	public ReadWriteCenter(File file, String contentToWrite, String contentToAppend) {
		super();
		this.file = file;
		this.contentToWrite = contentToWrite;
		this.contentToAppend = contentToAppend;
	}

	public void writeToFile() {
		
	}
	
	public void appendToFile() {
		
	}
	
	public List<Integer> getAnalysis() {
		return null;
		
	}
}

//public void writeToFile() used to write content to file that is stored in variable contentToWrite.
//
//public void appendToFile() used to append content to file that is stored in variable contentToAppend.
//
//public List<Integer> getAnalysis() used to read content from file and return a list. 
//The list should contains digit count, letter count & special symbol count in the content of file at index 0, 1 and 2 respectively.