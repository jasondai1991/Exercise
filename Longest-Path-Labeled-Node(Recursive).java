import java.util.*;
public class testing {
	public static int findDepth(int[] v, int[] E){
		int max = 0;
		Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer,ArrayList<Integer>>();
		//construct the edges
		for(int i=0;i<E.length;i=i+2){
			int x = E[i]-1;
			int y = E[i+1]-1;
			if(!adj.containsKey(x)){
				adj.put(x, new ArrayList<Integer>());
			}
			adj.get(x).add(y);
			if(!adj.containsKey(y)){
				adj.put(y, new ArrayList<Integer>());
			}
			adj.get(y).add(x);
		}
		for(int i=0;i<v.length;i++){
			HashSet<Integer> visited = new HashSet<Integer>();
			visited.add(i);
			int cur = getMax(i,v,adj,visited);
			if(cur>max){
				max = cur;
			}			
		}
		return max;
	}
	
	public static int getMax(int i,int[]v,Map<Integer,ArrayList<Integer>> adj,HashSet<Integer> visited){
		int max = 0;
		if(adj.containsKey(i)){
			ArrayList<Integer> neighbors = adj.get(i);
			
			for(int m=0;m<neighbors.size();m++){
				int cur = neighbors.get(m);
				if(!visited.contains(cur)){
					if(v[cur]==v[i]){
						visited.add(cur);
						int n = getMax(cur,v,adj,visited)+1;
						if(n>max){max = n;}
					}
				}
			}
		}
		return max;		
	}
	
	public static void main(String[] args){
		int[] x = {1,1,1,2,2,1,1,1};
		int[] y = {1,2,1,3,2,4,2,5,3,6,6,7,3,8};
		int max = findDepth(x,y);
		System.out.println(max);
	}
}