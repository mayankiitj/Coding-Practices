package QnA;

import java.util.HashMap;

public class Trie {
	public static void main(String args[]){
		TrieNode td = new TrieNode('0',new HashMap<>(),false);
		insert("human",td);
		insert("hurt",td);
		insert("humming",td);
		
		print(td);
	}
	
	public static void insert(String val,TrieNode td){
		TrieNode curr = td;
		for(int i=0;i<val.length();i++){
			if(curr.getChildren().get(val.charAt(i))== null){
				TrieNode temp = new TrieNode(val.charAt(i),new HashMap<Character,TrieNode>(),false);
				curr.getChildren().put(val.charAt(i),temp);
				curr = temp;
			}
			else{
				curr = curr.getChildren().get(val.charAt(i));
			}
		}
		curr.setLeaf(true);
	}
	
	public static void print(TrieNode t){
		if(t == null)
			return;
		System.out.print(t.getCh()+" ");
		for(char c:t.getChildren().keySet()){
			print(t.getChildren().get(c));
		}
		System.out.print("\n");
	}
}
