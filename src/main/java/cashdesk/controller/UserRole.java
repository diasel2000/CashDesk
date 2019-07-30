package cashdesk.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserRole {

    private String user;
    private List<String> roles = null;
    private HttpServletRequest realRequest;

    public UserRole(String user, List<String> roles, HttpServletRequest request) {
        super(request);
        this.user = user;
        this.roles = roles;
        this.realRequest = request;
    }

    @Override
    public boolean isUserInRole(String role) {
        if (roles == null) {
            return this.realRequest.isUserInRole(role);
        }
        return roles.contains(role);
    }

    @Override
    public Principal getUserPrincipal() {
        if (this.user == null) {
            return realRequest.getUserPrincipal();
        }

        // Make an anonymous implementation to just return our user
        return new Principal() {
            @Override
            public String getName() {
                return user;
            }
        };
    }
}
