package org.example.friendexam.service;

import lombok.RequiredArgsConstructor;
import org.example.friendexam.domain.Friend;
import org.example.friendexam.repository.FriendRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor // final 멤버변수에 대해 생성자 주입..
public class FriendService {
    private final FriendRepository friendRepository;
    // 친구조회
    @Transactional(readOnly = true)
    public Iterable<Friend> findAllFriends(){
        return friendRepository.findAll();
    }

    // 친구 등록 - SELECT를 제외한 UPDATE, DELETE와 같은 수정이 일어날 때는, @Transactional 부여해줄 것 (SELECT는 readonly)
    @Transactional
    public Friend saveFriend(Friend friend){
        return friendRepository.save(friend); // 저장해주고, 해당 객체를 리턴해줄 것
    }

    // 친구 수정 - id에 해당하는 친구 정보 조회
    @Transactional(readOnly = true) // select니깐..
    public Friend findFriendById(Long id){
        return friendRepository.findById(id).orElse(null); // 만약 해당 id의 Friend가 없다면 null 객체 반환
    }


}
