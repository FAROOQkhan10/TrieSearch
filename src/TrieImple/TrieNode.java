package TrieImple;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
     Map<Character,TrieNode> children = new HashMap<>();
     boolean isEndOfWord;
     TrieNode(){
         isEndOfWord=false;
     }

     private TrieNode root;

     public TrieNode getNode(){
         return new TrieNode();
     }
}
