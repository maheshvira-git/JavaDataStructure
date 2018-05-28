package com.mahesh.collection.lrucache;

/**
 * @author mahesh.vira
 *
 */
public class LRUTest {

  /**
   * @param args
   */
  public static void main(String[] args) {

    LRUCache cache = new LRUCache(3);
    
    cache.set(1, 10);
    System.out.println(cache);
    
    cache.set(2, 20);
    System.out.println(cache);
    
    cache.set(3, 30);
    System.out.println(cache);
    
    cache.set(4, 40);
    System.out.println(cache);

    cache.get(3);
    System.out.println(cache);
    
  }

}
