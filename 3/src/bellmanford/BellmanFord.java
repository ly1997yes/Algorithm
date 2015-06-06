/*3．	Single-source shortest paths. The following is the adjacency matrix, vertex A is the source. 
			A	B	C	D	E
     	A  		-1	3
	 	B           3	2	2
		C       
	 	D       1   5
	 	E				-3

 * */

package bellmanford;

public class BellmanFord {
	private Graph graph;
	private int source ;
	private int []d;
	private int []pi;
	private int w[][];
	BellmanFord(int [][] graph,int source){
		this.graph = new Graph(graph);
		this.source = source;
		this.d = new int [graph.length];
		this.pi  = new int [graph.length];
		
		for(int i =0 ;i<this.d.length;i++){
			if(i != this.source){
				this.d[i] = Integer.MAX_VALUE;
				this.pi[i] = -1;//-1 代表 NIL
			}else{
				this.d[i] = 0;
				this.pi[i] = this.source;
			}
		}
//		for (int i = 0 ; i< this.d.length;i++){
//			System.out.println("d[" + i + "]=" + this.d[i] + "  pi[" + i + "]=" + this.pi[i]);
//		}
//		System.out.println();

		for (int i = 1;i < this.d.length;i++){
			for(int j = 0;j < this.graph.count;j++){
				int u = this.graph.wedges[j][0];
				int v = this.graph.wedges[j][1];
				int wedge = this.graph.wedges[j][2];
				
				
				if( d[u] != Integer.MAX_VALUE && d[u] + wedge < d[v] ){
					d[v] = d[u] + wedge ;
					pi[v] = u; 
				}
			}
		}
		
		for (int i = 0 ; i< this.d.length;i++){
			System.out.println("d[" + i + "]=" + this.d[i] + "  pi[" + i + "]=" + this.pi[i]);
		}
	}

	
	public static void main(String [] args){
		int source = 0;	
		int [][]graph = {
					{0,-1,3,Integer.MAX_VALUE,Integer.MAX_VALUE},
					{Integer.MAX_VALUE,0,3,2,2},
					{Integer.MAX_VALUE,Integer.MAX_VALUE,0,Integer.MAX_VALUE,Integer.MAX_VALUE},
					{Integer.MAX_VALUE,1,5,0,Integer.MAX_VALUE},
					{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-3,0}
			};
			
		BellmanFord bf = new BellmanFord(graph,source);
	}
}
class Graph{
	int count ;
	int [][] wedges ;
	Graph(int [][] graph){
		this.count = countOfWedge(graph);
		this.wedges = new int[count][3];
		
		for(int i = 0,count = 0;i< graph.length;i++){
			for(int j = 0;j< graph[0].length;j++){
				if(graph[i][j] < Integer.MAX_VALUE && i!=j){
					this.wedges[count][0] = i;
					this.wedges[count][1] = j;
					this.wedges[count++][2] = graph[i][j];
				}
			}
		}
//		for(int i =0 ;i < this.wedges.length;i++){//打印所有的边
//			System.out.println( this.wedges[i][0] + " -> " + this.wedges[i][1] + "  cost: "+ this.wedges[i][2]);
//		}
	}
	private int countOfWedge(int [][] graph){
		int count = 0;
		for(int i = 0;i< graph.length;i++){
			for(int j = 0;j< graph[0].length;j++){
				if(graph[i][j] < Integer.MAX_VALUE && i!=j)
					count ++;
			}
		}
		return count;
	}
}
