package cashdesk.controller.commands.product;

import cashdesk.controller.commands.Command;
import cashdesk.model.entity.Product;
import cashdesk.model.entity.Users;
import cashdesk.model.srvice.ProductService;
import cashdesk.utils.Regex;

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


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codeStr = request.getParameter("code");
        String priceStr = request.getParameter("price");
        if (!Regex.isNumberCorrect(codeStr)) {
            request.setAttribute("code_error_message", "Invalid code");
            showError(request, response);
            return;
        }
        if (!Regex.isNumberCorrect(priceStr)) {
            request.setAttribute("price_error_message", "Invalid price");
            showError(request, response);
            return;
        }
        int code = Integer.parseInt(codeStr);
        String name = request.getParameter("name");
        if(name==null||name.equals("")){
            request.setAttribute("name_error_message", "Put in the name");
            showError(request, response);
            return;
        }
        BigDecimal price = BigDecimal.valueOf(Long.parseLong(priceStr));
        Users user = (Users) ((HttpServletRequest) request).getSession().getAttribute("user");
        Product product = new Product();

        try {
            productService.create(product);
        } catch (SQLException e) {
            request.setAttribute("sql_error_message", "Database problem: " + e.getMessage());
            showError(request, response);
            return;
        }

    }

    private void showError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductListCommand listCommand = new ProductListCommand(productService);
        listCommand.execute(request, response);
    }
}
