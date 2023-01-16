package com.flab.tms.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public final class Account{

    private String accountId;
    private String password;
    private String lastName;
    private String firstName;
    private String phone;
    private String email;
    private LocalDateTime birth;
    private Gender gender;
    private String address;
    private Activity activity;

   public enum Gender{
        Male,
        Female
   }
}
