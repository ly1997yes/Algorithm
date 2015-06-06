/*
 * 4£®	All-pairs shortest paths. The adjacency matrix is as same as that of problem 3.(Use Floyd or Johnson¡¯s algorithm)
 * */
package allpairsshortestpath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
 
public class Floyd {
 
    /**
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        int [][]graph = {
				{0,-1,3,Integer.MAX_VALUE,Integer.MAX_VALUE},
				{Integer.MAX_VALUE,0,3,2,2},
				{Integer.MAX_VALUE,Integer.MAX_VALUE,0,Integer.MAX_VALUE,Integer.MAX_VALUE},
				{Integer.MAX_VALUE,1,5,0,Integer.MAX_VALUE},
				{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-3,0}
		};
        Floyd f = new Floyd();
       int[][] Dis =  f.floyd(graph, graph.length);
        
       
        f.printG(Dis,graph.length);
    }
     
    public void printG(int[][] G,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.println(i+"->"+j+"  "+G[i][j]);
            }
        }
    }
 
     
    public int[][] floyd(int[][] G,int n){
        int[][] Dis= new int[n][n];
        for(int q=0;q<n;q++){
            for(int w=0;w<n;w++){
                Dis[q][w]=G[q][w];
            }
        }
             
        for(int k = 0; k < n; k++){
            for(int i=0; i < n; i++ ){
                for(int j=0; j < n; j++){
                    if( Dis[k][j] != Integer.MAX_VALUE && Dis[i][k]!= Integer.MAX_VALUE && Dis[i][j]>Dis[i][k]+Dis[k][j]){
                        Dis[i][j]=Dis[i][k]+Dis[k][j];
                    }
                }
            }
        }
        return Dis;
    }
}
