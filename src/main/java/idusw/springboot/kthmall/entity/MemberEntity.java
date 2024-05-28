package idusw.springboot.kthmall.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity // Spring Data JPA의 엔티티임을 의미함
@Getter
@Setter
@Table(name="member")

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //MySQL, MariaDB의 경우 자동증가하는 필드 IDENTITY, Oracle의 경우 SEQUENCE, AUTO 유동적 선택
    private Long idx;
    @Column(length = 20, nullable = false)
    private String id;
    @Column(length = 20, nullable = false)
    private String pw;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    private String email;
}
