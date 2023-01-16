package com.flab.tms.account.application.port.in;

public interface SignInOutUseCase {

    boolean SignIn(SignInOutCommand command);
    boolean SignOut();

}
