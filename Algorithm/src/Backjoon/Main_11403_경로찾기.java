package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11403_경로찾기 {
	public static int N;
	public static int arr[][];
	public static Queue<Integer> q;

	public static ArrayList<Integer> list[];
	public static int result[][];
	public static boolean chk[];

	public static void bfs(int i, int j) {
		q.offer(i);

		while (!q.isEmpty()) {
			int tmp = q.poll();
			chk[tmp] = true;

			for (int k = 0; k < list[i].size(); k++) {
				result[tmp][list[i].get(k)] = 1;
				if (!chk[list[i].get(k)])
					q.offer(list[i].get(k));
			}
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		list = new ArrayList[N];
		result = new int[N][N];
		q = new LinkedList<>();
		chk = new boolean[N];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					list[i].add(j);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			chk=new boolean[N];
			for (int j = 0; j < N; j++) {
				bfs(i, j);
			}
		}

		for (int i = 0; i < result.length; i++)
			System.out.println(Arrays.toString(result[i]));

	}
}
