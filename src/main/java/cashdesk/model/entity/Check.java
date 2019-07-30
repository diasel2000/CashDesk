package cashdesk.model.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Check {
    private int id;
    private int quantity;
    private BigDecimal priceSum;

    public Check(int id,  int quantity, BigDecimal priceSum) {
        this.id = id;
        this.quantity = quantity;
        this.priceSum = priceSum;
    }

    public Check() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(BigDecimal priceSum) {
        this.priceSum = priceSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return id == check.id &&
                quantity == check.quantity &&
                Objects.equals(priceSum, check.priceSum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, priceSum);
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", priceSum=" + priceSum +
                '}';
    }
}
