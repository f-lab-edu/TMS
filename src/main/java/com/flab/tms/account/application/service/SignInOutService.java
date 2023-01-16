package com.flab.tms.account.application.service;


import com.flab.tms.account.application.port.in.SignInOutCommand;
import com.flab.tms.account.application.port.in.SignInOutUseCase;
import com.flab.tms.account.application.port.out.LoadAccountPort;
import com.flab.tms.account.domain.Account;
import lombok.RequiredArgsConstructor;
import java.util.Optional;

@RequiredArgsConstructor
public class SignInOutService implements SignInOutUseCase {
    private final LoadAccountPort loadAccountPort;

    @Override
    public boolean SignIn(SignInOutCommand command) {
        checkSignInRule(command);
        return true;
    }

    @Override
    public boolean SignOut() {
        return false;
    }

    public Account loadAccount(String account) {
        return loadAccountPort.loadAccount(account);
    }

    private void checkSignInRule(SignInOutCommand command) {
        Account account = loadAccount(command.getId());

        String AccountId = Optional.ofNullable(account.getAccountId())
                .orElseThrow(() -> new IllegalStateException("This Id is not exist. Please check an Id"));

        if(!account.getPassword().equals(command.getPassword()))
            throw new IllegalStateException("This password is not correct in this Id. Please check a password");

    }


}
