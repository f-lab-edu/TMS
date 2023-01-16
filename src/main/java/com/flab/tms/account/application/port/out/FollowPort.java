package com.flab.tms.account.application.port.out;

import com.flab.tms.account.domain.Follow;
import com.flab.tms.account.domain.Follows;

public interface FollowPort {

    void follow(Follow follow);
    void unfollow(Follow follow);
    Follows getFollowings(String sourceAccountId);
    Follows getFollowers(String targetAccountId);

}
