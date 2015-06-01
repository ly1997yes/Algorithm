/**
 * 2��	Longest Common Subsequence (LCS). The following are some instances.
		a)	X: xzyzzyx   Y: zxyyzxz
		b)	X:MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCALLAAQANKESSSESFISRLLAIVAD               
		Y:MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG

 */
package lcs;

public class LCS {
	private char [] x;//��X
	private char [] y;//��Y
	private StringBuffer z = new StringBuffer();//��¼����������
	private int [][] c;//��¼X��Y�Ĺ��������� �ĳ���
	public StringBuffer getLCS(){
		return z;
	}
	LCS(String X,String Y){//ʱ�临�Ӷ�    O(m*n)
		this.x = ("\0"+X).toCharArray();
		this.y = ("\0"+Y).toCharArray();
		this.c = new int [this.x.length][this.y.length];
		lcsLength();
		for(int i = this.x.length-1,j = this.y.length-1;i>0&&j>0;){//��������
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
	public int lcsLength() {//ʱ�临�Ӷ� m*n
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
		String X ="bdcaba";//Ϊ����ⷽ��ת������ַ�������0λ��Ԫ��Ϊ�ա�<"bdcaba","abcbdab">
		String Y ="abcbdab";
		LCS lcs = new LCS(X,Y);
		System.out.println(lcs.getLCS());
	}

}
