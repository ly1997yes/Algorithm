/*3．	Longest Common Substring. The following are some instances.
	a)	X: xzyzzyx   Y: zxyyzxz
	b)	X: MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCALLAAQANKESSSESFISRLLAIVAD               
		Y: MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG

 * 
 * */
package lcsubstring;

public class LCSubString {
	private LCS lcs;
	private StringBuffer lcSub = new StringBuffer(""); ;
	LCSubString(String X,String Y){//时间复杂度 可以更好
		lcs = new LCS(X,Y);
		for(int i = lcs.x.length-1; i>0;i--){
			for (int j = lcs.y.length-1;j>0;j-- ){
				int m=i,n=j;
				StringBuffer temp = new StringBuffer();
				while(lcs.b[m][n] == 2 && m>0&&n>0){//倒序查找
					temp.insert(0, lcs.x[m]);//从头插入
					m--;	n--;
				}
				//System.out.println(temp); //可以打印所有的公共字串
				if(temp.length() > lcSub.length()){
					lcSub = temp;
				}
			}
		}
//		for(int i = 1; i<lcs.x.length;i++){
//			System.out.println();
//			for (int j = 1; j<lcs.y.length;j++ ){
//				System.out.print(lcs.b[i][j]+"  ");
//			}
//		}
	}
	public static void main(String[] args) {
		String X = "abcbdab";//abcbdab
		String Y = "bdcaba";//bdcaba
		
		LCSubString lcs =  new LCSubString(X,Y);
		System.out.println("LCSbustring:" +""+ lcs.lcSub);

	}

}

class LCS {
	 char [] x;//串X
	 char [] y;//串Y
	private StringBuffer z = new StringBuffer();//记录公共子序列
	private int [][] c;//记录X和Y的公共子序列 的长度
	short [][]b;//记录方向 包访问权限
	public StringBuffer getLCS(){
		return z;
	}
	LCS(String X,String Y){
		this.x = ("\0"+X).toCharArray();
		this.y = ("\0"+Y).toCharArray();
		this.c = new int [this.x.length][this.y.length];
		this.b = new short [this.x.length][this.y.length];
		
		lcsLength();
		for(int i = this.x.length-1,j = this.y.length-1;i>0&&j>0;){//求字串
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
	public int lcsLength() {
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
					b[i][j] = 2;// 对应 左上
				}else if(c[i-1][j]>=c[i][j-1]){
					c[i][j]=c[i-1][j];
					b[i][j] = 1;//对应 上
				}else{
					c[i][j]=c[i][j-1];
					b[i][j] = 0;//对应 左
				}
			}
		}
		return c[x.length-1][y.length-1];
	}
}
