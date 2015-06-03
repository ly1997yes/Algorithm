/*1 Knapsack Problem. There are 5 items that have a value and weight list below, 
 * the knapsack can contain at most 100 Lbs. 
 * Solve the problem both as fractional knapsack and 0/1 knapsack.
 * */
package knapsack;

public class Knapsack {
	private Goods []goods;
	public float []count;
	public int maxWight;
	Knapsack(int []v,int []w,int maxWight){
		if(v.length != w.length || v.length <1){//错误处理
			System.out.print("ilegle input!!");
			return;
		}
		this.goods = new Goods[v.length];
		this.count = new float[v.length];
		this.maxWight = maxWight;
		for (int i = 0;i < v.length;i++){//初始化所有的物品
			this.goods[i] = new Goods(i,v[i],w[i]);
			//System.out.println(goods[i].price);
		}
	}
	
	public void fractionKnapsack(){//分数背包 显然是贪心选择问题
		System.out.println("Fraction Knapsack");
		calc();
		float current = this.maxWight;
		for(int i = this.goods.length-1;i>=0;i--){
			if(this.goods[i].value > current ){
				this.count[i] = current / this.goods[i].price;
				break;
			}
			this.count[i] = this.goods[i].wight;
			current = current - this.goods[i].value;
		}
		current = 0;
		for(int i = this.goods.length-1;i>=0;i--){
			System.out.println("id: " + this.goods[i].id +" value: " + this.goods[i].value + " count:" + count[i]);
			current += this.goods[i].price*count[i];
		}
		System.out.print("count in all:"+ current);
	}
	private void calc(){
		quickSort(this.goods,0,this.goods.length-1);
//		for (int i = 0;i < goods.length;i++){
//			System.out.println("id:" + goods[i].id+ "   price:" + goods[i].price);
//		}
	}

	private  int partation(Goods [] arr,int p,int r){
		float key = arr[r].price;
		int i = p - 1;
		Goods temp;
		for(int j = p;j < r;j++){
			//comparitionCount++;
			if(arr[j].price < key){
				i++;
				temp = arr[j] ;
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		//comparitionCount++;
		temp = arr[i+1];
		arr[i+1] = arr[r];
		arr[r] = temp;
		return i+1;
	}
	private  void quickSort(Goods []arr,int p,int r){
		if(p<r){
			int q = partation(arr,p,r);
			quickSort(arr,p,q-1);
			quickSort(arr,q+1,r);
		}
	}
	public void _01Knapsack(){
		int [][] c = new int [this.goods.length+1][this.maxWight+1];
		for(int i=0;i< this.goods.length+1;i++){
			c[0][i] = 0;
		}
		for(int i = 1;i < this.goods.length+1;i++){
			for(int j= 1;j< this.maxWight+1;j++){
				if(this.goods[i+1].wight > j){
					c[i][j] = maxOfTwoDigital(0 , c[i-1][j]);
				}
				else{
					if( c[i-1][j-(this.goods[i+1].wight)]+this.goods[i+1].value > c[i-1][j]){
						c[i][j] = c[i-1][j-(this.goods[i+1].wight)]+this.goods[i+1].value;
						
					}else{
						c[i][j] = c[i][j];
					}
				}
			}
		}
		
	}
	private  int maxOfTwoDigital(int a,int b){
		if(a > b)
			return a;
		return b;
	}
	
	
	public static void main(String args[]){
		int [] v = {20,30,65,40,60};
		int [] w = {10,20,30,40,50};
		int maxWight = 100;
		Knapsack k = new Knapsack(v,w,maxWight);
		k.fractionKnapsack();
	}
}
class Goods{
	int id; 
	int value;
	int wight;
	float price;
	Goods(int id,int v,int w){
		this.id = id;
		this.value = v;
		this.wight = w;
		this.price = (float) this.value /this.wight;
	}
}
