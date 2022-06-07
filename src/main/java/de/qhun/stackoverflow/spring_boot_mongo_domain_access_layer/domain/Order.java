package de.qhun.stackoverflow.spring_boot_mongo_domain_access_layer.domain;

import de.qhun.stackoverflow.spring_boot_mongo_domain_access_layer.repository.OrderRepository;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Document(collection = "orders")
public class Order extends DomainObject<Order, OrderRepository> {

    @Id
    @NotNull
    private String id;

    @NotNull
    private List<Integer> category;

    private Integer quality;

    private String qualityDescription;

    @NotNull
    private Float price;

    @NotNull
    @NotBlank
    private String customerId;

    public Order() {
        super(OrderRepository.class);
    }

    @Override
    public String toString() {
        return "Order(id=" + id + ", quality=" + quality + ", price=" + price + ")";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public List<Integer> getCategory() {
        return category;
    }

    public void setCategory(List<Integer> category) {
        this.category = category;
    }

    public Order category(List<Integer> category) {
        setCategory(category);
        return this;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Order quality(Integer quality) {
        setQuality(quality);
        return this;
    }

    public String getQualityDescription() {
        return qualityDescription;
    }

    public void setQualityDescription(String qualityDescription) {
        this.qualityDescription = qualityDescription;
    }

    public Order qualityDescription(String qualityDescription) {
        setQualityDescription(qualityDescription);
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Order price(Float price) {
        setPrice(price);
        return this;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Order customer(String customerId) {
        setCustomerId(customerId);
        return this;
    }
}
