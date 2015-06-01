/**
 * 1．Matrix-chain product. The following are some instances.
		a)	<3, 5, 2, 1,10>
		b)	<2, 7, 3, 6, 10>
		c)	<10, 3, 15, 12, 7, 2>
		d)	<7, 2, 4, 15, 20, 5>
 * 
 */
package matrixchain;

public class MatrixChain {
	private int [] p; //从0到n
	private int [][] m;
	private int [][] s;
	private int n ;
	MatrixChain(int [] p ){
		this.p = p;
		this.n = p.length - 1;
		this.m = new int[n+1][n+1];//为了方便理解 这里就直接不用所有的下表为0的元素
		this.s = new int[n+1][n+1];
		for(int i= 1;i < this.n + 1;i++){//为了方便理解 这里就直接不用所有的下表为0的元素
			m[i][i] = 0;
			System.out.println("m[" + i + "," + i + "]:" + m[i][i]);
		}
		for(int j = 1; j <= n-1 ;j++){
			for(int i = 1;i <= n - j;i++){
				m[i][i+j] = Integer.MAX_VALUE;
				System.out.println("m[" + i + "," + (i+j) + "]:" + m[i][i+j]);
			}
		}
		
	}
	public void MatriChainOrder(){
		for(int j=1 ; j <= n-1 ;j++){
			for(int i=1 ;i <= n-j ;i++){
				for(int k = i; k<i+j ;k++){
					if(m[i][i+j]> m[i][k] + m[k+1][i+j] + p[i-1]*p[k]*p[i+j]){
						m[i][i+j] = m[i][k] + m[k+1][i+j] + p[i-1]*p[k]*p[i+j];
						s[i][i+j] = k;
					}
				}
			System.out.println("m["+ i +"," + (i+j) + "] = " + m[i][i+j] +";  s["+ i +"," + (i+j) + "] = " + s[i][i+j]);
			}
		}
		
	}
	public void printOptimalParents(int i,int j){
		if (i == j){
			System.out.print("(" + i);
		}
		else{
			System.out.print("(");
			printOptimalParents(i,s[i][j]);
			printOptimalParents(s[i][j]+1,j);
			System.out.print(")");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] p = {3, 5, 2, 1,10};
		//int [] p = {30, 35, 15, 5,10,20,25};
		//int [] p =  {10, 3, 15, 12, 7, 2};
		MatrixChain mc =new MatrixChain(p);
		mc.MatriChainOrder();
		mc.printOptimalParents(1, p.length-1);
	}

}
