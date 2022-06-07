package de.qhun.stackoverflow.spring_boot_mongo_domain_access_layer.repository;

import de.qhun.stackoverflow.spring_boot_mongo_domain_access_layer.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
}
