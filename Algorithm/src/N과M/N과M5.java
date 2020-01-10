package N과M;

import java.io.BufferedReader;

import java.util.*;
import java.io.*;

public class N과M5 {

	public static int N, M;
	public static boolean chk[];
	public static int data[];
	public static int save[];

	public static void find(int N, int M, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(data[i]);
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!chk[i]) {
				chk[i]=true;
				data[depth] = save[i];
				find(N, M, depth + 1);
				chk[i]=false;
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		data = new int[N];
		save = new int[N];
		chk = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			save[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(save);

		find(N, M, 0);
	}

}
