/*
 * 3．Implement Quicksort and answer the following questions.
 * (1) How many comparisons will Quicksort do on a list of n elements that all have the same value?
 *                                    n*(n-1)/2
 * (2) What are the maximum and minimum number of comparisons will Quicksort do on a list of n elements,
 * 		 give an instance for maximum and minimum case respectively.
 *                               最大： n*(n-1)/2 最小：O(n*lgn)
 */
package exercise3;

import java.util.Random;

public class QuickSort {

	private  static int comparitionCount = 0;
	
	QuickSort(){}
	public static void createSameElementArr(int []arr){
		for(int i = 0;i< arr.length;i++){
			arr[i] = arr.length;//***********************
		}
	}
	public static void createArr(int []arr){
		for(int i = 0;i< arr.length;i++){
			arr[i] = Math.abs(new Random().nextInt()%arr.length);
		}
	}
	public  static void printArr(int [] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"	");
		System.out.println();
	}
	public static int partation(int []arr,int p,int r){
		int key = arr[r];
		int i = p - 1;
		int temp;
		for(int j = p;j < r;j++){
			//comparitionCount++;
			if(arr[j] < key){
				comparitionCount++;
				i++;
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
			comparitionCount++;
		}
		//comparitionCount++;
		temp = arr[i+1];
		arr[i+1] = arr[r];
		arr[r] = temp;
		return i+1;
	}
	public static void quickSort(int []arr,int p,int r){
		if(p<r){
			int q = partation(arr,p,r);
			quickSort(arr,p,q-1);
			quickSort(arr,q+1,r);
		}
	}
	public static void main(String[] args) {
		//int arr[] = {1,2,3,4,4,7,8,10,11,9,5};//minimum comparison of quick sort
		int arr[] = new int[10];//*********************
		createArr(arr);
		//createSameElementArr(arr);
		printArr(arr);
		
		quickSort(arr,0,arr.length-1);
		printArr(arr);
		System.out.println("comparition count :" + comparitionCount);
	}
}
