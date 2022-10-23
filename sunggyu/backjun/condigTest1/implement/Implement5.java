package sunggyu.backjun.condigTest1.implement;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14890
//경사로
/*
    또, 개수는 매우 많아 부족할 일이 없다. 경사로는 낮은 칸과 높은 칸을 연결하며, 아래와 같은 조건을 만족해야한다.

    경사로는 낮은 칸에 놓으며, L개의 연속된 칸에 경사로의 바닥이 모두 접해야 한다.
    낮은 칸과 높은 칸의 높이 차이는 1이어야 한다.
    경사로를 놓을 낮은 칸의 높이는 모두 같아야 하고, L개의 칸이 연속되어 있어야 한다.
    
    아래와 같은 경우에는 경사로를 놓을 수 없다.
    경사로를 놓은 곳에 또 경사로를 놓는 경우
    낮은 칸과 높은 칸의 높이 차이가 1이 아닌 경우
    낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
    경사로를 놓다가 범위를 벗어나는 경우

    경사로를 놓아 길이 될 수 있는 경우


*/
public class Implement5{
    static int n;
    static int l;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nl = bf.readLine().split(" ");
        n = Integer.parseInt(nl[0]);
        l = Integer.parseInt(nl[1]);
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            int[] width = getWidth(i);
            int[] height = getHeight(i);
            if(isRoad(width)) count++;
            if(isRoad(height)) count++;
        }

        System.out.println(count);
        bw.flush();
        bw.close();
    }

    public static boolean isRoad(int[] list){
        int beforeIndex = list[0];
        int equalsCount = 1;
        boolean isCheck = true;
        for(int i = 1; i < n; i++){
            int nowIndex = list[i];

            if(nowIndex == beforeIndex){
                equalsCount++;
                if(!isCheck){
                    if(equalsCount == l){
                        equalsCount = 0;
                        isCheck = true;
                    }
                }
            }else{
                if(!isCheck)  return false;
                //현재 보다 높은 곳을 올라간다면 equalsCount가 l 이상이어야 한다.
                //현재보다 낮은 곳으로 내려간다면 이후에 equalsCount가 l 이상이어야 한다;
                int distance = nowIndex - beforeIndex;
                distance = distance < 0 ? distance * -1 : distance;
                if(distance > 1) return false;

                if(beforeIndex < nowIndex){
                    if(equalsCount >= l){
                        beforeIndex = nowIndex;
                        equalsCount = 1;
                    }else{
                        return false;
                    }
                }else{
                    beforeIndex = nowIndex;
                    equalsCount = 1;
                    isCheck = false;
                    if(equalsCount == l){
                        equalsCount = 0;
                        isCheck = true;
                    }
                }
            }
        }
        if(!isCheck) return false;
        return true;
    }
    public static int[] getWidth(int index){
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = map[index][i];
        }
        return list;
    }

    public static int[] getHeight(int index){
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = map[i][index];
        }
        return list;
    }
}
