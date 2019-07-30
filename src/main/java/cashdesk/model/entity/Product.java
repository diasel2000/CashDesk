package cashdesk.model.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private Integer id;
    private int code;
    private String productName;
    private BigDecimal price;

    public Product(Integer id, int code, String productName, BigDecimal price) {
        this.id = id;
        this.code = code;
        this.productName = productName;
        this.price = price;
    }

    public Product() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return code == product.code &&
                Objects.equals(id, product.id) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, productName, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code=" + code +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
