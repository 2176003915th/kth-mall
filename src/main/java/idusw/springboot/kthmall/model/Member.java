package idusw.springboot.kthmall.model;

import lombok.*;
//boilerplate code: 사용구 코드

//어노테이션 : 컴파일러에게 처리를 요청하는 부연설명 vs. Comment : 주석 소스코드 설명


@Data //@Getter @Setter @EqualsAndHashCode @RequiredArgsConstructor
// @NoArgsConstructor @AllArgsConstructor
@Builder //Design Pattern 중 하나로 생성자 명확성을 제공함
public class Member {
    private Long idx;
    private String id;
    private String pw;
    private String name;
    private String email;
}
