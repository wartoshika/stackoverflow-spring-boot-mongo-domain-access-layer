package de.qhun.stackoverflow.spring_boot_mongo_domain_access_layer.domain;

import de.qhun.stackoverflow.spring_boot_mongo_domain_access_layer.repository.CustomerRepository;
import de.qhun.stackoverflow.spring_boot_mongo_domain_access_layer.repository.OrderRepository;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Document(collection = "customers")
public class Customer extends DomainObject<Customer, CustomerRepository> {

    @Id
    @NotNull
    private String id;

    @NotNull
    @NotBlank
    private String displayName;

    public Customer() {
        super(CustomerRepository.class);
    }

    @Override
    public String toString() {
        return "Customer(id=" + id + ", displayName=" + displayName + ")";
    }

    public List<Order> orders() {
        return repository(OrderRepository.class).findByCustomerId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Customer displayName(String displayName) {
        setDisplayName(displayName);
        return this;
    }
}
