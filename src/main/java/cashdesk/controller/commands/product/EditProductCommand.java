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
import java.sql.SQLException;

public class EditProductCommand implements Command {
    private ProductService productService;

    public EditProductCommand(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {String codeStr = request.getParameter("code");
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
        boolean isSoldByWeight = Boolean.parseBoolean(request.getParameter("soldByWeight"));
        long price = Long.parseLong(priceStr);
        Users user = (Users) ((HttpServletRequest) request).getSession().getAttribute("user");

    }
    private void showError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductListCommand listCommand = new ProductListCommand(productService);
        listCommand.execute(request, response);
    }
}
