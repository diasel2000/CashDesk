package cashdesk.controller.commands.check;

import cashdesk.controller.commands.Command;
import cashdesk.model.entity.Check;
import cashdesk.model.entity.Product;
import cashdesk.model.entity.Users;
import cashdesk.model.srvice.CheckService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddCheckCommand implements Command {
    private CheckService checkService;

    public AddCheckCommand(CheckService checkService) {
        this.checkService = checkService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Check check = new Check();
        BigDecimal totalPrice = BigDecimal.valueOf(0);
        int i = 1;

        List<Product> products = new ArrayList<Product>();
        int id_product = 0;
        String name = "";
        BigDecimal price = null;
        int managerId;
        Users manager;
        int number;
        Product product = new Product (  );
        product.setId ( id_product );
        product.setProductName ( name );
        product.setPrice ( price );



        while (request.getParameter("id_product" + i) != null) {
            id_product = Integer.parseInt(request.getParameter("id_product" + i));
            name = request.getParameter("name" + i);
            managerId = Integer.parseInt(request.getParameter("manager" + i));
            manager = new Users();
            manager.setId(managerId);
            price = BigDecimal.valueOf(Long.parseLong(request.getParameter("priceToAdd" + i)));

        }

        check.setPriceSum(totalPrice);
      //  check.setCashierId((Users) ((HttpServletRequest) request).getSession().getAttribute("loggedIn"));
        check.setProducts(products);


        try {
            checkService.create(check);
        } catch (SQLException e) {
            request.setAttribute("sql_error_message", "Database problem: " + e.getMessage());
            CheckListCommand checkListCommand = new CheckListCommand(checkService);
            checkListCommand.execute(request, response);
            return;
        }
    }
}
