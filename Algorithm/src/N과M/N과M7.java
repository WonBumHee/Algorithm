package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class N과M7 {
	public static int N,M;
	public static int data[];
	public static int save[];
	
	public static void find(int depth) {
		if(depth==M) {
			for(int i=0;i<M;i++) {
				System.out.print(save[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<N;i++) {
			save[depth]=data[i];
			find(depth+1);
		}
		
	}
	

	public static void main(String[] args) throws Exception{

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		data=new int[N];
		save=new int[N];
		M=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<data.length;i++) {
			data[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(data);
		find(0);
	}

}
