package sunggyu.programmersLv2;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/72412
//순위 검색
class kakao11 {
    List<Applicant> applicants = new ArrayList<>();
    List<Query> querys = new ArrayList<>();
    List<Integer> result = new ArrayList<>();
    String[][] category = {{"cpp","java","python","-"},{"backend","frontend","-"},{"junior","senior","-"},{"chicken","pizza","-"}};
    Map<String, List<Applicant>> wheres = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        init(info, query);
        for(Query q : querys){
            List<Applicant> aplicant = wheres.get(q.query);
            if(aplicant.get(0).score >= q.score){
                result.add(aplicant.size());
                continue;
            }
            
            if(aplicant.get(0).score < q.score){
                result.add(0);
                continue;
            }
            int r = binarySearch(aplicant,q.score, 0, aplicant.size()-1);
            result.add(aplicant.size() - r);
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
    public int binarySearch(List<Applicant> applicants, int score, int start,int end){
        if(end > start) return end;
        
        int mid = (start + end) /2;
        int size = applicants.size();
        
        if(applicants.get(mid).score >= score){
            return binarySearch(applicants, score, start, mid-1);
        }else{
            return binarySearch(applicants, score, mid + 1, end);
        }
    }
    
    public void init(String[] info, String[] query){
        String[] selected = new String[4];
        dfs(0, selected);
        for(String in : info){
            String[] split = in.split(" ");
            applicants.add(new Applicant(split));
        }
        
        for(String q : query){
            String[] split = q.split(" ");
            querys.add(new Query(split[0], split[2], split[4], split[6], Integer.parseInt(split[7])));
        }
        
        Collections.sort(applicants);
        for(Applicant applicant : applicants){
            List<String> whereCases = applicant.whereCase;
            for(String whereCase : whereCases){
                List<Applicant> list = wheres.get(whereCase);
                list.add(applicant);
            }
        }
    }
    
    public void dfs(int depth, String[] selected){
        if(depth == 4){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 4; i++){
                sb.append(selected[i]);
            }
            wheres.put(sb.toString(), new ArrayList<>());
            return;
        }
        for(int i = 0; i < category[depth].length; i++){
            selected[depth] = category[depth][i];
            dfs(depth + 1, selected);
        }
    }
}

class Applicant implements Comparable<Applicant>{
    String language;
    String job;
    String career;
    String food;
    int score;
    List<String> whereCase = new ArrayList<>();
    String[] split;
    public Applicant(String[] split){
        this.split = split;
        this.language = split[0];
        this.job = split[1];
        this.career = split[2];
        this.food = split[3];
        this.score = Integer.parseInt(split[4]);
        String[] selected = new String[4];
        getWhereCase(0, selected);
    }
    
    public void getWhereCase(int depth, String[] selected){
        if(depth == 4){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 4; i++){
                sb.append(selected[i]);
            }
            whereCase.add(sb.toString());
            return;
        }
        selected[depth] = split[depth];
        getWhereCase(depth+1, selected);
        selected[depth] = "-";
        getWhereCase(depth+1, selected);
    }
    public int compareTo(Applicant o){
        return this.score - o.score;
    }
}

class Query{
    String language;
    String job;
    String career;
    String food;
    String query;
    int score;
    public Query(String language, String job, String career, String food, int score){
        this.language = language;
        this.job = job;
        this.career = career;
        this.food = food;
        this.score = score;
        query = language+job+career+food;
    }
}