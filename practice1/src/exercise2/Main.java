/*
 * Implement priority queue.
 */
package exercise2;

import java.util.Random;

//import java.util*; 
public class Main {

	public static void main(String args[]){
		int arr[] = new int[9];
		for (int i = 0;i < arr.length; i++){
			arr[i] = (Math.abs(new Random().nextInt()))%arr.length;//***********
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n");
		/* test heap 
		try{
			Heap prique = new Heap(arr);
			prique.buildMaxHeap();
			prique.printHeap();
		}catch (Exception e){	
			e.printStackTrace(System.out);
		}
		*/
		try{
			PriorityQueue prique = new PriorityQueue(arr);
			prique.buildMaxHeap();
			prique.printHeap();
			System.out.print("\n");
			//System.out.print("\nprique.extractMax(): " + prique.extractMax()+ "\n");//Yes;
			//System.out.print("\nprique.maxmum():" + prique.maxmum() + "\n");//Yes;
			//prique.heapIncrease(4, 9);//Yes
			//prique.insert(9);//Yes
			prique.printHeap(); 
			
		}catch (Exception e){	
			e.printStackTrace(System.out);
		}
		
	}
}
