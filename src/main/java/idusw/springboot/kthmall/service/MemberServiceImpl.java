package idusw.springboot.kthmall.service;

import idusw.springboot.kthmall.entity.MemberEntity;
import idusw.springboot.kthmall.model.Member;
import idusw.springboot.kthmall.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{
    final MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public int create(Member member) {
        MemberEntity entity = dtoToEntity(member);
        if(memberRepository.save(entity) != null)
            return 1;
        else
            return 0;
    }

    @Override
    public Member readByIdx(Long idx) {
        memberRepository.findById(idx);
        return null;
    } //loginById와 매우흡사함

    @Override
    public List<Member> readAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<Member> memberList = new ArrayList<>();
        for(MemberEntity me : memberEntityList){
            memberList.add(entityToDto(me));
        }

        return memberList;
    }

    @Override
    public int update(Member member) {
        return 0;
    }

    @Override
    public int delete(Member member) {
        return 0;
    }

    @Override
    public Member loginById(Member member) {
        //null 처리를 하여서 NullPointerException 방지를 목적으로함
        Optional<MemberEntity> memberOp = memberRepository.findByIdAndPw(member.getId(), member.getPw());
        if (memberOp.isPresent()) {
            return entityToDto(memberOp.get());
        } else {
            return null;
        }
    }
}
