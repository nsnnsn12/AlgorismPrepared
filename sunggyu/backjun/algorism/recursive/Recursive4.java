package sunggyu.backjun.algorism.recursive;

import java.io.*;

public class Recursive4 {
    static int[] temp;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nk = bf.readLine().split(" ");
        int N = Integer.parseInt(nk[0]);
        int K = Integer.parseInt(nk[1]);
        temp = new int[N];
        int[] list = new int[N];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
        }
        mergeSort(list, 0, list.length-1);
        for(int i = 0; i < N; i++){
            System.out.print(list[i]+" ");
        }
        bw.flush();
        bw.close();
    }
    
    //절반씩 분할
    public static void mergeSort(int[] list, int l, int r){
        if(l < r){
            int c = (l+r) / 2;
            mergeSort(list, l, c);
            mergeSort(list, c+1, r);
            merge(list, l, c, r);
        }
    }

    //분할된 정렬 두개를 정렬
    public static void merge(int[] list, int l, int c, int r){
        //temp의 정렬된 값 저장
        int leftPoint = l;
        int rightPoint = c+1;
        int point = 0;
        while(leftPoint <= c && rightPoint <= r){
            int value = 0;
            if(list[leftPoint] > list[rightPoint]){
                value = list[rightPoint++];
            }else{
                value = list[leftPoint++];
            }

            temp[point++] = value;
        }
        if(leftPoint != c){
            for(int i = leftPoint; i <= c; i++){
                temp[point++] = list[leftPoint];
            }
        }

        if(rightPoint != r){
            for(int i = rightPoint; i <= c; i++){
                temp[point++] = list[rightPoint];
            }
        }
        //temp값 병합 정렬의 저장
        for(int i = l; i <= r; i++){
            list[i] = temp[i-l];
        }
    }
}
