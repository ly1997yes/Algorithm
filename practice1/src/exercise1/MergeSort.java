/**
 * Describe a жи(n lg n)-time algorithm that, given a set S of n integers and another integer x,
 * determines whether or not there exist two elements in S whose sum is exactly x.
 */
package exercise1;

import java.util.Random;

public class MergeSort {

	public static void Merge(int arr[],int p,int q,int r){
		int n1 = q-p+1;//p..q
		int n2 = r-q;//q+1..r
		int []Larr = new int[n1+1];
		int []Rarr = new int[n2+1];

		for(int i=0;i<n1;i++)
			Larr[i] = arr[p+i];
		Larr[n1] = Integer.MAX_VALUE;//*****************

		for(int i=0;i<n2;i++)
			Rarr[i] = arr[q+i+1];
		Rarr[n2] = Integer.MAX_VALUE;//****************

		int i=0,j=0;
		for(int k = p;k <= r;k++){
			if(Larr[i]<= Rarr[j])
				arr[k] = Larr[i++];
			else 
				arr[k] = Rarr[j++];
		}
	}
	public static void Merge_sort(int arr[],int p,int r){
		if (p<r){
			int q = (p+r)/2;
			Merge_sort(arr,p,q);
			Merge_sort(arr,q+1,r);
			Merge(arr,p,q,r);
		}

	}
	public static int binarySearch(int arr[],int tar,int p,int r){
		while(p<=r){
			int q=(p+r)/2;
			if(arr[q] < tar)
				p=q+1;
			else if(arr[q] > tar)
				r=q-1;
			else 
				return q;
		}
		return -1;
	}
	public static Boolean findX(int arr[],int x,int length){
		for(int i=0;i<length;i++){
			if(binarySearch(arr,x-arr[i],i+1,length-1) > -1)
				return true;
		}
		return false;
	}
	public  static void printArr(int [] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"	");
		System.out.println();
	}
	public static void createArr(int []arr){
		for(int i = 0;i< arr.length;i++){
			arr[i] = Math.abs(new Random().nextInt()%arr.length);
		}
	}
	public static void main(String args[]){
		int arr[] = new int[10];
		createArr(arr);
		printArr(arr);
		Merge_sort(arr,0,arr.length-1);
		printArr(arr);

		int x = 7;
		System.out.println(findX(arr,x,arr.length) );
	}

}
