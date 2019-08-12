package cashdesk.controller.commands.check;

import cashdesk.controller.commands.Command;
import cashdesk.model.entity.Product;
import cashdesk.model.srvice.ProductService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CheckAddPageCommand implements Command {
    private ProductService productService;

    public CheckAddPageCommand(ProductService productService) {
        this.productService = productService;
    }
    private static final Logger LOGGER = LogManager.getLogger(CheckAddPageCommand.class);


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sortBy = request.getParameter("tosort");
        if(sortBy==null) {
            getAllProducts(request, response);
        }
        else{
            try {
                List<Product> products = productService.getProducts (sortBy);
                request.setAttribute("products", products);
            } catch (SQLException e) {
                LOGGER.debug("Database error when requesting products");
                request.setAttribute("sql_error_message", "Database problem: " + e.getMessage());
            }
            //forward(request, response, Path.CASHIER_PRODUCT_LIST);
        }
    }

    void getAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Product> products = productService.getAllProducts();
            request.setAttribute("products", products);
        } catch (SQLException e) {
            LOGGER.debug("Database error when requesting products");
            request.setAttribute("sql_error_message", "Database problem: " + e.getMessage());
        }
    }
}
