package sunggyu.codingTest.ssg2022;

public class Main {
    public static void main(String[] args) {
        int[][] macaron = {{1,1},{1,2},{1,4},{2,1},{2,2},{2,3},{3,4},{3,1},{3,2},{3,3},{3,4},{4,4},{4,3},{5,4},{6,1}};
        //int[][] macaron = {{1,1},{2,1},{1,2},{3,3},{6,4},{3,1},{3,3},{3,3},{3,4},{2,1}};
        Ssg4 ssg4 = new Ssg4();
        ssg4.solution(macaron);
    }
}
