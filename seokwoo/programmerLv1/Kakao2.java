package seokwoo.programmerLv1;



// https://programmers.co.kr/learn/courses/30/lessons/72410
// 신규 아이디 추천

/*
 * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
 * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
 * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
 * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
 * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
 * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
 * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
 */
public class Kakao2 {
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계 대문자 -> 소문자
        answer = new_id.toLowerCase(); 
       
        // 2단계 이상한 문자 제거
        char[] listAnswer = answer.toCharArray();
        StringBuilder tempAnswer = new StringBuilder();
        for(char word: listAnswer) {
        	if( Character.isLowerCase(word) || word == '-' || word == '_' || word == '.' || Character.isDigit(word)) {
        		tempAnswer.append(word);
        	}
        }
        answer = tempAnswer.toString();
       
        
        // 3단계 ..을 .으로 치환
        while(answer.contains("..")) {
        	answer = answer.replace("..", "."); 
        }
       
        
        // 4단계 처음과 끝에있는 .제거
        if(answer.length() > 0) {
        	if(answer.charAt(0) == '.') {
            	answer = answer.substring(1, answer.length());
            }
        }
        if(answer.length() > 0) {
	        if(answer.charAt(answer.length()-1) == '.') {
	        	answer = answer.substring(0,answer.length()-1);
	        }
        }    
       
        // 5단계 공백 a로 치환
        if(answer.equals("")) {
        	answer = "a";
        }
       
        // 6단계 15자리 초과 글자 제거
        if(answer.length() >= 16) {
        	answer = answer.substring(0, 15);
        	
        	if(answer.charAt(answer.length()-1) == '.') {
        		answer = answer.substring(0, answer.length()-1);
        	}
        }
       
        // 7단계 2자리 이하라면 마지막 문자를 계속 붙여 3자리로 만들기
        StringBuilder tempAnswer7 = new StringBuilder(answer);
        if(tempAnswer7.length() <=2) {
        	char last = tempAnswer7.charAt(tempAnswer7.length() -1);
        	
        	while(tempAnswer7.length() < 3) {
        		tempAnswer7.append(last);
        	}
        }
        answer = String.valueOf(tempAnswer7);
       
        return answer;
    }
}
