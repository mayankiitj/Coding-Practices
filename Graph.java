package QnA;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	int vertex;
	List<Integer> adjacent[];

	Graph(int nodes){
		this.vertex = nodes;
			adjacent= new ArrayList[nodes];
			for(int i=0;i<nodes;i++)
				adjacent[i] = new ArrayList<Integer>();
	}
	
	void addEdge(int u,int w){
		adjacent[u].add(w);
	}
}
