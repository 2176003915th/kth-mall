package idusw.springboot.kthmall.service;

import idusw.springboot.kthmall.entity.MemberEntity;
import idusw.springboot.kthmall.model.Member;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MemberService {
    int create(Member member);
    Member readByIdx(Long idx);
    List<Member> readAll();
    int update(Member member);
    int delete(Member member);

    Member loginById(Member member); // id / pw 활용


    default MemberEntity dtoToEntity(Member member) {
        MemberEntity entity = MemberEntity.builder()
                .idx(member.getIdx())
                .id(member.getId())
                .pw(member.getPw())
                .name(member.getName())
                .email(member.getEmail())
                .build();
        return entity;
    }

    default Member entityToDto(MemberEntity memberEntity){
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
