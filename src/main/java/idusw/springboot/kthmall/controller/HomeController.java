package idusw.springboot.kthmall.controller;

import idusw.springboot.kthmall.model.Member;
import idusw.springboot.kthmall.service.HomeService;
import idusw.springboot.kthmall.service.HomeServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HomeController {
//    private HomeService homeService = new HomeServiceImpl(); // tightly-coupled//
//    @Autowired //필드주입 : field injection - testing
//    private HomeService homeService;
//    public HomeController(HomeService homeService){ // loosely-coupled <- Ioc Container, DI
//        this.homeService = homeService;
//    }
//

    private HomeService homeService;
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping(value = {"/",""})
    public String goLogin(HttpServletRequest request, Model model){
        return "/main/index";
    }

    @GetMapping("/1")
    public String getRoot(HttpServletRequest request,Model model)
    {
        homeService.sayHello();
        //model : dto(data transfer obnject)
        //model -> service 호출 코드 -> repository -> service -> controller -> view
        model.addAttribute("greeting",request.getParameter("name"));
        return "main/index";
    }


    // /2?name=<value>
    @GetMapping("/2")
    public String goIndex2(@RequestParam Map<String, String> param, Model model, HttpServletRequest request){
        Member member = Member.builder().build();
        member.setId("kth");
        member.setName(param.get("name"));
        member.setEmail(param.get("email"));

        model.addAttribute("attr","객체의 속성값");
        model.addAttribute("no","a202012007");
        request.setAttribute("myName","김태형");
        model.addAttribute("member", member);
        return "main/index2";
    }
}
