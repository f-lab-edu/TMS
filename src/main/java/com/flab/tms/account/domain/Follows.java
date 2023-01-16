package com.flab.tms.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Follows {

    private List<Follow> follows;
    private Long followsCount;

    public void addFollow(Follow follow) {
        this.follows.add(follow);
    }

    public void removeFollow(Follow follow) {
        this.follows.remove(follow);
    }

    public void plus() {
        this.followsCount++;
    }

    public void minus() {
        this.followsCount--;
    }

    public boolean followingStateUpdate(Follow follow) {
        this.addFollow(follow);
        this.plus();
        return true;
    }

    public boolean unFollowingStateUpdate(Follow follow) {
        this.removeFollow(follow);
        this.minus();
        return true;
    }
}
