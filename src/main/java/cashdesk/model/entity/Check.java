package cashdesk.model.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Check entity
 *
 * @author Anatolii Huzov
 * @version 1.0
 */
public class Check {
    private int id;
    private BigDecimal priceSum;
    private List<Product> products;
    private String productId;

    public Check(int id, BigDecimal priceSum, List<Product> products, String productId) {
        this.id = id;
        this.priceSum = priceSum;
        this.products = products;
        this.productId = productId;
    }

    public Check() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Check check = (Check) o;
        return id == check.id &&
                productId == check.productId &&
                Objects.equals ( priceSum, check.priceSum ) &&
                Objects.equals ( products, check.products );
    }

    @Override
    public int hashCode() {
        return Objects.hash ( id, priceSum, products, productId );
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", priceSum=" + priceSum +
                ", products=" + products +
                ", productId=" + productId +
                '}';
    }
}
