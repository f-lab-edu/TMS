package com.flab.tms.account.application.port.in;

import com.flab.tms.account.domain.Account.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public final class WebAccountModel {

    private final String accountId;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final String email;
    private final LocalDateTime birth;
    private final Gender gender;
    private final String address;

}
