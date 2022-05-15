package sunggyu.codingTest.ssg2022;
import java.util.*;
import java.util.stream.Collectors;
class Ssg2 {
    /*
        ["수험번호","문제 번호", "점수"]
        해당 배열이 주어진다.
        두 수험자의 푼 문제수
        문제 번호
        문제의 각 점수가 모두 같으면 부정행위자로 간주한다.

        특이사항
        푼 문제 수가 5이하인 경우는 제외한다.
        한 수험자가 동일한 문제를 푼 경우 마지막 제출이 채점 결과다.
    */
    public String[] solution(String[] logs) {
        String[] answer = {"None"};
        List<Student> students = getStudents(logs);
        setScores(students, logs);
        /*
        students.forEach(student -> {
            System.out.println(student.studentNo);
            student.scores.forEach(score -> {
                System.out.println(String.format("studentNo : %s, scoreNo : %d, score : %d", student.studentNo, score.scoreNo, score.score));
            });
        });*/
        List<String> result = new ArrayList<>();
        for(Student student : students){
            if(student.getScoreCount() >= 5){
                if(isCheating(student, students)){
                    result.add(student.studentNo);
                }
            }
        }
        Collections.sort(result);
        //result.forEach(System.out::println);
        if(result.size() > 0){
            answer = new String[result.size()];
            for(int i = 0; i < result.size(); i++){
                answer[i] = result.get(i);
            }
        }
        return answer;
    }

    public boolean isCheating(Student student, List<Student> students){
        for(Student st : students){
            if(student.getScoreCount() == st.getScoreCount() && !student.studentNo.equals(st.studentNo)){
                boolean isEquals = true;
                for(int i = 0 ; i < student.getScoreCount(); i++){
                    ScoreInfo scoreInfo1 = student.scores.get(i);
                    ScoreInfo scoreInfo2 = st.scores.get(i);
                    if(scoreInfo1.scoreNo != scoreInfo2.scoreNo || scoreInfo1.score != scoreInfo2.score){
                        isEquals = false;
                        break;
                    }
                }

                if(isEquals){
                    return true;
                }
            }
        }

        return false;
    }

    public void setScores(List<Student> students, String[] logs){
        for(String log : logs){
            String[] split = log.split(" ");
            Student student = students.stream().filter(st -> st.studentNo.equals(split[0])).findFirst().get();
            setStudentScore(student, split);
        }

        students.forEach(student -> Collections.sort(student.scores));
    }

    public void setStudentScore(Student student, String[] info){
        student.addScore(info[1], info[2]);
    }



    public List<Student> getStudents(String[] logs){
        List<Student> students = new ArrayList<>();
        List<String> studentNos = new ArrayList<>();
        for(String log : logs){
            String[] split = log.split(" ");
            studentNos.add(split[0]);
        }
        studentNos = studentNos.stream().distinct().collect(Collectors.toList());
        studentNos.forEach(s -> students.add(new Student(s)));
        return students;
    }
}

class Student{
    String studentNo;
    List<ScoreInfo> scores = new ArrayList<ScoreInfo>();
    public Student(String studentNo){
        this.studentNo = studentNo;
    }

    public int getScoreCount(){
        return scores.size();
    }

    public void addScore(String scoreNo, String score){
        ScoreInfo scoreInfo = new ScoreInfo(scoreNo, score);
        //동일한 문제를 풀었는지 확인
        if(existScore(scoreInfo)){
            //System.out.println(String.format("studentNo : %s, scoreNo : %s, score: %s", studentNo, scoreNo, score));
            scoreInfo = scores.stream().filter(s -> s.scoreNo == Integer.parseInt(scoreNo)).findFirst().get();
            scoreInfo.score = Integer.parseInt(score);
        }else{
            scores.add(scoreInfo);
        }
    }

    public boolean existScore(ScoreInfo score){
        return scores.stream().anyMatch(s -> s.scoreNo == score.scoreNo);
    }
}

class ScoreInfo implements Comparable<ScoreInfo>{
    int scoreNo;
    int score;
    public ScoreInfo(String scoreNo, String score){
        this.scoreNo = Integer.parseInt(scoreNo);
        this.score = Integer.parseInt(score);
    }

    @Override
    public int compareTo(ScoreInfo other){
        return scoreNo - other.scoreNo;
    }
}
