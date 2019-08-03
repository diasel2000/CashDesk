package cashdesk.model.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Check {
    private int id;
    private int quantity;
    private BigDecimal priceSum;
    private List<Product> products;
    private int productId;

    public Check(int id, int quantity, BigDecimal priceSum, List<Product> products, int productId) {
        this.id = id;
        this.quantity = quantity;
        this.priceSum = priceSum;
        this.products = products;
        this.productId = productId;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return id == check.id &&
                quantity == check.quantity &&
                productId == check.productId &&
                Objects.equals(priceSum, check.priceSum) &&
                Objects.equals(products, check.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, priceSum, products, productId);
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", priceSum=" + priceSum +
                ", products=" + products +
                ", productId=" + productId +
                '}';
    }
}
