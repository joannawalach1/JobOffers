package com.juniorjavaready.domain.LoginAndRegister;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
public class User {
    private int id;
    private String username;
    private String password;
}
