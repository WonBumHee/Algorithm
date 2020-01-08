package Backjoon;

import java.util.*;
import java.io.*;

public class Main_1012_유기농배추 {
	public static int dx[]= {0,0,-1,1};
	public static int dy[]= {-1,1,0,0};
	public static int M,N;
	public static int [][]map;
	public static int result;
	
		
	public static boolean chk[][];
	public static class Node{
		int x; int y; int cnt;
		public Node(int x,int y,int cnt) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
	}
	
	public static Queue<Node> q;
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Node tmp=q.poll();
			int x=tmp.x;
			int y=tmp.y;
			int cnt=tmp.cnt;
			result=Integer.max(result, cnt);
			for(int k=0;k<4;k++) {
				int nx= x+dx[k];
				int ny=y+dy[k];
				if(0<=nx &&0<=ny && nx<M && ny<N&&map[ny][nx]==1 && !chk[ny][nx]) {
					chk[ny][nx]=true;
					q.offer(new Node(nx,ny,cnt));
				}
			}
		}
	}
	

	public static void main(String[] args) throws Exception{

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			q= new LinkedList<>();
			st= new StringTokenizer(br.readLine());
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			chk= new boolean[N][M];
			map= new int[N][M];
			int K=Integer.parseInt(st.nextToken());
			for(int i=0;i<K;i++) {
				st= new StringTokenizer(br.readLine());
				int X=Integer.parseInt(st.nextToken());
				int Y=Integer.parseInt(st.nextToken());
				map[Y][X]=1;
			}
			
			result=0;
			int cnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(!chk[i][j]&&map[i][j]==1) {
						++cnt;
						q.offer(new Node(j,i,cnt));
						bfs();
						
					}
				}
			}
			
			System.out.println(result);
			
		}
	}

}
