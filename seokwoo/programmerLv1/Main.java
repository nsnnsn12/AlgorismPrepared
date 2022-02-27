package seokwoo.programmerLv1;

public class Main {
	public static void main(String[] args) {
		Kakao3 kakao3 = new Kakao3();
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi","muzi frodo"};
		int k = 2;
				
		System.out.println(kakao3.solution(id_list,report,k));

	}

}
