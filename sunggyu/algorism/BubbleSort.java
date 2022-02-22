package sunggyu.algorism;

/**
 * bubbleSort
 */
class BubbleSort {
    int[] list = {2,3,4,5,5,32,1};
    public void sort(){
        for(int i: list){
            System.out.printf(" %d", i);
        }
        System.out.println();

        int n = list.length;
        int count = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = n-1; j > i; j--){
                count++;
                if(list[j] < list[j-1]){
                    int temp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = temp;
                }
            }
        }

        for(int i: list){
            System.out.printf(" %d", i);
        }
        System.out.printf("교환 횟수:%d", count);
    }

    //멈춤을 이용한 기능 개선
    public void sort2(){
        for(int i: list){
            System.out.printf(" %d", i);
        }
        System.out.println();

        int n = list.length;
        int count = 0;
        int sortCount = 0;
        for(int i = 0; i < n-1; i++){
            sortCount = 0;
            for(int j = n-1; j > i; j--){
                count++;
                if(list[j] < list[j-1]){
                    sortCount++;
                    int temp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = temp;
                }
            }
            if(sortCount == 0){
                break;
            }
        }

        for(int i: list){
            System.out.printf(" %d", i);
        }
        System.out.printf("교환 횟수:%d", count);
    }

    //정렬 여부를 이용한 기능 개선
    public void sort3(){
        for(int i: list){
            System.out.printf(" %d", i);
        }
        System.out.println();

        int n = list.length;
        int count = 0;
        int sortCount = 0;
        for(int i = 0; i < n-1; i++){
            sortCount = 0;
            for(int j = n-1; j > i; j--){
                count++;
                if(list[j] < list[j-1]){
                    sortCount++;
                    int temp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = temp;
                }
            }
            if(sortCount == 0){
                break;
            }
        }

        for(int i: list){
            System.out.printf(" %d", i);
        }
        System.out.printf("교환 횟수:%d", count);
    }
}