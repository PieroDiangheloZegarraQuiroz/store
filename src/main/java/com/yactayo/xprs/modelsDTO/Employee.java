package com.yactayo.xprs.modelsDTO;

public class Employee {
    private Integer idEmployee;
    private String names;
    private String surnames;
    private int phone;
    private int docIdentity;
    private Role role;
    private User user;

    public Employee() {
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getDocIdentity() {
        return docIdentity;
    }

    public void setDocIdentity(int docIdentity) {
        this.docIdentity = docIdentity;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + idEmployee +
                ", names='" + names + '\'' +
                ", surnames='" + surnames + '\'' +
                ", phone=" + phone +
                ", docIdentity=" + docIdentity +
                ", role=" + role +
                ", user=" + user +
                '}';
    }
}
