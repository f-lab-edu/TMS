package com.flab.tms.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Follow {

    private String sourceAccountId;
    private String targetAccountId;

}
