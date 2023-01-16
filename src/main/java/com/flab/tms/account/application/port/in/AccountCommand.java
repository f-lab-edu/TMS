package com.flab.tms.account.application.port.in;

import com.flab.tms.common.SelfValidating;
import com.flab.tms.account.domain.Account;
import lombok.EqualsAndHashCode;
import lombok.Value;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Value
@EqualsAndHashCode(callSuper = false)
public final class AccountCommand extends SelfValidating<AccountCommand> {

    @NotNull private final String accountId;
    @NotNull private final String password;
    @NotNull private final String firstName;
    @NotNull private final String lastName;
    private final String phone;
    private final String email;
    @NotNull private final LocalDateTime birth;
    private final Account.Gender gender;
    private final String address ;

    public AccountCommand(WebAccountModel model) {
        this.accountId = model.getAccountId();
        this.password = model.getPassword();
        this.firstName = model.getFirstName();
        this.lastName = model.getLastName();
        this.phone = model.getPhone();
        this.email = model.getEmail();
        this.birth = model.getBirth();
        this.gender = model.getGender();
        this.address = model.getAddress();
        this.validateSelf();
    }

}
