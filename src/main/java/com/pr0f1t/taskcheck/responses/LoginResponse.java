package com.pr0f1t.taskcheck.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class LoginResponse {

    private String token;

}
