package com.flab.tms.account.application.port.out;

import com.flab.tms.account.domain.Account;

public interface AccountManagePort {

    void createAccount(Account account);
}
