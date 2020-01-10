package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_바이러스 {
	public static int parr[];

	public static int par(int a) {
		if (parr[a] == a)
			return a;
		return par(parr[a]);
	}

	public static void union(int i, int j) {
		int pari = par(i);
		int parj = par(j);

		if (pari > parj) {
			parr[pari] = parj;
		} else
			parr[parj] = pari;

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int pair = Integer.parseInt(br.readLine());
		parr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parr[i] = i;
		}

		for (int i = 0; i < pair; i++) {
			StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (par(a) != par(b))
				union(a, b);
		}
		int cnt = 0;
		for (int i = 1; i < parr.length; i++) {
			if (par(i) == 1)
				cnt++;
		}

		System.out.println(cnt - 1);

	}

}
