package sunggyu.programmersLv3;

//https://school.programmers.co.kr/learn/courses/30/lessons/64064
//불량 사용자
import java.util.*;
class kakao1 {
    //불량 사용자가 존재한다.
    //불량 사용자는 최소 하나 이상의 문자가 *로 가려져 있다.
    //응모아이디와 불량사용자 아이디를 매핑 == 제재아이디
    //제재할 아이디 목록의 경우의 수를 출력하라.
    
    //불량사용자 아이디는 무조건 하나의 응모아이디와 매핑되어야 한다.
    //제재아이디는 중복되어서는 안 된다.
    List<BannedInfo> bannedInfos = new ArrayList<>();
    List<List<String>> combos = new ArrayList<>();
    int result;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        for(String bannedId : banned_id){
            BannedInfo bannedInfo = new BannedInfo(bannedId);
            for(String userId : user_id){
                bannedInfo.add(userId);
            }
            //System.out.println(bannedId);
            //System.out.println(bannedInfo.userIds.toString());
            bannedInfos.add(bannedInfo);
        }
        
        Set<String> selected = new HashSet<>();
        for(String userId : bannedInfos.get(0).userIds){
            selected.add(userId);
        }
        combo(1, selected);
        return result;
    }
    
    public void combo(int depth, Set<String> selected){
        if(bannedInfos.size() == depth){
            result = selected.size();
            //selected.forEach(str -> System.out.println(str));
            return;
        }
        List<List<String>> split = split(selected);
            
        BannedInfo bannedInfo = bannedInfos.get(depth);
        List<String> userIds = bannedInfo.userIds;
        Set<String> newSelected = new HashSet<>();
        
        for(List<String> list : split){
            for(String userId : userIds){
                String newCombo = getString(userId, list);
                if(!newCombo.isBlank()) newSelected.add(newCombo);
            }
        }
        
        combo(depth + 1, newSelected);
        
    }
    
    public String getString(String userId, List<String> list){
        if(list.stream().anyMatch(str -> str.equals(userId))) return "";
        String result = "";
        list.add(userId);
        Collections.sort(list);
        for(String str : list){
            result += str + "|";
        }
        list.remove(userId);
        return result;
    }
    
    public List<List<String>> split(Set<String> selected){
        List<List<String>> result = new ArrayList<>();
        selected.forEach(str ->{
            String[] values = str.split("\\|");
            List<String> list = new ArrayList<>();
            for(int i = 0; i < values.length; i++){
                list.add(values[i]);
            }
            result.add(list);
        });
            
        return result;
    }

}

class BannedInfo{
    String bannedId;
    List<String> userIds = new ArrayList<>();
    public BannedInfo(String bannedId){
        this.bannedId = bannedId;
    }
    public void add(String userId){
        if(bannedId.length() != userId.length()) return;
        
        for(int i = 0; i < bannedId.length(); i++){
            char c = bannedId.charAt(i);
            if(c != '*' && c != userId.charAt(i)) return;
        }
        
        userIds.add(userId);
    }
}