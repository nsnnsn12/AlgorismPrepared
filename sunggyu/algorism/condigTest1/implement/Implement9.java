package sunggyu.algorism.condigTest1.implement;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2290
//LCD Test
/*
*/
public class Implement9{
    static int w;
    static int h;
    static int s;
    static char[][][] numbers;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sn = bf.readLine().split(" ");
        s = Integer.parseInt(sn[0]);
        String n = sn[1];
        w = s+2;
        h = s*2+3;
        numbers = new char[10][h][w];
        for(int i = 0; i < 10; i++){
            for(int x = 0; x < h; x++){
                Arrays.fill(numbers[i][x], ' ');
            }
        }
        drowOne();
        drowZero();
        drowTwo();
        drowFour();
        drowFive();
        drowSix();
        drowSeven();
        drowEight();
        drowNine();
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                System.out.print(numbers[0][i][j]);
            }
            System.out.println();
        }
        bw.flush();
        bw.close();
    }

    public static void drowOne(){
        drawHeight(1, w-1, 1); //위
        drawHeight(s*2, w-1, 1); //아래
    }

    public static void drowTwo(){
        drawWidth(0, 1, 2); //맨위
        drawWidth(s*2-1, 1, 2); //가운데
        drawWidth(h-1, 1, 2); //맨 아래
        drawHeight(1, w-1, 2); //위
        drawHeight(s*2, 0, 2); //아래
    }

    public static void drowThree(){
        drawWidth(0, 1, 3); //맨위
        drawWidth(s*2-1, 1, 3); //가운데
        drawWidth(h-1, 1, 3); //맨 아래
        drawHeight(1, w-1, 3); //위
        drawHeight(s*2, w-1, 3); //아래
    }

    public static void drowFour(){
        drawWidth(s*2-1, 1, 4); //가운데
        drawHeight(1, 0, 4); //위
        drawHeight(1, w-1, 4); //위
        drawHeight(s*2, w-1, 4); //아래
    }

    public static void drowFive(){
        drawWidth(0, 1, 5); //맨위
        drawWidth(s*2-1, 1, 5); //가운데
        drawWidth(h-1, 1, 5); //맨 아래
        drawHeight(1, 0, 5); //위
        drawHeight(s*2, w-1, 5); //아래
    }

    public static void drowSix(){
        drawWidth(0, 1, 6); //맨위
        drawWidth(s*2-1, 1, 6); //가운데
        drawWidth(h-1, 1, 6); //맨 아래
        drawHeight(1, 0, 6); //위
        drawHeight(s*2, w-1, 6); //아래
        drawHeight(s*2, 0, 6); //아래
    }

    public static void drowSeven(){
        drawWidth(0, 1, 7); //맨위
        drawHeight(1, w-1, 7); //위
        drawHeight(s*2, w-1, 7); //아래
    }

    public static void drowEight(){
        drawWidth(0, 1, 8); //맨위
        drawWidth(s*2-1, 1, 8); //가운데
        drawWidth(h-1, 1, 8); //맨 아래
        drawHeight(1, 0, 8); //위
        drawHeight(1, w-1, 8); //위
        drawHeight(s*2, w-1, 8); //아래
        drawHeight(s*2, 0, 8); //아래
    }

    public static void drowNine(){
        drawWidth(0, 1, 9); //맨위
        drawWidth(s*2-1, 1, 9); //가운데
        drawWidth(h-1, 1, 9); //맨 아래
        drawHeight(1, 0, 9); //위
        drawHeight(1, w-1, 9); //위
        drawHeight(s*2, w-1, 9); //아래
    }

    public static void drowZero(){
        drawWidth(0, 1, 0); //맨위
        drawWidth(h-1, 1, 0); //맨 아래
        drawHeight(1, 0, 0); //위
        drawHeight(1, w-1, 0); //위
        drawHeight(s*2, w-1, 0); //아래
        drawHeight(s*2, 0, 0); //아래
    }


    public static void drawHeight(int x, int y, int number){
        for(int i = 0; i < s; i++){
            numbers[number][x+i][y] = '|';
        }
    }

    public static void drawWidth(int x, int y, int number){
        for(int i = 0; i < s; i++){
            numbers[number][x][y+i] = '-';
        }
    }
}
