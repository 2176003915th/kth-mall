package idusw.springboot.kthmall.service;

import idusw.springboot.kthmall.entity.MemberEntity;
import idusw.springboot.kthmall.model.Member;
import idusw.springboot.kthmall.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MemberServiceTests {
    // field DI
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Test
    public void loginMember() {
        Optional<MemberEntity> memberOp = memberRepository.findByIdAndPw("kth", "1234");
        if (memberOp.isPresent()) {
            System.out.println("login success");
        } else {
            System.out.println("login fail");
        }
    }

    @Test
    public void registerMember() {
        MemberEntity dto = MemberEntity.builder().
                        id("dream").pw("1234").name("kim").email("comso@naver.com").build();

        if(memberRepository.save(dto) != null)
           System.out.println("register success");
        else
           System.out.println("register fail");
    }

    @Test
    public void readMemberByIdx() {
        Optional<MemberEntity> memberOp = memberRepository.findById(2L);
        if(memberOp.isPresent())
            System.out.println("read success" + memberOp.get());
        else
            System.out.println("read fail");
    }

//    @Test
//    public void listMember() {
//        List<MemberEntity> memberEntityList = memberRepository.findAll();
//        List<Member> memberList = null;
//        for(MemberEntity me : memberEntityList){
//            Member m = entityToDto(me);
//            System.out.println(m.toString());
//        }
//    }

    Member entityToDto(MemberEntity memberEntity){
        Member member = Member.builder()
                .idx(memberEntity.getIdx())
                .id(memberEntity.getId())
                .pw(memberEntity.getPw())
                .name(memberEntity.getName())
                .email(memberEntity.getEmail())
                .build();
        return member;
    }

}
