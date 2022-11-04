package sunggyu.backjun.algorism.iterator;
import java.io.*;
public class Iterator2 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        for(int i = 0; i < n; i++){
            String[] ab = bf.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            bw.write(String.valueOf(a + b));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
