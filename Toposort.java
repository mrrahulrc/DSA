import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
public class Toposort{
// 			  4
//			  ^
// 			  |
// 			  |
// 			  |	
// 0 ------>  2 <----- 1
// 			  |		
// 			  |		
// 			  |
// 			  *		
// 			  3
	public static void main(String[] args) {
		
		List<Integer> adj[] = new ArrayList[5];
		for(int i=0; i < adj.length; i++) adj[i] = new ArrayList<Integer>();
		adj[0].add(2);
		adj[1].add(2);
		adj[2].add(3);
		adj[2].add(4);

		topoSortViaDfs(adj);
		topoSortViaBfs(adj);
	}

	private static void topoSortViaDfs( List<Integer> adj[] ){
		boolean vis[] = new boolean[adj.length];
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<adj.length; i++){
			if(!vis[i]){
				topoHelper(i, vis, stack, adj);
			}
		}

		System.out.println("topoSortViaDfs");
		while(stack.size() > 0){
			System.out.print(stack.pop()+" ");
			
		}
		System.out.println();
	}

	private static void topoHelper(int node,boolean[] vis,Stack<Integer> stack, List<Integer> adj[] ){

		vis[node] = true;

		for(int it : adj[node]){
			if( !vis[it] ){
				topoHelper(it, vis, stack, adj);
			}
		}
		stack.push(node);
	}


	private static void topoSortViaBfs(List<Integer> adj[]){
		int len = adj.length;
		boolean[] vis = new boolean[len];
		int[] indegree = new int[len];
		for(int i=0; i<len; i++){
			for(int it : adj[i]){
				indegree[it]++;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		for(int i=0; i<len; i++){
			if(indegree[i] == 0){
				queue.add(i);
				vis[i] = true;
			}
		}

		int topo[] = new int[len];
		int start = 0;
		while( queue.size() > 0 ){

			topo[start++] = queue.peek();
			int current_node = queue.remove();

			for(int it : adj[current_node]){
				indegree[it]--;
				if(indegree[it] == 0 && vis[it] == false){
					queue.add(it);
					vis[it] = true;
				}
			}
		}
		System.out.println("topoSortViaBfs");
		for(int ele : topo){
			System.out.print(ele+ " ");
		}
	}

}