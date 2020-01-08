package N과M;

import java.io.*;
import java.util.*;

public class N과M3 {

	public static int N, M;
	public static int data[];

	public static void find(int N, int M, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(data[i]);
			}
			System.out.println();
			return;
		}

		for(int i=0;i<N;i++) {
			data[depth]=i+1;
			find(N,M,depth+1);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data =new int[N];

		find(N, M, 0);
	}

}
