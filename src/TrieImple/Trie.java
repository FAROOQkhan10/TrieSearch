package TrieImple;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Trie {
     TrieNode root;
     public Trie(){
         root = new TrieNode().getNode();
     }


     public void insert(String word){
         TrieNode crawler = root;
         for(var c:word.toCharArray()){
            if(crawler.children.containsKey(c)){
                crawler = crawler.children.get(c);
            }
            else{
                crawler.children.put(c,new TrieNode());
                crawler = crawler.children.get(c);
            }
         }
         crawler.isEndOfWord=true;
     }

     public boolean exactSearch(String word){

         TrieNode crawler = root;
         for(var c:word.toCharArray()){
             if(crawler.children.containsKey(c)){
                 crawler=crawler.children.get(c);
             }
             else return false;
         }

         return crawler.isEndOfWord;
     }

     public ArrayList<String> preSearch(String prefix){

         TrieNode crawler = root;
         ArrayList<String> store = new ArrayList<>();
         for(var c:prefix.toCharArray()){
             if(crawler.children.containsKey(c)){
                 crawler=crawler.children.get(c);
             }
             else{
                 System.out.println("Not Found!!");
                 return store;
             }
         }

         CollectWords(crawler,prefix,store);

         return store;

     }

    public ArrayList<String> universalSearch(String subStr){
         ArrayList<String> store = new ArrayList<>();
         ArrayList<String> res = new ArrayList<>();
         TrieNode crawler = root;
         CollectWords(crawler,"",store);

         for(var word : store){
             if(word.contains(subStr)){
                res.add(word);
             }
         }
         return res;
    }

    private void CollectWords(TrieNode crawler, String s, ArrayList<String> store) {
         if(crawler.isEndOfWord) store.add(s);

         for(Map.Entry<Character,TrieNode> entry:crawler.children.entrySet()){
              CollectWords(entry.getValue(),s + entry.getKey(),store);
         }
    }


}
