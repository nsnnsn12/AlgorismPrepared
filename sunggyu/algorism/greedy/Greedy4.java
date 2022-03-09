package sunggyu.algorism.greedy;
import java.util.*;
//https://www.acmicpc.net/problem/1946
public class Greedy4 {
    /*
    시험성적이라고 하지만 입력되는 것은 성적의 순위이고 동석차가 없다.
    이 말은 n은 중복되지 않고 정렬이 가능하다는 것.
    면접시험 성적이 a, 서류 심사 성적이 b라고 하자
    a를 기준으로 오름차순 정렬을 한다면 
    b는 기준 인덱스 이전의 모든 값보다 낮아야 입사가 가능하다.
    그 반대도 마찬가지이다.
    예시)
    1 4
    2 3
    3 2
    4 1
    5 5
    */
    int[] nlist;
    int k;
    public void run(){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        int t = Integer.parseInt(str1);
        nlist = new int[t];

        for(int i = 0; i < t; i++){
            int n =Integer.parseInt(sc.nextLine());
            nlist[i] = n;
            for(int j = 0; j < n; j++){
                String str = sc.nextLine();
                String[] split = str.split(" ");
                int score1 = Integer.parseInt(split[0]);
                int score2 = Integer.parseInt(split[1]);
            }
        }
    }
}
