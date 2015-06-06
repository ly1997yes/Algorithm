/*2го	Solve the 8-Queen problem using back-tracking algorithm. 
 * 
 * */
package practice4;

public class NQueen {
	int []X;
	int k;
	NQueen(int n){
		this.X =new int [n+1];
		this.k = 1 ;
		this.X[1] = 0;
		while(k > 0){
			X[k] ++;
			while(X[k] < n+1 && !isWellPalced(k)){
				X[k] ++;
			}
			if(X[k]< n +1){
				if(k == n){
					print(X);
				}else{
					k++;
					X[k] = 0;
				}
			}else{
				k--;
			}
		}
	}
	private boolean isWellPalced(int k ){
		int i = 1;
		while(i < k ){
			if(X[i] == X[k] || Math.abs(X[i] - X[k]) == Math.abs(i - k)){
				return false;
			}
			i++;
		}
		return true;
	}
	private void print(int[] X ){
		for (int i=1 ; i < X.length;i++){
			System.out.print(" " + X[i]);
		}
		System.out.println();
	}
	public static void main(String [] args){
		new NQueen(8); 
	}
	
}
