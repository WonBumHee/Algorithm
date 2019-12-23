package Backjoon;

import java.util.*;
import java.io.*;


public class Main_1260_DFS와BFS {
	public static class Node{
		int start; int end;
		public Node(int start,int end) {
			this.start=start;
			this.end=end;
		}
	}
	public static int N,M,V;
	public static ArrayList<Integer>list[];
	public static boolean chk[];
	public static Queue<Integer> q;
	
	public static void bfs(int start) {
		
		chk[start]=true;
		
		q.offer(start);
		
		while(!q.isEmpty()) {
			int tmp= q.poll();
			System.out.print((tmp+1)+" ");
			for(int i=0;i<list[tmp].size();i++) {
				if(!chk[list[tmp].get(i)]) {
					chk[list[tmp].get(i)]=true;
					q.offer(list[tmp].get(i));
				}
			}
			
		}
		
	}
	public static void dfs(int start) {
		chk[start]=true;
		System.out.print((1+start)+" ");
		for(int i=0;i<list[start].size();i++) {
			if(!chk[list[start].get(i)]) {
				chk[list[start].get(i)]=true;
				dfs(list[start].get(i));
			}
		}
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());	//정점
		list= new ArrayList[N];
		chk= new boolean[N];
		
		
		M=Integer.parseInt(st.nextToken());	//간선
		V=Integer.parseInt(st.nextToken());	//정점의 번호
		q=new LinkedList<>();
		
		for(int i=0;i<N;i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st= new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			
			list[a].add(b);
			list[b].add(a);
		}
		for(int i=0;i<N;i++) {
			Collections.sort(list[i]);
		}
		
		dfs(V-1);
		System.out.println();
		for(int i=0;i<chk.length;i++) {
			chk[i]=false;
		}
		bfs(V-1);
		
		
		
	}

}
