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
    private final int ROWS_ON_PAGE = 5;


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sortBy = request.getParameter("tosort");
        if (sortBy == null || sortBy.equals("")) {
            sortBy = "code";
        }

        String pageString = request.getParameter("page");
        int page;
        if (pageString == null || pageString.isEmpty()) {
            LOGGER.debug("page = "+ pageString);
            page = 1;
        } else {
            page = Integer.parseInt(pageString);
        }
        int nextPage;
        String nextPageString = request.getParameter("nextPage");
        if ("previous".equals(nextPageString)) {
            nextPage = page - 1;
        } else if ("next".equals(nextPageString)) {
            nextPage = page + 1;
        } else {
            nextPage = page;
        }
        page = nextPage;
        int productAmount;
        try {
            productAmount = productService.getProductCount();
        } catch (SQLException e) {
            LOGGER.debug("Database error when requesting product count");
            request.setAttribute("sql_error_message", "Database problem: " + e.getMessage());
            return;
        }

        int lastPage = productAmount / ROWS_ON_PAGE
                + ((productAmount % ROWS_ON_PAGE) == 0 ? 0 : 1);

            request.setAttribute("tosort", sortBy);
            request.setAttribute("page", page);
            request.setAttribute("lastPage", lastPage);

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
