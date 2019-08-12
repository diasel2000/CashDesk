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
import java.util.List;

public class ProductListCommand implements Command {
    private ProductService productService;
    private Object object;
    public ProductListCommand(ProductService productService) {
        this.productService = productService;
    }

    private static final Logger LOGGER = LogManager.getLogger(ProductListCommand.class);


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Product> products = productService.getAllProducts ();
        request.setAttribute ( "products",products );
        forward(request, response, "/secured/supervisor/supervisor.jsp");
    }
}

