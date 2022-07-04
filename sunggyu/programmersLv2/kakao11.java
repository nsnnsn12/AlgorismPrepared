package sunggyu.programmersLv2;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/72412
//순위 검색

class kakao11 {
    List<Applicant> applicants = new ArrayList<>();
    List<Query> querys = new ArrayList<>();
    List<Integer> result = new ArrayList<>();
    public int[] solution(String[] info, String[] query) {
        init(info, query);
        run();
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    public void run(){
        for(Query query : querys){
            long count = applicants.stream().filter(applicant -> isRequired(applicant, query)).count();
            result.add((int)(count));
        }
    }
    
    public boolean isRequired(Applicant applicant, Query query){
        if(!query.language.equals("-") && !query.language.equals(applicant.language)) return false;
        if(!query.job.equals("-") && !query.job.equals(applicant.job)) return false;
        if(!query.career.equals("-") && !query.career.equals(applicant.career)) return false;
        if(!query.food.equals("-") && !query.food.equals(applicant.food)) return false;
        if(query.score > applicant.score) return false;
        return true;
    }
    
    public void init(String[] info, String[] query){
        for(String in : info){
            String[] split = in.split(" ");
            applicants.add(new Applicant(split[0], split[1], split[2], split[3], Integer.parseInt(split[4])));
        }
        
        for(String q : query){
            String[] split = q.split(" ");
            querys.add(new Query(split[0], split[2], split[4], split[6], Integer.parseInt(split[7])));
        }
    }
}

class Applicant{
    String language;
    String job;
    String career;
    String food;
    int score;
    public Applicant(String language, String job, String career, String food, int score){
        this.language = language;
        this.job = job;
        this.career = career;
        this.food = food;
        this.score = score;
    }
}

class Query{
    String language;
    String job;
    String career;
    String food;
    int score;
    public Query(String language, String job, String career, String food, int score){
        this.language = language;
        this.job = job;
        this.career = career;
        this.food = food;
        this.score = score;
    }
}