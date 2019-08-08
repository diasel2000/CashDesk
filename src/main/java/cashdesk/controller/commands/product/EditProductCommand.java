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
        //String name = request.getParameter("name");
        boolean isSoldByWeight = Boolean.parseBoolean(request.getParameter("soldByWeight"));
        long price = Long.parseLong(priceStr);
        Users user = (Users) ((HttpServletRequest) request).getSession().getAttribute("user");
//        Product product = new Product.Builder(code)
//                .productName(name)
//                .isSoldByWeight(isSoldByWeight)
//                .price(price)
//                .byManager(user)
//                .build();
//        if (isSoldByWeight) {
//            String weightStr = request.getParameter("weight");
//            if (!Regex.isNumberCorrect(weightStr)) {
//                request.setAttribute("weight_error_message", "Invalid price");
//                showError(request, response);
//                return;
//            }
//            long weight = Long.parseLong(weightStr);
//            product.setWeight(weight);
//        } else {
//            String numberStr = request.getParameter("number");
//            if (!Regex.isNumberCorrect(numberStr)) {
//                request.setAttribute("number_error_message", "Invalid number");
//                showError(request, response);
//                return;
//            }
//            int number = Integer.parseInt(numberStr);
//            product.setNumber(number);
//        }
//        try {
//            productService.update(product);
//        } catch (SQLException e) {
//            request.setAttribute("sql_error_message", "Database problem: " + e.getMessage());
//            ProductListCommand listCommand = new ProductListCommand(productService);
//            listCommand.getAllProducts(request, response);
//            return;
//        }
    }
    private void showError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductListCommand listCommand = new ProductListCommand(productService);
        listCommand.execute(request, response);
    }
}
