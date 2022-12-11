package sunggyu.backjun.algorism.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort7 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        List<Point> points = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String[] split = bf.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            points.add(new Point(x, y));
        }

        Collections.sort(points);

        for(Point point : points){
            bw.write(String.format("%d %d %n", point.x, point.y));
        }
        bw.flush();
        bw.close();
    }

    public static class Point implements Comparable<Point>{
        int x,y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(o.x == x){
                return y - o.y;
            }

            return x - o.x;
        }

    }
    
}
