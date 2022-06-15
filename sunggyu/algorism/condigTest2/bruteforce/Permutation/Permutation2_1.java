package sunggyu.algorism.condigTest2.bruteforce.Permutation;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1339
//단어 수학
/*
    123 => 100 + 20 + 3
    111 => 100 + 10 + 1
    999 => 900 + 90 + 9

    1. 각 알파벳 별로 10의 자릿수 별로 값을 모은다.
    2. 값이 제일 큰 것을 기준으로 9~1을 곱한다.

    ABC => a : 100, b : 10, c :1 => 100 * 9 + 10 * 80 + c * 7 = 987
*/
public class Permutation2_1{
    static BufferedReader br;
    static BufferedWriter bw;

    static int N;
	static char[][] words;
	static int[] value;
	static int ans;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		words = new char[N][];
		value = new int[26];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			int temp = (int) Math.pow(10, words[i].length-1);
			for (int j = 0; j < words[i].length; j++) {
				int charIdx = words[i][j] - 'A';
				value[charIdx] += temp;
				temp /= 10;
			}
		}

		Arrays.sort(value);
        //Arrays.stream(value).forEach(i -> System.out.print(i+" "));

		int num = 9;
		for (int i = 25; i >= 0; i--) {
			if (value[i] == 0)	break;

			ans += (value[i] * num);
			num--;
		}
		System.out.println(ans);
        bw.flush();
        bw.close();
    }
}
