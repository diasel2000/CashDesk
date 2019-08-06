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
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Check check = new Check();
        long totalPrice = 0;
        int i = 1;

        List<Product> products = new ArrayList<Product>();
        int code;
        String name;
        boolean isSoldByWeight;
        long price;
        int managerId;
        Users manager;
        int number;
        long weight;


        while (request.getParameter("code" + i) != null) {
            code = Integer.parseInt(request.getParameter("code" + i));
            name = request.getParameter("name" + i);
            managerId = Integer.parseInt(request.getParameter("manager" + i));
            manager = new Users();
            manager.setId(managerId);
            price = (long)Double.parseDouble(request.getParameter("priceToAdd" + i));
            totalPrice += price;
            isSoldByWeight = Boolean.parseBoolean(request.getParameter("soldByWeight" + i));

            Product product = new Product.Builder(code)
                    .productName(name)
                    .isSoldByWeight(isSoldByWeight)
                    .price(price)
                    .byManager(manager)
                    .build();
            if (isSoldByWeight) {
                weight = Long.parseLong(request.getParameter("weightToAdd" + i));
                product.setWeight(weight);
            } else {
                number = Integer.parseInt(request.getParameter("numberToAdd" + i));
                product.setNumber(number);
            }
            product.setCheck(check);
            products.add(product);
            i++;
        }

        check.setTotalPrice(totalPrice);
        check.setCashier((Users) ((HttpServletRequest) request).getSession().getAttribute("user"));
        Shift shift = new Shift();
        //TODO shift handling
        shift.setId(1);
        check.setShift(shift);
        check.setProducts(products);
        Timestamp time = new Timestamp(new Date().getTime());
        check.setCreateTime(time);
        check.setId(check.hashCode());

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
