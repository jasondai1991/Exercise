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
			int cur = getMax(i,v,adj);
			if(cur>max){
				max = cur;
			}			
		}
		return max;
	}
	
	public static int getMax(int i,int[]v,Map<Integer,ArrayList<Integer>> adj){
		int max = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		q.add(i);
		visited.add(i);
		int[] result = new int[v.length];
		while(q.size()!=0){
			int cur = q.poll();
			ArrayList<Integer> neighbors = adj.get(cur);
			for(int m=0;m<neighbors.size();m++){
				int ca = neighbors.get(m);
				if(!visited.contains(ca) && v[ca]==v[cur]){
					q.add(ca);
					visited.add(ca);
					result[ca]= result[cur]+1;
				}				
			}			
		}
		for(int n=0;n<result.length;n++){
			if(result[n]>max){
				max = result[n];
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