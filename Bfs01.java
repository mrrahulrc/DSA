import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Deque;
import java.util.Arrays;
public class Bfs01{

	public static void main(String[] args) {
		
		@SuppressWarnings("unchecked")
		List<Node> adj[] = new ArrayList[5];
		for(int i=0; i < adj.length; i++) adj[i] = new ArrayList<Node>();
		adj[0].add(new Node(1,0));
		adj[1].add(new Node(2,0));
		adj[1].add(new Node(4,1));
		adj[0].add(new Node(3,1));
		adj[0].add(new Node(2,1));
		adj[4].add(new Node(3,0));

		bfsDeque(adj);
	}

	public static void bfsDeque(List<Node> adj[]){
		int len = adj.length;
		int[] dis = new int[len];
		Deque<Node> deque = new LinkedList<>();
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[0] = 0;
		deque.addFirst(new Node(0,0));


		while(deque.size() > 0){
			Node curNode = deque.removeFirst();
			int src = curNode.node;
			for(Node it : adj[src]){
				int curdistance = it.dis;
				int destination = it.node; 
				if( dis[src] + curdistance < dis[destination] ){
					dis[destination] = dis[src] + curdistance;
					Node newNode = new Node(destination,dis[src] + curdistance);
					if(curdistance == 1){
						deque.addLast(newNode);
					}
					else{
						deque.addFirst(newNode);
					}
				}
			}
		}
		System.out.println("distance array : ");
		Arrays.stream(dis).forEach(element -> System.out.print(element+" "));

	}


	public static class Node{
		int node;
		int dis;
		public Node(int node, int dis){
			this.node = node;
			this.dis = dis;
		}
	}

}