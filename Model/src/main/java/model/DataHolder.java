package model;

import DTO.UserDataDTO;

@FunctionalInterface
public interface DataHolder {

    UserDataDTO loadUserData(User user);

}
