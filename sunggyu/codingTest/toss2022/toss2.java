import java.util.*;
class toss2 {
    /*
        1.상위 25% 이내의 문제를 뽑는다.
    */
    int N;
    public int solution(int[] levels) {
        N = levels.length;
        int count = N / 4;
        if(count == 0) return -1;
        Arrays.sort(levels);
        int answer = levels[levels.length-count];
        return answer;
    }
}