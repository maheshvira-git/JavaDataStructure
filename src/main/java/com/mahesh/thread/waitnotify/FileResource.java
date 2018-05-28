/**
 * 
 */
package com.mahesh.thread.waitnotify;

/**
 * @author mahesh.vira
 *
 */
public class FileResource {

	private String data;
	
	public FileResource(String data) {
		this.data=data;
	}
	public String readFile() {
		return data;
	}
	
	public synchronized void writeFile(String data) {
		this.data=data;
	}
}
