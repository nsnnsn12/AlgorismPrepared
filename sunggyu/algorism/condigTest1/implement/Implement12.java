package sunggyu.algorism.condigTest1.implement;
import java.io.*;
import java.time.format.SignStyle;
import java.util.*;
//https://www.acmicpc.net/problem/20327
//배열 돌리기 6
/*
    1번 각 부분 배열의 상하반전
    2번 각 부분 배열의 좌우반전
    3번 각 부분 배열의 오른쪽으로 90도 회전
    4번 각 부분 배열의 왼쪽으로 90도 회전
    5번 상하반전
    6번 좌우반전
    7번 오른쪽으로 90도 회전
    8번 왼쪽으로 90도 회전
*/
public class Implement12{
    static int n;
    static int r;
    static int squared = 2;
    static int[][] map;
    static int[][] kl;
    //동남서북
    static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nr = bf.readLine().split(" ");
        n = Integer.parseInt(nr[0]);
        r = Integer.parseInt(nr[1]);
        for(int i = 0; i < n-1; i++){
            squared *= 2;
        }
        map = new int[squared][squared];
        for(int i = 0; i < squared; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < squared; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        kl = new int[r][2];
        for(int i = 0; i < r; i++){
            String[] split = bf.readLine().split(" ");
            int k = Integer.parseInt(split[0]);
            int l = Integer.parseInt(split[1]);
            kl[i][0] = k;
            kl[i][1] = l;
        }

        for(int i = 0; i < r; i++){
            int k = kl[i][0];
            int l = kl[i][1];
            calc(k, l);
        }

        for(int i = 0 ; i < squared; i++){
            for(int j = 0; j < squared; j++){
                bw.append(map[i][j]+" ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static void calc(int k, int l){
        int size = getSize(l);

        for(int i = 0; i < squared; i+= size){
            for(int j = 0; j < squared; j+=size){
                calcByType(i, j, k, size);
            }
        }
    }

    public static void calcByType(int x, int y, int k, int size){
        switch (k) {
            case 1:
            //각 부분 배열의 상하반전
            reverseTopAndDown(x, y, size);
            break;
            case 2:
            //각 부분 배열의 좌우반전
            reverseLeftAndRight(x, y, size);
            break;
            case 3:
            //각 부분 배열의 오른쪽으로 90도 회전
            boolean isRight = true;
            turn(x, y, size, isRight);
            break;
            case 4:
            //각 부분 배열의 왼쪽으로 90도 회전
            isRight = false;
            turn(x, y, size, isRight);
            break;
            case 5:
            //상하반전
            break;
            case 6:
            //좌우반전
            break;
            case 7:
            //오른쪽으로 90도 회전
            break;
            case 8:
            //왼쪽으로 90도 회전
            break;
            default:
                break;
        }
    }

    public static void reverseTopAndDown(int x, int y, int size){
        for(int i = 0; i < size / 2; i++){
            for(int j = 0; j < size; j++){
                int temp = map[x+i][y+j];
                int reverseIndex = x + size - 1 - i;
                map[x+i][y+j] = map[reverseIndex][y+j];
                map[reverseIndex][y+j] = temp;
            }
        }
    }

    public static void reverseLeftAndRight(int x, int y, int size){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size / 2; j++){
                int temp = map[x+i][y+j];
                int reverseIndex = y + size - 1 - j;
                map[x+i][y+j] = map[x+i][reverseIndex];
                map[x+i][reverseIndex] = temp;
            }
        }
    }

    public static void turn(int x, int y, int size, boolean isRight){
        int mx = x + size;
        int my = y + size;
        while(true){
            if(x >= mx || y >= my) break;
            rotate(x, y, mx, my, isRight);
            x++;
            y++;
            mx--;
            my--;
        }
    }

    public static void rotate(int x, int y, int mx, int my, boolean isRight){
        List<Integer> list = getRotateList(x, y, mx, my);
        int nowIndex = 0;
        int distance = mx - x;
        if(isRight){
            nowIndex = list.size() - distance;
        }else{
            nowIndex = distance;
        }


        for(int[] direct : directions){
            while(true){
                int nx = x + direct[0];
                int ny = y + direct[1];
                if(!canVisit(nx, ny) || nx >= mx || ny >= my){
                    break;
                }
                map[x][y] = nowIndex;
                nowIndex = (nowIndex + 1) % list.size();
                x = nx;
                y = ny;
            }
        }
    }

    public static List<Integer> getRotateList(int x, int y, int mx, int my){
        List<Integer> result = new ArrayList<>();
        for(int[] direct : directions){
            while(true){
                int nx = x + direct[0];
                int ny = y + direct[1];
                if(!canVisit(nx, ny) || nx >= mx || ny >= my){
                    break;
                }
                result.add(map[x][y]);
                x = nx;
                y = ny;
            }
        }
        return result;
    }

    public static boolean canVisit(int x, int y){
        if(x < 0 || x >= squared || y < 0 || y >= squared) return false;

        return true;
    }

    public static int getSize(int l){
        int size = 1;
        for(int i = 0; i < l; i++){
            size *= 2;
        }

        return size;
    }
}
