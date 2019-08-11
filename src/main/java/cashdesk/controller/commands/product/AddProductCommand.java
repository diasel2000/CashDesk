package cashdesk.controller.commands.product;

import cashdesk.controller.commands.Command;
import cashdesk.controller.commands.user.LoginUsersCommand;
import cashdesk.model.entity.Product;
import cashdesk.model.entity.Users;
import cashdesk.model.srvice.ProductService;
import cashdesk.utils.Regex;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

public class AddProductCommand implements Command {
    private ProductService productService;

    public AddProductCommand(ProductService productService) {
        this.productService = productService;
    }
    private static final Logger LOGGER = LogManager.getLogger(AddProductCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String code = request.getParameter("code");
        String priceStr = request.getParameter("price");
        String name = request.getParameter("name");

        if (code==null||code.equals("")||!Regex.isNumberCorrect(code)) {
            request.setAttribute("code_error_message", "Invalid code");
            forward(request, response, "/secured/supervisor/supervisor.jsp");
            return;
        }
        if (Regex.isCodeCorrect(code)) {
            request.setAttribute("code", "Code must be number");
            forward(request, response, "/secured/supervisor/supervisor.jsp");
            return;
        }
        if (priceStr==null||priceStr.equals ( "" )||!Regex.isNumberCorrect(priceStr)) {
            request.setAttribute("price_error_message", "Invalid price");
            //forward(request, response, "/secured/supervisor/supervisor.jsp");
            showError(request, response);
        }
        if(name==null||name.equals("")){
            request.setAttribute("name_error_message", "Put in the name");
            showError(request, response);
            //forward(request, response, "/secured/supervisor/supervisor.jsp");
            return;
        }
        try {
            BigDecimal price = BigDecimal.valueOf(Long.parseLong(priceStr));
            productService.create(code,name,price);
        } catch (SQLException e) {
           // request.setAttribute("sql_error_message", "Database problem: " + e.getMessage());
            showError(request, response);
            return;
        }catch (NumberFormatException e){
            request.setAttribute("num_error_message", "Prise format error: " + e.getMessage());
        }
        showError(request, response);
    }
    private void showError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        ProductListCommand listCommand = new ProductListCommand(productService);
        listCommand.execute(request, response);
        LOGGER.debug ( "Error input" );
    }

}
