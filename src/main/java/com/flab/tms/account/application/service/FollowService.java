package com.flab.tms.account.application.service;

import com.flab.tms.account.application.port.in.FollowUseCase;
import com.flab.tms.account.application.port.out.FollowPort;
import com.flab.tms.account.application.port.out.LoadAccountPort;
import com.flab.tms.account.domain.Account;
import com.flab.tms.account.domain.Follow;
import com.flab.tms.account.domain.Follows;
import java.util.Optional;

public class FollowService implements FollowUseCase {

    private LoadAccountPort loadAccountPort;
    private FollowPort followPort;

    public Follows getFollowers(String targetAccount) {
        Account account = checkAccountExist(targetAccount);
        Follows followers = followPort.getFollowers(account.getAccountId());
        return followers;
    }

    public Follows getFollowings(String sourceAccount) {
        Account account = checkAccountExist(sourceAccount);
        Follows followers = followPort.getFollowings(account.getAccountId());
        return followers;
    }

    public void following(String sourceAccountId, String targetAccountId) {
        Account sourceAccount = loadAccountPort.loadAccount(sourceAccountId);
        Account targetAccount = checkAccountExist(targetAccountId);
        Follow follow = new Follow(sourceAccount.getAccountId(), targetAccount.getAccountId());
        followPort.follow(follow);
        boolean result = sourceAccount.getActivity().getFollowings().followingStateUpdate(follow);
    }

    public void unFollowing(String sourceAccountId, String targetAccountId) {
        Account sourceAccount = loadAccountPort.loadAccount(sourceAccountId);
        Account targetAccount = checkAccountExist(targetAccountId);
        Follow follow = new Follow(sourceAccount.getAccountId(), targetAccount.getAccountId());
        followPort.unfollow(follow);
        boolean result = sourceAccount.getActivity().getFollowings().unFollowingStateUpdate(follow);
    }

    private Account checkAccountExist(String accountId) {
        Account account = loadAccountPort.loadAccount(accountId);
        Optional.ofNullable(account.getAccountId())
                .orElseThrow(() -> new IllegalStateException("This Id is not exist. Please check an Id"));
        return account;
    }

}
