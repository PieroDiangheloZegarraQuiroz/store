package com.yactayo.xprs.modelsDTO;

public class User {
    private Integer idUser;
    private String email;
    private String password;
    private int flagType;

    public User() {
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFlagType() {
        return flagType;
    }

    public void setFlagType(int flagType) {
        this.flagType = flagType;
    }
}
