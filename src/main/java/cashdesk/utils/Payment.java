package cashdesk.utils;


import java.math.BigDecimal;

/**
 * multiply int and BigDecimal
 *
 * @author Anatolii Huzov
 * @version 1.0
 */
public class Payment{
    BigDecimal itemCost  = BigDecimal.ZERO;
    BigDecimal totalCost = BigDecimal.ZERO;

    public BigDecimal calculateCost(int itemQuantity, BigDecimal itemPrice)
    {
        itemCost  = itemPrice.multiply(new BigDecimal(itemQuantity));
        totalCost = totalCost.add(itemCost);
        return totalCost;
    }
    }

