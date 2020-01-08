package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2812_크게만들기_다시 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		Stack<Character> stack= new Stack<>();
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		StringBuilder sb= new StringBuilder();
		String num= br.readLine();
		int cnt= K;
		
		for(int i=0;i<num.length();i++) {
			char tmp= num.charAt(i);
			
			while(!stack.isEmpty() && stack.peek()<tmp) {
				if(cnt==0) {
					break;
				}
				stack.pop();
				cnt--;
			}
			stack.push(tmp);
		}
		
		for(int i=0;i<N-K;i++) {
			sb.append(stack.get(i));
		}
		
		System.out.println(sb);
		
		
		
		
		
		
		
	}
}