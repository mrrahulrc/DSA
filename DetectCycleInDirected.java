import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class DetectCycleInDirected{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Integer> adj[] = new ArrayList[5];
		for(int i=0; i < adj.length; i++) adj[i] = new ArrayList<Integer>();
		adj[0].add(1);
		adj[1].add(2);
		adj[2].add(3);
		adj[3].add(4);
		// adj[4].add(0);

		boolean []vis = new boolean[adj.length];
		boolean []dfsVis = new boolean[adj.length];

		boolean flag = false;
		for(int i=0; i<adj.length; i++){
			if(isCyclicInDirected(i, vis, dfsVis, adj)){
				flag = true;
				break;
			}
		}

		System.out.println(flag ? "Cycle exist" : "Cycle does not exist");

	}
	public static boolean isCyclicInDirected(int node, boolean[] vis, boolean[] dfsVis, List<Integer> adj[]){

		vis[node] = true;
		dfsVis[node] = true;

		for(int it : adj[node]){
			if( vis[it] == false ){
				if(isCyclicInDirected(it, vis, dfsVis, adj)){
					return true;
				}
			}
			else if( dfsVis[it] == true ){
				return true;
			}
		}

		dfsVis[node] = false;
		return false;

	}
}