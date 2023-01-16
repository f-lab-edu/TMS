package com.flab.tms.account.application.service;

import com.flab.tms.account.application.port.in.AccountCommand;
import com.flab.tms.account.application.port.in.AccountManagementUseCase;
import com.flab.tms.account.application.port.out.AccountManagePort;
import com.flab.tms.account.application.port.out.LoadAccountPort;
import com.flab.tms.account.domain.Account;
import lombok.RequiredArgsConstructor;
import java.util.Optional;

@RequiredArgsConstructor
public class AccountManagementService implements AccountManagementUseCase {

    private final LoadAccountPort loadAccountPort;
    private final AccountManagePort accountManagePort;

    @Override
    public boolean createAccount(AccountCommand command) {
        checkCreateAccountRule(command);
        Account newAccount = new Account(command.getAccountId(),
                                                    command.getPassword(),
                                                    command.getFirstName(),
                                                    command.getLastName(),
                                                    command.getPhone(),
                                                    command.getEmail(),
                                                    command.getBirth(),
                                                    command.getGender(),
                                                    command.getAddress(),
                                            null);
        accountManagePort.createAccount(newAccount);
        return true;
    }


    @Override
    public boolean updateAccount() {
        return false;
    }

    @Override
    public boolean deleteAccount() {
        return false;
    }


    private void checkCreateAccountRule(AccountCommand command) {
        Optional.ofNullable(loadAccountPort.loadAccount(command.getAccountId()))
                .ifPresent(action -> {throw new IllegalStateException("This Id is already Exist");});

        Optional.ofNullable(loadAccountPort.loadEmail(command.getEmail()))
                .ifPresent(action -> {throw new IllegalStateException("This email is already Exist");});

        //비밀번호 비지니스 로직 넣어야 하나?

        //지역이 존재하지 않음은 어디서 검색?

    }

}
