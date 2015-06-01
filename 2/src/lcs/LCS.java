/**
 * 2．	Longest Common Subsequence (LCS). The following are some instances.
		a)	X: xzyzzyx   Y: zxyyzxz
		b)	X:MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCALLAAQANKESSSESFISRLLAIVAD               
		Y:MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG

 */
package lcs;

public class LCS {
	private char [] x;//串X
	private char [] y;//串Y
	private StringBuffer z = new StringBuffer();//记录公共子序列
	private int [][] c;//记录X和Y的公共子序列 的长度
	public StringBuffer getLCS(){
		return z;
	}
	LCS(String X,String Y){//时间复杂度    O(m*n)
		this.x = ("\0"+X).toCharArray();
		this.y = ("\0"+Y).toCharArray();
		this.c = new int [this.x.length][this.y.length];
		lcsLength();
		for(int i = this.x.length-1,j = this.y.length-1;i>0&&j>0;){//求字序列
			if(c[i][j] == c[i-1][j-1]+1){
				this.z.insert(0, x[i]);
				i--;	j--;
			}else if(c[i][j]==c[i-1][j]){
				i--;
			}else{
				j--;
			}
		}
	} 
	public int lcsLength() {//时间复杂度 m*n
		for(int i=1;i<x.length;i++){
			c[i][0] = 0;
		}
		for(int i=1;i<y.length;i++){
			c[0][i] = 0;
		}
		for(int i=1; i<x.length ;i++){
			for(int j=1; j<y.length ;j++){
				if(x[i]==y[j]){
					c[i][j] = c[i-1][j-1]+1;
				}else if(c[i-1][j]>=c[i][j-1]){
					c[i][j]=c[i-1][j];
				}else{
					c[i][j]=c[i][j-1];
				}
			}
		}
		return c[x.length-1][y.length-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String X ="bdcaba";//为了理解方便转换后的字符串数组0位的元素为空。<"bdcaba","abcbdab">
		String Y ="abcbdab";
		LCS lcs = new LCS(X,Y);
		System.out.println(lcs.getLCS());
	}

}
