package com.flab.tms.account.application.port.in;

import com.flab.tms.account.domain.Follows;

public interface FollowUseCase {

    public Follows getFollowers(String targetAccount);
    public Follows getFollowings(String sourceAccount);
    public void following(String sourceAccountId, String targetAccountId);
    public void unFollowing(String sourceAccountId, String targetAccountId);

}
