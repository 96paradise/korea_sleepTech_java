package chapter10;

import java.util.ArrayList;
import java.util.LinkedList;

// === 이벤트 관리 시스템 === //
// - 이벤트 참가자 명단과 대기열 관리를 위한 시스템
// : 참가자는 사전 등록된 명단을 통해 이벤트에 참가
// : 명단이 가득 찰 경우 대기열로 추가, 참가자가 떠나면 대기열의 다음 사람이 추가

// 1) 이벤트 참가자 명단 관리: 사전 등록, 이벤트 당일 추가 참가자 등록 X
// : ArrayList (목록 추가, 삭제 X / 참가자 조회 O)

// 2) 대기열 관리
// : 이벤트의 한정된 좌석, 좌석이 모두 차면 추가 참가자는 대기열에 등록
// : LinkedList (목록 추가, 삭제 O / 참가자 조회 X)

class EventManagement {
    // == 필드 == //
    ArrayList<String> participantList = new ArrayList<>(); // 이벤트 참가자 명단
    LinkedList<String> waitingQueue = new LinkedList<>(); // 대기열 명단
    
    // == 메서드 == //
    void addParticipant(String name) {
        participantList.add(name);
    }
    
    void addToWaitingQueue(String name) {
        waitingQueue.add(name);
    }
    
    void leaveParticipant(String name) {
        // 대기열의 인원이 존재해야만 대기열 인원을 참가자 명단에 추가 가능
        // : 대기열 크기(.size())가 0 이상
        if (waitingQueue.size() > 0) {
            String nextParticipant = waitingQueue.remove(0); // 대기열에서 제거
            addParticipant(nextParticipant); // 참가자 명단에 추가
        }
    }
    
    boolean checkParticipant(String name) {
        return participantList.contains(name);
    }
}

public class C_ListPractice {
    public static void main(String[] args) {
        EventManagement eventManagement = new EventManagement();
        
        eventManagement.addParticipant("김하늘");
        eventManagement.addParticipant("박소연");
        eventManagement.addParticipant("최지훈");
        eventManagement.addParticipant("이정민");
        eventManagement.addParticipant("강수정");
        
        eventManagement.addToWaitingQueue("오민석");
        eventManagement.addToWaitingQueue("배현우");
        eventManagement.addToWaitingQueue("장희주");
        eventManagement.addToWaitingQueue("정민경");
        
        System.out.println(eventManagement.participantList); // [김하늘, 박소연, 최지훈, 이정민, 강수정]
        System.out.println(eventManagement.waitingQueue); // [오민석, 배현우, 장희주, 정민경]
        
        eventManagement.addToWaitingQueue("김태희");
        eventManagement.addToWaitingQueue("송지연");
        
        eventManagement.leaveParticipant("김하늘");
        eventManagement.leaveParticipant("최지훈");
        eventManagement.leaveParticipant("강수정");
        
        System.out.println(eventManagement.participantList);
        // [김하늘, 박소연, 최지훈, 이정민, 강수정, 오민석, 배현우, 장희주]
        
        System.out.println(eventManagement.waitingQueue); // [정민경, 김태희, 송지연]
        
        System.out.println(eventManagement.checkParticipant("최지훈")); // true
        System.out.println(eventManagement.checkParticipant("김태희")); // false
    }
}
