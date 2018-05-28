/**
 * 
 */
package com.mahesh.thread.waitnotify;

import java.util.concurrent.TimeUnit;

/**
 * @author mahesh.vira
 *
 */
public class FileResourceWriter implements Runnable {

	private FileResource fileResource;

	public FileResourceWriter(FileResource fileResource) {
		this.fileResource = fileResource;
	}

	@Override
	public void run() {

		String name = Thread.currentThread().getName();
		System.out.println(name + " started");
		try {
			TimeUnit.SECONDS.sleep(1);
			synchronized (fileResource) {
				fileResource.writeFile(name + " Notifier work done");
				fileResource.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
