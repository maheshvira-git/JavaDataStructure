/**
 * 
 */
package com.mahesh.thread.waitnotify;

/**
 * @author mahesh.vira
 *
 */
public class FileResourceReader implements Runnable{

	private FileResource fileResource;
	
	public FileResourceReader(FileResource fileResource){
		this.fileResource=fileResource;
	}
	
	@Override
	public void run() {

		String name = Thread.currentThread().getName();
        synchronized (fileResource) {
            try{
                System.out.println(name+" waiting to get notified at time:"+System.currentTimeMillis());
                fileResource.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(name+" FileResourceReader thread got notified at time:"+System.currentTimeMillis());
            //process the message now
            System.out.println(name+" processed: "+fileResource.readFile());
        }
	}
}
