package com.wechap.wechap.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String pw;
    private String name;
    private String alias;
    private String email;
}
