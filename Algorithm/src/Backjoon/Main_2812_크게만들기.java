package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2812_크게만들기 {
   
   public static void main(String[] args) throws IOException {
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      String s[]=br.readLine().split(" ");
      //Solution ss=new Solution();
      int len=Integer.parseInt(s[0]);
      int k=Integer.parseInt(s[1]);
      String number=br.readLine();
      String num=solution(number,k);
      System.out.println(num);
   }
   public static String solution(String number, int k) {  
        
       String answer="";
       int len=number.length()-k;
       int cnt=k;
       Stack<Character> stack=new Stack<>();
       char arr[]=new char[len];
       
       for(int i=0;i<number.length();i++) {
          char c=number.charAt(i);
          while(!stack.isEmpty() && stack.peek()<c) {
             if(cnt==0)
                break;
             stack.pop();
             cnt--;
          }
          
          stack.push(c);
       }
        for(int i=0;i<len;i++) {
           arr[i]=stack.get(i);
        }

        return new String(arr);
    }
}