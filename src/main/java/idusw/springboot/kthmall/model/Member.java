package idusw.springboot.kthmall.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private Long idx;
    private String id;
    private String pw;
    private String name;
    private String email;
}
