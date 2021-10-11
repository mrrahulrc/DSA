import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;
public class Dijkstra{
	public static void main(String[] args) {
		
		@SuppressWarnings("unchecked")
		List<Node> adj[] = new ArrayList[5];
		for(int i=0; i < adj.length; i++) adj[i] = new ArrayList<Node>();
		adj[0].add(new Node(1,7));
		adj[0].add(new Node(2,1));
		adj[2].add(new Node(1,2));
		adj[0].add(new Node(3,3));
		adj[3].add(new Node(4,2));
		adj[1].add(new Node(4,1));

		findshortestpath(adj, adj.length);

	}

	private static void findshortestpath(List<Node> adj[], int len){
		// to keep track distance
		int[] dis = new int[len];
		Arrays.fill(dis, Integer.MAX_VALUE);

		// to get minimum distance value in logn time
		PriorityQueue<Node> minHeap = new PriorityQueue<>((Node first, Node sec) -> first.dis - sec.dis);
		
		// to keep track weather it's visited or not yet in process
		boolean vis[] = new boolean[len];

		// initialization
		dis[0] = 0;
		minHeap.add(new Node(0,0));

		while( minHeap.size() > 0 ){

			Node curNode = minHeap.remove();
			int src = curNode.getSrc();
			int distanceTillNow = curNode.getDis();
			if( vis[src] ) continue;			
			dis[src] = distanceTillNow;
			vis[src] = true;
			
			for(Node it : adj[src]){ 
				if( !vis[it.getSrc()] && distanceTillNow + it.getDis() < dis[it.getSrc()] ){
					minHeap.add(new Node(it.getSrc(), distanceTillNow + it.getDis()));
					dis[it.getSrc()] = distanceTillNow + it.getDis();
				}
			}

		}

		Arrays.stream(dis).forEach(element -> System.out.print(element+" "));


	}

	public static class Node{
		int src ;
		int dis;
		public Node(int src, int dis){
			this.src = src;
			this.dis = dis;
		}
		public int getSrc(){
			return this.src;
		}
		public int getDis(){
			return this.dis;
		}
	}

}