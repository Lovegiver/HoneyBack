package com.citizenweb.tooling.honeyback.core.domain.model;

import com.citizenweb.tooling.honeyback.core.domain.DTO.UserDataDTO;

@FunctionalInterface
public interface DataHolder {

    UserDataDTO loadUserData(User user);

}
