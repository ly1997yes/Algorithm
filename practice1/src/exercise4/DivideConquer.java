/**
 * 4．	Give a divide and conquer algorithm for the following problem:
 *  	you are given two sorted lists of size m and n, and are allowed unit time access to the ith element of each list.
 *  	Give an O(lg m + lgn) time algorithm for computing the kth largest element in the union of the two lists. 
 *  	(For simplicity, you can assume that the elements of the two lists are distinct).
 */
package exercise4;

import java.util.Random;

/**
 * @author Tao
 *
 */
public class DivideConquer {
	
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
	public static void insertSort(int arry[]){
		int temp,i,j;
	    for(i = 1;i<arry.length;i++){
	        temp = arry[i];
	        
			for(j=i-1;j>-1;j--)
	                    if(temp < arry[j]) arry[j+1] = arry[j];   
	                    else break;//省去无为的比较		
			arry[j+1] = temp;
	    }
	}
	
	public static void createSortedArr(int []arr){
		createArr(arr);
		printArr(arr);
		insertSort(arr);
		printArr(arr);
	}
	public static int FindTheKth(int a[],int b[],int aLeft, int aRight, int bLeft, int bRight, int k) {
		int aMid = (aLeft + aRight) / 2, bMid = (bLeft + bRight) / 2;
		if (aLeft > aRight) return b[bLeft+k-1];
		if (bLeft > bRight) return a[aLeft+k-1];
		if (a[aMid] <= b[bMid]) {
			if (k <= (aMid - aLeft) + (bMid - bLeft) + 1) {
				return FindTheKth(a,b,aLeft, aRight, bLeft, bMid-1, k);
			} else {
				return FindTheKth(a,b,aMid+1, aRight, bLeft, bRight, k-(aMid-aLeft)-1);
			}
		} else {
			if (k <= (aMid - aLeft) + (bMid - bLeft) + 1) {
				return FindTheKth(a,b,aLeft, aMid-1, bLeft, bRight, k);
			} else {
				return FindTheKth(a,b,aLeft, aRight, bMid+1, bRight, k-(bMid-bLeft)-1);
			}
		}
	}
	public static void main(String args[]){
		int arrM[] = new int [10];
		int arrN[] = new int [8];
		createSortedArr(arrM);
		createSortedArr(arrN);
		//FindTheKth(arrM,arrN,0,arrM.length-1, 0,arrN.length, key);
		for(int i = 1;i <= arrM.length+arrN.length;i++){
			System.out.print(FindTheKth(arrM,arrN,0,arrM.length-1, 0,arrN.length-1,i) + "	");
		}
		
	}

}
