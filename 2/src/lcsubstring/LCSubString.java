/*3��	Longest Common Substring. The following are some instances.
	a)	X: xzyzzyx   Y: zxyyzxz
	b)	X: MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCALLAAQANKESSSESFISRLLAIVAD               
		Y: MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG

 * 
 * */
package lcsubstring;

public class LCSubString {
	private LCS lcs;
	private StringBuffer lcSub = new StringBuffer(""); ;
	LCSubString(String X,String Y){//ʱ�临�Ӷ� ���Ը���
		lcs = new LCS(X,Y);
		for(int i = lcs.x.length-1; i>0;i--){
			for (int j = lcs.y.length-1;j>0;j-- ){
				int m=i,n=j;
				StringBuffer temp = new StringBuffer();
				while(lcs.b[m][n] == 2 && m>0&&n>0){//�������
					temp.insert(0, lcs.x[m]);//��ͷ����
					m--;	n--;
				}
				//System.out.println(temp); //���Դ�ӡ���еĹ����ִ�
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
	 char [] x;//��X
	 char [] y;//��Y
	private StringBuffer z = new StringBuffer();//��¼����������
	private int [][] c;//��¼X��Y�Ĺ��������� �ĳ���
	short [][]b;//��¼���� ������Ȩ��
	public StringBuffer getLCS(){
		return z;
	}
	LCS(String X,String Y){
		this.x = ("\0"+X).toCharArray();
		this.y = ("\0"+Y).toCharArray();
		this.c = new int [this.x.length][this.y.length];
		this.b = new short [this.x.length][this.y.length];
		
		lcsLength();
		for(int i = this.x.length-1,j = this.y.length-1;i>0&&j>0;){//���ִ�
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
					b[i][j] = 2;// ��Ӧ ����
				}else if(c[i-1][j]>=c[i][j-1]){
					c[i][j]=c[i-1][j];
					b[i][j] = 1;//��Ӧ ��
				}else{
					c[i][j]=c[i][j-1];
					b[i][j] = 0;//��Ӧ ��
				}
			}
		}
		return c[x.length-1][y.length-1];
	}
}
