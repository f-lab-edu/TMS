package com.flab.tms.account.application.port.out;

import com.flab.tms.account.domain.Account;

public interface LoadAccountPort {

    Account loadAccount(String accountId);

    String loadAccountId(String accountId);

    String loadEmail(String email);

}
