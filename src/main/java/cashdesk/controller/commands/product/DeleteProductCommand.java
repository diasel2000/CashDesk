package cashdesk.controller.commands.product;

import cashdesk.controller.commands.Command;
import cashdesk.model.srvice.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteProductCommand implements Command {
    private ProductService productService;

    public DeleteProductCommand(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String code = request.getParameter ( "dcode" );
        try {
            productService.delete ( code );
            showError ( request, response );
        } catch (SQLException e) {
            request.setAttribute ( "sql_error_message", "Database problem: " + e.getMessage () );
            ProductListCommand listCommand = new ProductListCommand ( productService );
            listCommand.execute ( request, response );
            return;
        }
    }

    private void showError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        ProductListCommand listCommand = new ProductListCommand ( productService );
        listCommand.execute ( request, response );

    }
}
