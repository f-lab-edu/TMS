package com.flab.tms.account.application.port.in;

import com.flab.tms.common.SelfValidating;
import lombok.EqualsAndHashCode;
import lombok.Value;
import javax.validation.constraints.NotNull;

@Value
@EqualsAndHashCode(callSuper = false)
public final class SignInOutCommand extends SelfValidating<SignInOutCommand> {

    @NotNull private final String Id;
    @NotNull private final String password;

    public SignInOutCommand(WebAccountModel model) {
        this.Id = model.getAccountId();
        this.password = model.getPassword();
        this.validateSelf();
    }

}
