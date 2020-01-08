package N과M;

import java.io.*;
import java.util.*;

public class N과M1 {
	public static int N,M;

	public static int data[];
	public static boolean chk[];
	
	public static void dfs(int N,int M,int depth) {
		if(depth==M) {
			for(int i=0;i<M;i++) {
				System.out.print(data[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!chk[i]) {
				chk[i]=true;
				data[depth]=i+1;
				dfs(N,M,depth+1);
				chk[i]=false;
			}
		}
		
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		chk=new boolean[N];
		data=new int[N];
		
		
		dfs(N,M,0);
	}

}
