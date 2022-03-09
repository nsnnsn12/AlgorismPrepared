package sunggyu.algorism.greedy;
import java.util.*;
public class Greedy2 {
    int n;
    int m;
    int[][] map;
    int[] minimumList;
    public void run(){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String[] split1 = str1.split(" ");
        n = Integer.parseInt(split1[0]);
        m = Integer.parseInt(split1[1]);
        map = new int[n][m];
        minimumList = new int[n];
        for(int i = 0; i < n; i++){
            String str = sc.nextLine();
            String[] list = str.split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(list[j]);
            }
            Arrays.sort(map[i]);
            minimumList[i] = map[i][0];
        }

        Arrays.sort(minimumList);

        System.out.println(minimumList[n-1]);

    }
}
