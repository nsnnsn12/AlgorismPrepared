package sunggyu.algorism.greedy;
import java.util.*;
public class Greedy1 {
    int n;
    int m;
    int k;
    int[] list;
    public void run(){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        String[] split1 = str1.split(" ");

        String[] split2 = str2.split(" ");
        setting(split1, split2);

        Arrays.sort(list);

        for(int i : list){
            System.out.println(i);
        }
        int result = 0;
        int i = m / (k + 1);
        result += list[n-1] * (m - i);
        result += list[n-2] * i;

        System.out.println(result);


    }

    public void setting(String[] split1, String[] split2){
        n = Integer.parseInt(split1[0]);
        m = Integer.parseInt(split1[1]);
        k = Integer.parseInt(split1[2]);
        list = new int[n];

        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(split2[i]);
        }
    }
}
