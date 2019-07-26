package cashdesk.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Check {
    private int id;
    private int code;
    private  String productName;
    private int quantity;
    private BigDecimal priceSum;

    public Check(int id, int code, String productName, int quantity, BigDecimal priceSum) {
        this.id = id;
        this.code = code;
        this.productName = productName;
        this.quantity = quantity;
        this.priceSum = priceSum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
                code == check.code &&
                quantity == check.quantity &&
                Objects.equals(productName, check.productName) &&
                Objects.equals(priceSum, check.priceSum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, productName, quantity, priceSum);
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", code=" + code +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", priceSum=" + priceSum +
                '}';
    }
}
