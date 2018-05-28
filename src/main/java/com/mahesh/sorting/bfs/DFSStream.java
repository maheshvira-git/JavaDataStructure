/**
 * 
 */
package com.mahesh.sorting.bfs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author mahesh.vira
 *
 */

class NodeTree {

  NodeTree left;
  NodeTree right;
  int data;
  boolean visited = false;
  int hd = 0;
  boolean isLeft = false;

  NodeTree(int data, NodeTree left, NodeTree right) {
    this.data = data;
    this.left = left;
    if (this.left != null) {
      this.left.isLeft = true;
    }
    this.right = right;
  }

  @Override
  public String toString() {
    return "[" + data + ":" + hd + "]";
  }

  public void setHd(int hd) {
    this.hd = hd;
  }

  public int getHd() {
    return hd;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public boolean isVisited() {
    return visited;
  }

  public boolean isNotVisited() {
    return !visited;
  }

  public List<NodeTree> getChildren() {
    return Stream.of(left, right).filter(Objects::nonNull).collect(Collectors.toList());
  }

  // DFS
  public List<NodeTree> searchByDepth() {
    List<NodeTree> unvisitedNodes = new LinkedList<>();
    List<NodeTree> visitedNodes = new LinkedList<>();
    unvisitedNodes.add(this);
    while (!unvisitedNodes.isEmpty()) {
      NodeTree currNode = unvisitedNodes.remove(0);
      List<NodeTree> newNodes = currNode.getChildren().stream().filter(NodeTree::isNotVisited)
          .collect(Collectors.toList());
      unvisitedNodes.addAll(0, newNodes);
      currNode.setVisited(true);
      visitedNodes.add(currNode);
    }
    return visitedNodes;
  }

  public List<NodeTree> searchByBreadth() {
    List<NodeTree> visitedNodes = new LinkedList<>();
    List<NodeTree> unvisitedNodes = Arrays.asList(this);
    while (!unvisitedNodes.isEmpty()) {
      List<NodeTree> newNodes = unvisitedNodes.stream().map(NodeTree::getChildren)
          .flatMap(List::stream).filter(NodeTree::isNotVisited).collect(Collectors.toList());
      unvisitedNodes.stream().forEach(v -> v.setVisited(true));
      newNodes.stream().filter(n -> n.isLeft).forEach(v -> v.setHd(this.hd - 1));
      newNodes.stream().filter(n -> !n.isLeft).forEach(v -> v.setHd(this.hd + 1));
      visitedNodes.addAll(unvisitedNodes);
      unvisitedNodes = newNodes;
    }
    return visitedNodes;
  }

  public void searchByBreadth(Map<Integer, Integer> sumMap) {

    List<NodeTree> unvisitedNodes = Arrays.asList(this);

    sumMap.put(this.getHd(), this.data);

    while (!unvisitedNodes.isEmpty()) {

      List<NodeTree> children = null;

      for (Iterator<NodeTree> iterator = unvisitedNodes.iterator(); iterator.hasNext();) {

        NodeTree parent = iterator.next();

        children = parent.getChildren();

        for (NodeTree child : children) {

          if (child.isLeft) {
            child.setHd(parent.hd - 1);
          } else {
            child.setHd(parent.hd + 1);
          }

          Integer hdValue = sumMap.get(child.getHd());
          if (hdValue == null) {
            hdValue = new Integer(child.data);
          } else {
            hdValue += child.data;
          }
          sumMap.put(child.getHd(), hdValue);

        }
      }

      unvisitedNodes = children;

    }
  }

  public void searchByBreadthUsingQueue(Map<Integer, Integer> sumMap) {

    Queue<NodeTree> queue = new LinkedList<>();
    queue.add(this);

    while (!queue.isEmpty()) {

      NodeTree tempNode = queue.poll();

      if (tempNode.left != null) {
        tempNode.left.setHd(tempNode.hd - 1);
        queue.add(tempNode.left);
      }

      if (tempNode.right != null) {
        tempNode.right.setHd(tempNode.hd + 1);
        queue.add(tempNode.right);
      }

      Integer hdValue = sumMap.get(tempNode.getHd());
      if (hdValue == null) {
        hdValue = tempNode.data;
      } else {
        hdValue += tempNode.data;
      }
      sumMap.put(tempNode.getHd(), hdValue);

    }

  }
  
  public int countMaxWidth(){
    
    int count  = 0;
    
    Queue<NodeTree> queue = new LinkedList<>();
    queue.add(this);

    while (!queue.isEmpty()) {
      
      if(queue.size()>count){
        count=queue.size();
      }
      
      NodeTree tempNode = queue.poll();
      List<NodeTree> children = tempNode.getChildren();
      queue.addAll(children);
    }
    
    return count;
    
  }

}


public class DFSStream {

  /**
   * @param args
   */
  public static void main(String[] args) {

    // NodeTree acbd = new NodeTree(8, null, null);
    // NodeTree acbf = new NodeTree(9, null, null);
    //
    // NodeTree acb = new NodeTree(6, acbd, acbf);
    // NodeTree ace = new NodeTree(7, null, null);
    //
    // NodeTree d = new NodeTree(4, null, null);
    // NodeTree e = new NodeTree(5, null, null);
    //
    //
    // NodeTree ab = new NodeTree(2, d, e);
    // NodeTree ac = new NodeTree(3, acb, ace);
    //
    // NodeTree a = new NodeTree(1, ab, ac);

    NodeTree t4 = new NodeTree(4, null, null);
    NodeTree t5 = new NodeTree(5, null, null);
    NodeTree t7 = new NodeTree(7, null, null);
    NodeTree t6 = new NodeTree(6, null, null);
    NodeTree t2 = new NodeTree(2, t4, t5);
    NodeTree t3 = new NodeTree(3, t7, t6);
    NodeTree t1 = new NodeTree(1, t2, t3);

    Map<Integer, Integer> sumMap = new TreeMap<>();
    //t1.searchByBreadth(sumMap);
    
    System.out.println();
    
    t1.searchByBreadthUsingQueue(sumMap);

    sumMap.forEach((x, y) -> System.out.println(x + ":" + y));

    System.out.println(t1.countMaxWidth());
  }

}
