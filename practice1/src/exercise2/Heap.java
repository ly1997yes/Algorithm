package exercise2;

public class Heap {
	int capibility = 100;
	protected int arr[] = new int [capibility];
	public Heap() {
		// TODO Auto-generated constructor stub
	}
	public Heap(int arr[]) throws Exception{
		if (arr.length > this.capibility-1)
			throw new Exception("\ncapibility exception!");
		for(int i = 0;i < arr.length; i++)
			this.arr[i+1] = arr[i];
		this.setSize(arr.length);
	}
	public void setSize(int size){
		this.arr[0] = size; 
	}
	public int getSize(){
		return this.arr[0];
	}
	
	public int getEnum(int i){
		return this.arr[i];
	}
	public int parent(int i){
			return i>>1;
	}
	public int left(int i){
		return i<<1;
	}
	public int right(int i){
		return (i<<1)+1;
	}
	public void maxHeapify(int i){
		int l = this.left(i);
		int r = this.right(i);
		int largest = i;
		if (l <= this.getSize() && this.getEnum(l) > this.getEnum(largest))
			largest = l;
		if (r <= this.getSize() && this.getEnum(r) > this.getEnum(largest))
			largest = r;
		if (largest != i){
			int temp = this.arr[i];
			this.arr[i] = this.arr[largest];
			this.arr[largest] = temp;
			maxHeapify(largest);
		}
		
	}

	/*
	
		public void maxHeapify(Heap h,int i){
		int l = h.left(i);
		int r = h.right(i);
		int largest = i;
		if (l <= h.getSize() && h.getEnum(l) > h.getEnum(largest))
			largest = l;
		if (r <= h.getSize() && h.getEnum(r) > h.getEnum(largest))
			largest = r;
		if (largest != i){
			int temp = h.arr[i];
			h.arr[i] = h.arr[largest];
			h.arr[largest] = temp;
			maxHeapify(h,largest);
		}
	}*/
	
	public void buildMaxHeap(){
		for(int i = this.parent(this.getSize());i > 0;i--){
			maxHeapify(i);
		}
	}
	public void printHeap(){
		double high = Math.log(this.getSize())/Math.log(2);
		for(int i = 1;i <= this.getSize();i++){
			
			for(int j = 0;j < (int)high - (int)(Math.log(i)/Math.log(2));j++)
				System.out.print("	");
			System.out.print(this.arr[i]+" ");
			
		}
	}
}
