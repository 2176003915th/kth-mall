package idusw.springboot.kthmall.controller;

import idusw.springboot.kthmall.model.Member;
import idusw.springboot.kthmall.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {
    final MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("members/{id}")
    public String getById(@PathVariable("id") String id, Model model) {
        Member member = Member.builder().build();
        member.setId(id);

        model.addAttribute("member",member);
        return "/main/index";
    }

    @GetMapping("members/login")
    public String getLogin(Model model, HttpServletRequest request) {
        Member member = Member.builder().build();

//        request.setAttribute("member", member); //<-이건안됨
        model.addAttribute("member",member);

        return "/main/login"; }

    @PostMapping("members/login")
    public String Login(@ModelAttribute("member") Member member, Model model, HttpSession session , HttpServletRequest request) {
        String id = member.getId();
        String pw = member.getPw();

        System.out.println(member.getId());
        System.out.println(member.getPw());

        Member m = Member.builder().id(member.getId()).pw(member.getPw()).build();
        Member ret = memberService.loginById(m);

        String msg = "다시 로그인해주세요";


        if(ret != null){
            session.setAttribute("MemberSession", ret);
            return "redirect:/";
        } else {
            model.addAttribute("loginError", msg);
            return "/main/login";
        }

    }

    @GetMapping("/members/register")
    public String register(Model model) {
        model.addAttribute("member", Member.builder().build()); //폼태그에서 th:object를 쓰기위함
        return "/main/register";
    }

    @PostMapping("/members/register")
    public String register(@ModelAttribute("member") Member member, HttpServletRequest request) {
//        if (아이디 중복처리하는 서비스 != null ) {
//            request.setAttribute("message", "이미 사용 중인 이메일입니다");
//
//        } else {
//            entity 안에 집어넣는 서비스
//
//        }
        return "redirect:/members/login";
    }

    //조회 : idx 라는 유일키 조회, 순번

    @GetMapping("/{idx}")
    public String getMember(@PathVariable("idx") Long idx, Model model) {
        Member ret = memberService.readByIdx(idx);
        model.addAttribute("member", ret);
        return "/main/detail";
    }

    @GetMapping("update")
    public String getUpdate(Model model) {
        model.addAttribute("member", Member.builder().build());
        return "/main/update";
    }

    @PutMapping("update")
    public String getUpdate(@ModelAttribute("member") Member member, Model model , HttpSession session) {
        model.addAttribute("mess","성공");
        return "/main/400";
    }

    @GetMapping("/members/logout")
    public String Logout(HttpSession session) {
        session.invalidate();//세션 회수
        return "redirect:/";
    }

    @GetMapping("/members/list")
    public String getMembers(Model model){
        List<Member> memberList = memberService.readAll();
        if(memberList != null) {
            model.addAttribute("Memberlist", memberList);
            return "/members/list";
        } else {
            return "/main/400";
        }
    }

}

