package com.flab.tms.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Activity {

    private String accountId;
    private Follows followers;
    private Follows followings;

}
