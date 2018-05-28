/**
 * 
 */
package com.mahesh.thread.waitnotify;

/**
 * @author mahesh.vira
 *
 */
public class WaitNotifierTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FileResource msg = new FileResource("process it");
		
        FileResourceReader fr1 = new FileResourceReader(msg);
        new Thread(fr1,"fr1Wait").start();
        
        FileResourceReader fr2 = new FileResourceReader(msg);
        new Thread(fr2, "fr2Wait").start();
        
        FileResourceWriter wr = new FileResourceWriter(msg);
        new Thread(wr, "wrNotifier").start();
        System.out.println("All the threads are started");
	}

}
