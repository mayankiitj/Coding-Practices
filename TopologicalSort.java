package QnA;

import java.awt.Adjustable;
import java.util.Stack;

public class TopologicalSort{
	static Stack<Integer> sort = new Stack<Integer>();
	static Graph graph = null;
	
	public static void topoSort(boolean visited[],int i){
		if(visited[i])
			return ;
		visited[i] = true;
		for(int j =0;j<graph.adjacent[i].size();j++){
			if(!visited[graph.adjacent[i].get(j)]){
				topoSort(visited,j);
			}
		}
		sort.push(i);
	}
	
	public static void main(String args[]){
		int nodes =6;
		graph = new Graph(nodes);
		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		boolean visited[]= new boolean[nodes];
		for(int i=0;i<nodes;i++){
			if(!visited[i]){
				topoSort(visited,i);
			}
		}
		while(!sort.isEmpty()){
			System.out.println(sort.pop());
		}
	}
}