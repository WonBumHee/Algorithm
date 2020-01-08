package N과M;

import java.io.*;
import java.util.*;

public class N과M2 {
	public static int N,M;
	public static int data[];
	public static boolean chk[];
	
	public static void find(int N,int M,int depth,int next) {
		if(depth==M) {
			for(int i=0;i<M;i++) {
			System.out.print(data[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i=next;i<N;i++) {
			if(!chk[i]) {
				chk[i]=true;
				data[depth]=i+1;
				find(N,M,depth+1,data[depth]);
				chk[i]=false;
			}
		}
	}
	

	public static void main(String[] args) throws Exception{

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		data=new int[N];
		chk=new boolean[N];
		
		find(N,M,0,0);
	}

}
