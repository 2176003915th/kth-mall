package idusw.springboot.kthmall.repository;

import idusw.springboot.kthmall.entity.MemberEntity;
import idusw.springboot.kthmall.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface MemberRepository extends JpaRepository<MemberEntity, Long>{

        Optional<MemberEntity> findByIdAndPw(String id, String pw);

    //    @Query("select m from MemberEntity m where m.id = :id and m.pw = :pw")
//    MemberEntity getMemberEntityById(@Param("id")String id, @Param("pw") String pw);
}
