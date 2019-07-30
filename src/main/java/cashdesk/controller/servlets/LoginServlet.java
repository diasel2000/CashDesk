package cashdesk.controller.servlets;

import cashdesk.model.dao.interfaces.LoginDAO;
import cashdesk.model.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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

        LoginDAO loginDao = new LoginDAO();

        try
        {
            String userValidate = loginDao.authenticateUser(loginBean);

            if(userValidate.equals("Caisher_Role"))
            {
                System.out.println("Caisher's Home");

                HttpSession session = request.getSession(); //Creating a session
                session.setAttribute("Caisher", login); //setting session attribute
                request.setAttribute("userName", login);

                request.getRequestDispatcher("/secured/caisher/caisher.jsp").forward(request, response);
            }
            else if(userValidate.equals("SeniorCaisher_Role"))
            {
                System.out.println("SeniorCaisher's Home");

                HttpSession session = request.getSession();
                session.setAttribute("SeniorCaisher", login);
                request.setAttribute("userName", login);

                request.getRequestDispatcher("/secured/seniorcaisher/seniorcaisher.jsp").forward(request, response);
            }
            else if(userValidate.equals("Supervisor_Role"))
            {
                System.out.println("Supervisor's Home");

                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(10*60);
                session.setAttribute("Supervisor", login);
                request.setAttribute("userName", login);

                request.getRequestDispatcher("/secured/supervisor/supervisor.jsp").forward(request, response);
            }
            else
            {
                System.out.println("Error message = "+userValidate);
                request.setAttribute("errMessage", userValidate);

                request.getRequestDispatcher("/public/login.jsp").forward(request, response);
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
