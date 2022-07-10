package seokwoo.programmer.programmerLv2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/67257
// 수식 최대화

public class Kakao8 {
	char[] operationArray = {'*','+','-'};
	boolean[] isVisit = new boolean[3];
	private String expression;
	long max = Integer.MIN_VALUE;
	public long solution(String expression) {
		this.expression = expression;
		char[] operationSeqArray = new char[operationArray.length];
		pickOperationSeq(0, operationSeqArray);
		
		long answer = max;
        return answer;
		
	}
	private void calExpression(String expression, char[] operationSeqArray) {
		char[] expressionArray = expression.toCharArray();
		StringBuilder sb = new StringBuilder();
		List<Long> numArray = new LinkedList<>();
		ArrayList<Character> operationArray = new ArrayList<>();
		long num = 0;
		for(int i =0 ; i<expressionArray.length; i++) {
			if(expressionArray[i] == '+' || expressionArray[i] == '*' || expressionArray[i] == '-') {
				num = Long.valueOf(sb.toString());
				numArray.add(num);
				operationArray.add(expressionArray[i]);
				sb = new StringBuilder();
			}else {
				sb.append(expressionArray[i]);
			}
		}
		
		num = Long.valueOf(sb.toString());
		numArray.add(num);
		
		for(int i = 0; i<operationSeqArray.length; i++) {
			for(int j = 0; j<operationArray.size(); j++) {
				if(operationSeqArray[i] == operationArray.get(j)) {
					num = cal(numArray.get(j),numArray.get(j+1),operationArray.get(j));
					numArray.add(j, num);

					numArray.remove(j+1);
					numArray.remove(j+1);
					operationArray.remove(j);
				}
			}
		}
		if(!operationArray.isEmpty()) {
			num = cal(numArray.get(0),numArray.get(1),operationArray.get(0));
		}
		max = Math.max(max, Math.abs(num));
	}
	
	private long cal(Long num1, Long num2, Character operation) {
		switch(operation) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		default:
			return 0;
		}
	}
	// 연산자 순서 6가지 return
	private void pickOperationSeq(int depth, char[] operationSeqArray) {
		if(depth == 0) {
			operationSeqArray = new char[3];
		}
		if(depth == 3) {
			calExpression(expression, operationSeqArray);
			return;
		}
		for(int i = 0; i<operationArray.length; i++) {
			if(!isVisit[i]) {
				isVisit[i] = true;
				operationSeqArray[depth] = operationArray[i];
				pickOperationSeq(depth+1, operationSeqArray);
				isVisit[i] = false;
			}
		}
	}

}
