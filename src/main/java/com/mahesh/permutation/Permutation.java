package com.mahesh.permutation;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author mahesh.vira
 *
 */
public class Permutation {

  public static void main(String[] args) {
    
    Set<String> setOfPerms = new LinkedHashSet<>();
    
    String str = "noon";
    int n = str.length();
    Permutation permutation = new Permutation();
    permutation.permute(str, 0, n-1,setOfPerms);
    
    setOfPerms.forEach(System.out::println);
    
  }

  private void permute(String str, int s, int e,Set<String> setOfPerms) {

    if(s==e){
      if(isPalindrom(str)){
        setOfPerms.add(str);
      }
    }else{
      for (int i = s; i <= e; i++)
      {
          str = swap(str,s,i);
          permute(str, s+1, e,setOfPerms);
          str = swap(str,s,i);
      }
    }
    
  }

  private String swap(String a, int i, int j) {
    char temp;
    char[] charArray = a.toCharArray();
    temp = charArray[i] ;
    charArray[i] = charArray[j];
    charArray[j] = temp;
    return String.valueOf(charArray);
  }
  
  private boolean isPalindrom(String s){
    return new StringBuilder(s).reverse().toString().equals(s);
  }
}
