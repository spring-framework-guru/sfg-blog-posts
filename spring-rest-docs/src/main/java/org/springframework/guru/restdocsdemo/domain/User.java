package org.springframework.guru.restdocsdemo.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Getter
@Setter
public class User {
    private int userId;
    private String userName;
    private String email;
}
