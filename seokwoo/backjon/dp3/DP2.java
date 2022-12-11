package seokwoo.backjon.dp3;
import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/9465
// 스티커
public class DP2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t != 0) {
			t--;
			
			int n = Integer.parseInt(br.readLine());
			int[][] array = new int[2][n];
			
			for(int i = 0; i<2; i++) {
				String[] temp = br.readLine().split(" ");
				
				for(int z = 0; z<n; z++) {
					array[i][z] = Integer.parseInt(temp[z]);
				}				
			}
			
			
			

		}

	}

}
