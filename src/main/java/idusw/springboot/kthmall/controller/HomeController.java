package idusw.springboot.kthmall.controller;

import idusw.springboot.kthmall.model.Member;
import idusw.springboot.kthmall.service.HomeService;
import idusw.springboot.kthmall.service.HomeServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private HomeService homeService = new HomeServiceImpl();
//    public HomeController(HomeService homeService){ // loosely-coupled <- Ioc Container, DI
//        this.homeService = homeService;
//    }
    @GetMapping("/")
    public String getRoot()
    { homeService.sayHello();
        //model : dto(data transfer obnject)
        //model -> service 호출 코드 -> repository -> service -> controller -> view
        return "main/index";
    }


    @GetMapping("/2")
    public String goIndex2(Model model, HttpServletRequest request){
        Member member = new Member();
        member.setId("kth");
        member.setName("김태형");
        member.setEmail("1@naver.com");

        model.addAttribute("attr","객체의 속성값");
        model.addAttribute("no","a202012007");
        request.setAttribute("myName","김태형");
        model.addAttribute("member", member);
        return "main/index2";
    }
}
