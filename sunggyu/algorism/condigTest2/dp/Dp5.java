package sunggyu.algorism.condigTest2.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11066
//파일 합치기
/*
    내가 메모제이션하고 싶은 값이 무엇인가?
    인접한 파일끼리만 더할 수 있다.
    이 말은 곧 2개로 분할된다는 의미이다.
    1 | 2 3 4
    1 2 | 3 4
    1 2 3 | 4
    이런 식으로 모두 2분할이 가능하다.
    이를 작게 나누어 각 범위의 최솟값을 메모제이션한다.
*/
public class Dp5 {
    static BufferedReader bf;
    static BufferedWriter bw;
    static int T;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(bf.readLine());
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(bf.readLine());
            String[] split = bf.readLine().split(" ");
            int[] list = new int[n];
            FileInfo[][] dp = new FileInfo[n][n];
            for(int j = 0; j < n; j++){
                list[j] = Integer.parseInt(split[j]);
            }

            for(int scope = 0; scope < n; scope++){
                for(int startIndex = 0; startIndex < n; startIndex++){
                    if(startIndex+scope < n){
                        dp[startIndex][startIndex+scope] = getMinCost(dp, list, startIndex, startIndex+scope);
                    }
                }
            }
            
            bw.write(String.valueOf(dp[0][n-1].cost));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static FileInfo getMinCost(FileInfo[][] dp, int[] list, int startIndex, int scope){
        if(startIndex == scope) return new FileInfo(list[startIndex], 0);
        int minCost = Integer.MAX_VALUE;
        FileInfo result = null;
        int fileSize = dp[startIndex][scope-1].fileSize + dp[scope][scope].fileSize;
        //System.out.println("fileSize:"+fileSize);
        for(int i = startIndex; i < scope; i++){
            //두 개의 파일을 합칠 때 필요한 비용(시간 등)이 두 파일 크기의 합
            int cost = dp[startIndex][i].cost + dp[i+1][scope].cost + fileSize;
            if(cost < minCost){
                minCost = cost;
                result = new FileInfo(fileSize, cost);
            }
        }

        //System.out.println(result.cost);
        return result;
    }

    public static class FileInfo{
        public int fileSize;
        public int cost;
        FileInfo(int fileSize, int cost){
            this.fileSize = fileSize;
            this.cost = cost;
        }
    }
}


