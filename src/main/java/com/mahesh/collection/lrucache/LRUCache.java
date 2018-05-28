package com.mahesh.collection.lrucache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mahesh.vira
 *
 */
class LNode {

  int key;
  int value;
  LNode pre;
  LNode next;

  public LNode(int key, int value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public String toString() {
    return "["+key+","+value+"]";
  }
  
}


public class LRUCache {

  int capacity;

  Map<Integer, LNode> map = new HashMap<>();

  LNode head;
  LNode end;

  public LRUCache(int c) {
    this.capacity = c;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      LNode n = map.get(key);
      remove(n);
      setHead(n);
      return n.value;
    }

    return -1;
  }

  public void remove(LNode n) {
    if (n.pre != null) {
      n.pre.next = n.next;
    } else {
      head = n.next;
    }

    if (n.next != null) {
      n.next.pre = n.pre;
    } else {
      end = n.pre;
    }

  }

  public void setHead(LNode n) {
    n.next = head;
    n.pre = null;

    if (head != null)
      head.pre = n;

    head = n;

    if (end == null)
      end = head;
  }

  public void set(int key, int value) {
    if (map.containsKey(key)) {
      LNode old = map.get(key);
      old.value = value;
      remove(old);
      setHead(old);
    } else {
      LNode created = new LNode(key, value);
      if (map.size() >= capacity) {
        map.remove(end.key);
        remove(end);
        setHead(created);

      } else {
        setHead(created);
      }

      map.put(key, created);
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Head:"+head);
    sb.append("end:"+end);
    return sb.toString();
  }
}
