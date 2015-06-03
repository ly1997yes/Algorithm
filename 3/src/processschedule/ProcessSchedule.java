/*2��	A simple scheduling problem. We are given jobs j1, j2�� jn, all with known running times t1,
 * 		t2�� tn, respectively. We have a single processor. What is the best way to schedule these jobs in 
 * 		order to minimize the average completion time. Assume that it is a nonpreemptive scheduling:
 * 		once a job is started, it must run to completion. The following is an instance.
		a)	(j1, j2, j3, j4) : (15��8��3��10)
���˼·��
	��������ǲ���ϵͳ�еĽ��̵������⣻
	������Ŀ��û��˵��ÿ�����̵ĵ���ʱ�䣬�Ǿ����Ϊȫ��ͬʱ����
	����ռʽ
	���ּ�������� Ӧ���� ̰���㷨 �������ڵ�ǰʣ�� ������ѡ����ʱ��С���Ǹ�����
 * */
package processschedule;

public class ProcessSchedule {
	int []job;
	int []jobtime;
	double meantiem;
	
	ProcessSchedule(int [] j){
			this.job = j;
			jobtime = new int[j.length];
			schedule();
			jobtime[0] = this.job[0];
			for(int i = 1;i<job.length;i++){
				jobtime[i] = jobtime[i-1] + this.job[i];
			}
			
			int sum = 0;
			for(int i = 0; i<job.length;i++){
				sum += jobtime[i];
			}
			
			this.meantiem = (double)sum /job.length;
	}
	public void schedule(){
		quickSort(this.job,0,this.job.length-1);
	}
	
	private  int partation(int []arr,int p,int r){
		int key = arr[r];
		int i = p - 1;
		int temp;
		for(int j = p;j < r;j++){
			//comparitionCount++;
			if(arr[j] < key){
				i++;
				temp = arr[j];
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
	private  void quickSort(int []arr,int p,int r){
		if(p<r){
			int q = partation(arr,p,r);
			quickSort(arr,p,q-1);
			quickSort(arr,q+1,r);
		}
	}
	public static void main(String []args){
		int []job = {15,8,3,10};
		ProcessSchedule ps = new ProcessSchedule(job);
		ps.schedule();
		for(int i = 0;i<job.length;i++){
			System.out.print(job[i] +"  ");
		}
		System.out.print("\n mean time:" + ps.meantiem);
	}
	
}
