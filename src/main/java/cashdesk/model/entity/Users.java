package cashdesk.model.entity;

import cashdesk.model.enums.UserRole;

import java.util.Objects;

public class Users {
    private Integer id;
    private String login;
    private String password;
    private String name;
    private String lastName;
    private UserRole role;

    public Users(Integer id, String login, String password, String name, String lastName, UserRole role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.role = role;
    }

    public Users() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(id, users.id) &&
                Objects.equals(login, users.login) &&
                Objects.equals(password, users.password) &&
                Objects.equals(name, users.name) &&
                Objects.equals(lastName, users.lastName) &&
                role == users.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, name, lastName, role);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                '}';
    }
}
