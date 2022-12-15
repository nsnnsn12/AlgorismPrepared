package sunggyu.backjun.algorism.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sort11 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        int[] list = new int[N];
        List<Point> points = new ArrayList<>();
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < N; i++){
            points.add(new Point(i, Integer.parseInt(split[i])));
        }

        Collections.sort(points);
        int count = -1;
        int beforeNumber = Integer.MAX_VALUE;
        for(Point point : points){
            if(point.number != beforeNumber){
                count++;
                beforeNumber = point.number;
            }
            list[point.order] = count;
        }

        for(int value : list){
            bw.write(String.format("%d ", value));
        }
        bw.flush();
        bw.close();
    }

    public static class Point implements Comparable<Point>{
        int order;
        int number;

        public Point(int order, int number){
            this.number = number;
            this.order = order;
        }

        @Override
        public int compareTo(Point o) {
            return number - o.number;
        }
    }
}
