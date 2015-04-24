package exercise2;

import exercise2.Heap;

public final class PriorityQueue extends Heap {

	public PriorityQueue(int[] arr) throws Exception {
		super(arr);
		//throw new Exception("in priorityQueue(inr[] arr)");
	}
	public int maxmum(){
		return this.arr[1]; 
	}
	public int extractMax() throws Exception{
		int maxelem = this.arr[1];
		if (this.getSize() < 1){
			throw new Exception("extractMax():queue'length is low then 1");
		}
		this.arr[1] = this.arr[this.getSize()];
		this.setSize(this.getSize()-1);
		this.maxHeapify(1);
		return maxelem;
	}
	public void heapIncrease(int i, int key) throws Exception{
		if(i < 1||key < this.arr[i]){
			throw new Exception("heapIncrease");
		}
		this.arr[i] = key;
		while(i>1 && this.arr[this.parent(i)] < this.arr[i] ){
			int temp = this.arr[i];
			this.arr[i] = this.arr[this.parent(i)];
			this.arr[this.parent(i)] = temp;
			i = this.parent(i);
		}		
	}
	public void insert(int key){
		this.setSize(this.getSize()+1);
		this.arr[this.getSize()] = Integer.MIN_VALUE;//**********
		try{
			this.heapIncrease(this.getSize(), key);
		}catch(Exception e){
			e.printStackTrace(System.out);
		}
	}
}
