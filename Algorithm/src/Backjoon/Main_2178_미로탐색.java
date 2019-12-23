package Backjoon;

import java.util.*;
import java.io.*;

public class Main_2178_미로탐색 {
	public static int dx[] = { 0, 0, -1, 1 };
	public static int dy[] = { -1, 1, 0, 0 };

	public static class Node {
		int x;
		int y;
		int idx;

		public Node(int x, int y,int idx) {
			this.x = x;
			this.y = y;
			this.idx=idx;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		boolean[][] chk = new boolean[N][M];
		Queue<Node> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		q.offer(new Node(0, 0,1));

		while (!q.isEmpty()) {
			Node tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int idx=tmp.idx;
			if(y==N-1 && x==M-1) {
				System.out.println(idx);
			}
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (0 <= nx && nx < M && 0 <= ny && ny < N && !chk[ny][nx] && map[ny][nx] == '1') {
					chk[ny][nx]=true;
					q.offer(new Node(nx, ny,idx+1));
				}
			}
		}
		
		
		
		
	}

}
