package org.example.friendexam.controller;

import lombok.RequiredArgsConstructor;
import org.example.friendexam.domain.Friend;
import org.example.friendexam.service.FriendService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/friends")
public class FriendController {
    private final FriendService friendService;

//    @GetMapping
//    public String showFriendsList(Model model){
//        Iterable<Friend> friends = friendService.findAllFriends();
//        model.addAttribute("friends", friends);
//        return "friends/list"; // friends 폴더 밑의 list.html 뷰
//    }

    @GetMapping
    public String showFriendsList(Model model,
          @RequestParam(defaultValue = "1")int page,
          @RequestParam(defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page-1, size);

        Page<Friend> friends = friendService.findAllFriendsWithPage(pageable);
        model.addAttribute("friends", friends);
        model.addAttribute("currentPage", page); // 현재 페이지 값도 보내준다.
        return "friends/list"; // friends 폴더 밑의 list.html 뷰
    }

    // 친구등록폼 -- url 몇게? -- addForm add
    // friends/add -- get -- 폼 보여줘요, post는 등록해줘요..
    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("friend", new Friend());
        // 빈 모델을 넘겨주면, friends/form에서 th:object로 해당 객체를 맏아주고,
        // th:field로 채워줄 것. 그리고 form.html에서 채운 걸 다시 컨트롤러에서 @ModelAttribute로 받을 것
        return "friends/form";
    }

    @PostMapping("/add")
    public String addFriend(@ModelAttribute("friend") Friend friend, RedirectAttributes redirectAttributes){
       //  System.out.println(friend); -- 테스트 결과, 사용자가 폼에 입력한 값이 잘 입력된 것 확인 가능!
        friendService.saveFriend(friend);
        redirectAttributes.addFlashAttribute("message", "친구등록 성공 !!");
        return "redirect:/friends";
    }

    // 특정 id에 해당하는 친구 조회
    @GetMapping("/{id}")
    public String detailFriend(@PathVariable long id, Model model){
        Friend editFriend = friendService.findFriendById(id);
        model.addAttribute("editFriend", editFriend);
        return "friends/detail";
    }

    // delete기능
    @GetMapping("/delete/{id}")
    public String deleteFriend(@PathVariable long id){
        friendService.deleteFriendById(id);
        return "redirect:/friends"; // 다시 친구 목록으로..
    }

    // edit 기능 -- url 2개 필요, 수정 폼 좀 보여줘.. 수정 해줘(re)
    // localhost/friends/edit/{id} -- GET 수정폼
    // localhost/friends/edit/{id} -- Post 수정
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model){
        Friend friend = friendService.findFriendById(id); // 수정 대상 friend
        model.addAttribute("friend", friend);
        return "/friends/edit";
    }

    @PostMapping("/edit")
    public String editFriend(@ModelAttribute("friend") Friend friend){
        friendService.saveFriend(friend); // save는 해당 객체가 없으면 insert, 있다면 update!!
        return "redirect:/friends";
    }

}
