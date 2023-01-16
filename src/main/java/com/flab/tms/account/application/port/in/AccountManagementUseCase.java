package com.flab.tms.account.application.port.in;

public interface AccountManagementUseCase {

    boolean createAccount(AccountCommand command);
    boolean updateAccount();
    boolean deleteAccount();
}
