package cashdesk.controller.commands.product;

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

public class ProductCommand implements Command {
    private ProductService productService;

    public ProductCommand(ProductService productService) {
        this.productService = productService;
    }

    private static final Logger LOGGER = LogManager.getLogger ( ProductCommand.class );

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter ( "id_product" );

        try {
            Product product = productService.getProductById ( code );
            request.setAttribute ( "product", product );
        } catch (SQLException e) {
            LOGGER.debug ( "Database error when requesting product " + code );
            request.setAttribute ( "sql_error_message", "Database problem: " + e.getMessage () );
        }
    }
}
