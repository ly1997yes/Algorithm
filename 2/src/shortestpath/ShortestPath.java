/*5．	Shortest path in multistage graphs. Find the shortest path from 0 to 15 for the following graph.
	A multistage graph is a graph (1) G=(V,E) with V partitioned into K >= 2 disjoint subsets such that if (a,b) is in E, then a is in Vi , and b is in Vi+1 for some subsets in the partition; and (2) | V1 | = | VK | = 1.
 
 */
package shortestpath;

import java.util.LinkedList;

public class ShortestPath {
	PioneerNodes [] graph;
	int []len;//记录最短路径
	int []path;//记录最短路径的前驱节点
	ShortestPath(int n,int [][] arr){
		//初始化 len[];
		len = new int [n+1];
		for(int i =0;i<len.length;i++){
			len[i]= Integer.MAX_VALUE;
		}
		len[0] = 0;//0 到0 节点的距离是0
		
		//初始化 path[];
		path = new int [n+1];
		path[0] = 0;
	
		//初始化 graph;
		this.graph = new PioneerNodes[n+1];// 0 内部元素没有用
		for(int i= 0;i<arr.length;i++){
			if(this.graph[(arr[i][0])] == null )
				this.graph[(arr[i][0])] = new PioneerNodes();
			(this.graph[(arr[i][0])]).pioneernodes.add( new Node(arr[i][1],arr[i][2]) );
			
		}
		this.graph[0] = new PioneerNodes();
		this.graph[0].pioneernodes.add( new Node(0,0));// 0 到0 的路径长度为0 前驱为0;
		
		
//		for(int i = 0;i<graph.length;i++){//打印
//			System.out.println("Node:" + i + "" + graph[i].toString() );
//		}
		
		Calc ();
	}
	
	private void Calc (){
		int tempsum = 0;
		for(int i = 1;i < graph.length ;i++){
			for(Node node:graph[i].pioneernodes){
				tempsum = len[node.id] + node.cost;
				if(len[i] > tempsum){
					len[i] = tempsum;
					path[i] = node.id;
				}
			}
		}
	}
	public void Print(int n){
		Printlen(n);
		System.out.println();
		Printpath(n);
	}
	public void Print(){
		Print(this.graph.length-1);
	}
	public void Printpath(int n){
		
		if(n!= 0){
			Printpath(path[n]);
			System.out.print("-----> " + n);
		}
		else{
			System.out.print("0----");
		}
	}
	public void Printpath(){
		Printpath(this.graph.length-1);
	}
	public void Printlen(int n){
		if(n!=0){
			Printlen(path[n]);
			System.out.print("       " + len[n]);	
		}
	}
	public void Printlen(){
		Printlen(this.graph.length-1);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr = {
				{1,5,0},
				{2,3,0},
				{3,1,1},
				{4,3,1},{4,8,2},
				{5,6,1},{5,7,2},
				{6,6,2},
				{7,6,3},{7,3,4},
				{8,8,3},{8,5,4},{8,3,5},{8,8,6},
				{9,3,5},{9,4,6},
				{10,2,7},
				{11,2,7},{11,1,8},{11,3,9},
				{12,2,8},{12,3,9},
				{13,3,10},{13,5,11},{13,6,12},
				{14,5,10},{14,2,11},{14,6,12},
				{15,4,13},{15,3,14}};
		ShortestPath sp = new ShortestPath(15,arr);
		sp.Print(15);
	}
	

}
class Node{
	int cost;
	int id;
	
	Node(int cost,int id){
		this.id = id;
		this.cost = cost;
	}
}
class PioneerNodes{
	LinkedList<Node> pioneernodes= new LinkedList<Node>();
	public String toString(){
		String pns = "" ;
		for(Node node: pioneernodes){
			pns +=  "---->"+ node.cost + "  "+ (node.id) + "   ";
		}
		return pns;
	}
	
}