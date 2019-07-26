package cashdesk.model;

import java.util.Objects;

public class Users {
    private String userLogin;
    private String userPassword;

    public Users(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(userLogin, users.userLogin) &&
                Objects.equals(userPassword, users.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLogin, userPassword);
    }

    @Override
    public String toString() {
        return "Users{" +
                "userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
