package org.example.spring_mvc.friend;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class FriendController {
    // 데이터는 List로 임의로 만듦
    private List<Friend> friends = Arrays.asList(
            new Friend("user1", "사용자1", "u1@user.com"),
            new Friend("user2", "사용자2", "u2@user.com"),
            new Friend("user3", "사용자3", "u3@user.com")
    );
    // 친구 등록 페이지
    @GetMapping("/friend/registerForm")
    public String showFriendResisterForm(Model model){
        model.addAttribute("friend", new Friend());
        return "friendForm";
    }

    // 친구 등록
    @PostMapping("/friend/register")
    public String registerFriend(@Valid @ModelAttribute("friend") Friend friend, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "friendForm"; // 에러가 있다면 다시 friendForm 작성하도록..
        }
        return "register"; // 성공했다면 register.html로 !
    }

    // 친구 목록 보기
    @GetMapping("/friend/list")
    public String showFriendList(Model model){
        model.addAttribute("friends", friends);
        return "friendList";
    }

    // 친구 정보 수정 페이지
    @GetMapping("/friend/edit/{id}")
    String showEditFriendForm(@PathVariable("id") String id, Model model){
        //System.out.println("id : " + id);
        Friend editFriend = null;

        for (Friend friend : friends){
            if (friend.getId().equals(id)) {
                editFriend = friend;
                break;
            }
        }

        //System.out.println("editFriend : " + editFriend);

        model.addAttribute("editFriend", editFriend);
        return "editFriendForm";
    }

    // 친구 정보 수정!
    @PostMapping("/friend/edit")
    String editFriend(@Valid @ModelAttribute("editFriend") Friend editFriend, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors())
            return "editFriendForm";

        // List는 불변객체이기에 다시 초기화해줘야 한다! - 수정된 값 적용을 위해..
        List<Friend> updatedFriends = new ArrayList();


        for (int i = 0; i < friends.size(); i++){
            Friend friend = friends.get(i);

            if (friend.getId().equals(editFriend.getId())){
                updatedFriends.set(i, editFriend); // 수정된 친구 객체로 수정해줘야 한다!!!!
                break;
            }
        }

        for (Friend friend : updatedFriends){
            System.out.println(friend);
        }
        // 수정된 모델 리스트를 다시 모델에 추가해준다.
        model.addAttribute("friends", updatedFriends);
        return "friendList"; // edit 성공하면, 다시 수정된 친구 리스트를 보여줘야겠지요.
    }
}
