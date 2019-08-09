package cashdesk.controller.servlets;

import cashdesk.controller.commands.*;
import cashdesk.controller.commands.check.AddCheckCommand;
import cashdesk.controller.commands.check.CheckAddPageCommand;
import cashdesk.controller.commands.check.CheckCommand;
import cashdesk.controller.commands.check.CheckListCommand;
import cashdesk.controller.commands.product.*;
import cashdesk.controller.commands.user.LoginUsersCommand;
import cashdesk.controller.commands.user.LogoutUsersCommand;
import cashdesk.controller.commands.user.RegisterUsersCommand;
import cashdesk.controller.commands.user.UserListCommand;
import cashdesk.model.srvice.CheckService;
import cashdesk.model.srvice.ProductService;
import cashdesk.model.srvice.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Servlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(LoginUsersCommand.class);
    private Map<String, Command> commands = new HashMap<>();
    private ProductService productService = new ProductService();

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        servletConfig.getServletContext().setAttribute("loggedUser", new HashSet<String>());

        commands.put("supervisor/product", new ProductCommand(new ProductService()));
        commands.put("supervisor/products", new ProductListCommand(new ProductService()));
        commands.put("supervisor/addProduct", new AddProductCommand(new ProductService()));
        commands.put("supervisor/editProduct", new EditProductCommand(new ProductService()));
        commands.put("supervisor/deleteProduct", new DeleteProductCommand(new ProductService()));
        commands.put("users-login", new LoginUsersCommand(new UserService()));
        commands.put("logout", new LogoutUsersCommand());
        commands.put("users-register", new RegisterUsersCommand(new UserService()));
        commands.put("exception", new ExceptionCommand());
        commands.put("cashier/check", new CheckCommand(new CheckService()));
        commands.put("cashier/checks", new CheckListCommand(new CheckService()));
        commands.put("cashier/checks/addPage", new CheckAddPageCommand(new ProductService()));
        commands.put("cashier/checks/add", new AddCheckCommand(new CheckService()));
        commands.put("supervisor", new SupervisorCommand());
        commands.put("adminCaisher/users", new UserListCommand(new UserService()));
        //commands.put("admin/users/edit", new EditUsersCommand(new UserService()));
        commands.put("adminCaisher", new SeniorCaisherCommand());
        commands.put("cashier", new CaisherCommand());
    }
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = request.getRequestURI();
        path = path.replaceAll(".*/key/" , "");
        Command command = commands.containsKey(path) ? commands.get(path) : commands.get("/index.jsp");
        try {
            command.execute(request, response);
        } catch (SQLException e) {
           LOGGER.debug ( "SQL Exception in Servlet: ", e);
        } catch (NullPointerException e){
            LOGGER.debug ( "Redirect: ", e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }
}
