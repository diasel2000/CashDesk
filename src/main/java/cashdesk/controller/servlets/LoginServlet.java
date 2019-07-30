package cashdesk.controller.servlets;

import cashdesk.dao.impl.JDBCDaoFactory;
import cashdesk.dao.impl.JDBCUserDAO;
import cashdesk.dao.mapper.UserMaper;
import cashdesk.model.entity.Users;
import cashdesk.service.UsersService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

public class LoginServlet extends HttpServlet {
    public LoginServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String login = request.getParameter("username");
        String password = request.getParameter("password");

        Users loginBean = new Users();

        loginBean.setLogin(login);
        loginBean.setPassword(password);

        UsersService loginDao = new UsersService();

        try
        {
            String userValidate = loginDao.

            if(userValidate.equals("Admin_Role"))
            {
                System.out.println("Admin's Home");

                HttpSession session = request.getSession(); //Creating a session
                session.setAttribute("Admin", login); //setting session attribute
                request.setAttribute("userName", login);

                request.getRequestDispatcher("/JSP/Admin.jsp").forward(request, response);
            }
            else if(userValidate.equals("Editor_Role"))
            {
                System.out.println("Editor's Home");

                HttpSession session = request.getSession();
                session.setAttribute("Editor", login);
                request.setAttribute("userName", login);

                request.getRequestDispatcher("/JSP/Editor.jsp").forward(request, response);
            }
            else if(userValidate.equals("User_Role"))
            {
                System.out.println("User's Home");

                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(10*60);
                session.setAttribute("User", login);
                request.setAttribute("userName", login);

                request.getRequestDispatcher("/JSP/User.jsp").forward(request, response);
            }
            else
            {
                System.out.println("Error message = "+userValidate);
                request.setAttribute("errMessage", userValidate);

                request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
            }
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
    }
}
