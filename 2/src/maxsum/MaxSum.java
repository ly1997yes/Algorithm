/*4��Max Sum. The following is an instance.
		a)	(-2,11,-4,13,-5,-2)

 * */
package maxsum;

public class MaxSum {//�����������   ����ֻ�����̴����Ǹ� 
	public Integer i;//����ʱ��Ԫ����ʼλ��  ��1����
	public Integer j;//����ʱ��Ԫ�ؽ���λ��  ��1����
	public int sum = 0;//����
	public void BruteForce(int [] a){//Brute-force �ⷨ
		for(int i=0;i<a.length;i++){
			int temp = 0;
			for(int j=i;j<a.length;j++){
				temp+=a[j];
				if(temp>sum){
					sum = temp;
					this.i = i+1;
					this.j = j+1;
				}
			}
		}
		System.out.println("start: " +this.i + "  end:"+ this.j + "  maxsum: " + this.sum);
	}
	MaxSum(int [] a){
			int b=0;
			for(int i=0; i < a.length; ++i){
				if(b>0){
					b += a[i];
				}
				else{
					b = a[i];
					this.i = i+1;
				}
				if(b>this.sum){
					this.sum = b;
					this.j = i+1;
				}
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {-2,11,-4,13,-5,-2}; 
		MaxSum maxsum = new MaxSum(a);
		System.out.println("start: " + maxsum.i + "  end:"+ maxsum.j + "  maxsum: " + maxsum.sum);
		//maxsum.BruteForce(a);
	}

}
