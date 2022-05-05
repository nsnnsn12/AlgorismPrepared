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
    static int squared = 1;
    static int[][] map;
    static int[][] orders;
    //동남서북
    static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nr = bf.readLine().split(" ");
        n = Integer.parseInt(nr[0]);
        r = Integer.parseInt(nr[1]);
        for(int i = 0; i < n; i++){
            squared *= 2;
        }
        map = new int[squared][squared];
        for(int i = 0; i < squared; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < squared; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        orders = new int[r][2];
        for(int i = 0; i < r; i++){
            String[] split = bf.readLine().split(" ");
            int calcType = Integer.parseInt(split[0]);
            int scope = Integer.parseInt(split[1]);
            orders[i][0] = calcType;
            orders[i][1] = scope;
        }

        for(int i = 0; i < r; i++){
            int calcType = orders[i][0];
            int scope = orders[i][1];
            calc(calcType, scope);
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

    public static void calc(int calcType, int scope){
        if(calcType == 1 || calcType == 2 || calcType == 3 || calcType == 4){
            calcByColumn(calcType, scope);
        }else{
            calcByGroup(calcType, scope);
        }
    }

    public static void calcByColumn(int calcType, int scope){
        int size = getSize(scope);
        boolean isRight;
        for(int i = 0; i < squared; i+= size){
            for(int j = 0; j < squared; j+=size){
                switch (calcType) {
                    case 1:
                    //각 부분 배열의 상하반전
                    reverseHeight(i, j, size);
                    break;
                    case 2:
                    //각 부분 배열의 좌우반전
                    reverseWidth(i, j, size);
                    break;
                    case 3:
                    //각 부분 배열의 오른쪽으로 90도 회전
                    //isRight = true;
                    //turn(i, j, size, isRight);
                    right(i, j, size);
                    break;
                    case 4:
                    //각 부분 배열의 왼쪽으로 90도 회전
                    isRight = false;
                    turn(i, j, size, isRight);
                    break;
                    default:
                        break;
                }
            }
        }
    }

    public static void calcByGroup(int calcType, int scope){
        int size = getSize(scope);
        switch (calcType) {
            case 5:
            //상하반전
            reverseGroupHeight(size);
            break;
            case 6:
            //좌우반전
            reverseGroupWidth(size);
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

    public static int getSize(int n){
        int size = 1;
        for(int i = 0; i < n; i++){
            size *= 2;
        }

        return size;
    }

    public static void reverseHeight(int x, int y, int size){
        int endRowIndex = x + size - 1;
        for(int i = 0; i < size / 2; i++){
            for(int j = 0; j < size; j++){
                int temp = map[x+i][y+j];
                int reverseIndex = endRowIndex - i;
                map[x+i][y+j] = map[reverseIndex][y+j];
                map[reverseIndex][y+j] = temp;
            }
        }
    }

    public static void reverseGroupHeight(int size){
        int endRowIndex = squared;
        for(int i = 0; i < squared / 2; i+= size){
            endRowIndex -= size;
            for(int x = 0; x < size; x++){
                for(int y = 0; y < squared; y++){
                    int temp = map[i+x][y];
                    map[i+x][y] = map[endRowIndex+x][y];
                    map[endRowIndex+x][y] = temp;
                }
            }
        }
    }

    public static void reverseGroupWidth(int size){
        int endColumnIndex = squared;
        for(int i = 0; i < squared / 2; i+= size){
            endColumnIndex -= size;
            for(int x = 0; x < squared; x++){
                for(int y = 0; y < size; y++){
                    int temp = map[x][y+i];
                    map[x][y+i] = map[x][endColumnIndex+y];
                    map[x][endColumnIndex+y] = temp;
                }
            }
        }
    }

    public static int[][] getTemp(int x, int[][] temp, int size){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < squared; j++){
                temp[x][j] = map[x+i][j];
            }
        }
        return temp;
    }

    public static void reverseWidth(int x, int y, int size){
        int endColumnIndex = y + size - 1;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size / 2; j++){
                int temp = map[x+i][y+j];
                int reverseIndex = endColumnIndex - j;
                map[x+i][y+j] = map[x+i][reverseIndex];
                map[x+i][reverseIndex] = temp;
            }
        }
    }
    public static void right(int x, int y, int size){
        while(size >= 2){
            swap(x, y, size);
            x++;
            y++;
            size -= 2;
        }
    }
    /*
        1. 각 변의 시작점을 설정한다.
        2. 각 변의 시잠점을 swap한다.
        3. 각 변의 시작점을 이동한다.
        4. size - 1번 만큼 실행한다.
    */
    public static void swap(int x, int y, int size){
        int maxIndex = size - 1;
        //1. 각 변의 시작점을 설정 한다.
        int[][] sides = {{x,y},{x,y+maxIndex},{x + maxIndex, y + maxIndex}, {x + maxIndex, y}};

        //4. size - 1번 만큼 실행한다.
        for(int i = 0; i < maxIndex; i++){
            int temp = map[sides[0][0]][sides[0][1]];
            //2. 각 변의 시잠점을 swap한다.
            for(int j = 0; j < 4; j++){
                int nextIndex = (j+1) % 4;
                int nextX = sides[nextIndex][0];
                int nextY = sides[nextIndex][1];
                int nextTemp = map[nextX][nextY];
                map[nextX][nextY] = temp;

                temp = nextTemp;
            }

            //3. 각 변의 시작점을 이동한다.
            for(int j = 0; j < 4; j++){
                int nx = sides[j][0] + directions[j][0];
                int ny = sides[j][1] + directions[j][1];
                sides[j][0] = nx;
                sides[j][1] = ny;
            }
        }
    }
    public static void turn(int x, int y, int size, boolean isRight){
        int mx = x + size - 1;
        int my = y + size - 1;
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
        /*
        System.out.println("x:"+x+"y:"+y+"mx:"+mx+"my:"+my);
        list.forEach(i -> System.out.print(i+" "));
        System.out.println();
        */

        int size = list.size();
        int nowIndex = 0;
        int distance = mx - x;
        //시계방향은 --
        //반대방향은 ++
        if(isRight){
            nowIndex = size - distance;
        }else{
            nowIndex = distance % size;
        }

        //시작 값을 기준하는 것 잊지 않기
        int startX = x;
        int startY = y;
        for(int[] direct : directions){
            while(true){
                int nx = x + direct[0];
                int ny = y + direct[1];
                if(!canVisit(nx, ny) || nx > mx || ny > my || nx < startX || ny < startY){
                    break;
                }
                map[x][y] = list.get(nowIndex++);
                nowIndex = nowIndex % size;
                x = nx;
                y = ny;
            }
        }
    }

    public static List<Integer> getRotateList(int x, int y, int mx, int my){
        int startX = x;
        int startY = y;
        List<Integer> result = new ArrayList<>();
        for(int[] direct : directions){
            while(true){
                int nx = x + direct[0];
                int ny = y + direct[1];
                if(!canVisit(nx, ny) || nx > mx || ny > my || nx < startX || ny < startY){
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
}
