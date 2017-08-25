package QnA;

import java.util.HashMap;

public class TrieNode {
	private char ch;
	private HashMap<Character,TrieNode> children;
	boolean isLeaf;
	
	
	public TrieNode() {
	
	}
	public TrieNode(char ch, HashMap<Character, TrieNode> children, boolean isLeaf) {
		this.ch = ch;
		this.children = children;
		this.isLeaf = isLeaf;
	}
	public char getCh() {
		return ch;
	}
	public void setCh(char ch) {
		this.ch = ch;
	}
	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}
	public void setChildren(HashMap<Character, TrieNode> children) {
		this.children = children;
	}
	public boolean isLeaf() {
		return isLeaf;
	}
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	
}
