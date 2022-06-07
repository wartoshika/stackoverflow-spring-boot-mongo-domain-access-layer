package de.qhun.stackoverflow.spring_boot_mongo_domain_access_layer.repository;

import de.qhun.stackoverflow.spring_boot_mongo_domain_access_layer.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findByCustomerId(String customerId);
}
