package sunggyu.programmersLv2;

import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/81302#fnref1
//거리두기 확인하기

class kakao14 {
    List<Place> cases = new ArrayList<>();
    public int[] solution(String[][] places) {
        for(String[] place : places){
            cases.add(new Place(place));
        }
        int[] answer = new int[cases.size()];
        for(int i = 0; i < cases.size(); i++){
            Place place = cases.get(i);
            answer[i] = place.getProtected();
        }
        return answer;
    }
    
    public int getDistance(){
        return 0;
    }
}

class Place{
    char[][] map = new char[5][5];
    List<Person> persons = new ArrayList<>();
    
    public Place(String[] strMap){
        for(int i = 0; i < 5; i++){
            char[] list = strMap[i].toCharArray();
            for(int j = 0; j < 5; j++){
                map[i][j] = list[j];
                if(map[i][j] == 'P'){
                    persons.add(new Person(i,j, map));
                }
            }
        }
    }
    
    public int getProtected(){
        //System.out.println("protected");
        for(Person person : persons){
            //System.out.println(String.format("x : %d, y : %d", person.x, person.y));
            if(!person.isProtect()) return 0;
        }
        return 1;
    }
}

class Person{
    int[][] directions = {{0,1}, {1,0},{0,-1},{-1,0}};
    int x;
    int y;
    char[][] map;
    public Person(int x, int y, char[][] map){
        this.x = x;
        this.y = y;
        this.map = map;
    }
    
    public boolean isProtect(){
        for(int i = 0; i < 4; i++){
            if(!protect(i)) return false;
        }
        return true;
    }
    
    public boolean protect(int index){
        int nx = x + directions[index][0];
        int ny = y + directions[index][1];
        if(isBlock(nx, ny)){
            return true;
        }
        
        if(isPerson(nx, ny)){
            return false;
        }
        
        if(isPerson(nx + directions[index][0], ny + directions[index][1])){
            return false;
        }
        
        int rightIndex = (index + 1) % 4;
        if(isPerson(nx + directions[rightIndex][0], ny + directions[rightIndex][1])){
            return false;
        }
        int leftIndex = (index + 3) % 4;
        if(isPerson(nx + directions[leftIndex][0], ny + directions[leftIndex][1])){
            return false;
        }
        return true;
    }
    
    public boolean isBlock(int x, int y){
        if(x < 0 || x >= 5 || y < 0 || y >= 5){
            return false;
        }
        if(map[x][y] == 'X') return true;
        return false;
    }
    
    public boolean isPerson(int x, int y){
        if(x < 0 || x >= 5 || y < 0 || y >= 5){
            return false;
        }
        if(map[x][y] == 'P') return true;
        return false;
    }
}