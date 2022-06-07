package de.qhun.stackoverflow.spring_boot_mongo_domain_access_layer;

import de.qhun.stackoverflow.spring_boot_mongo_domain_access_layer.domain.Customer;
import de.qhun.stackoverflow.spring_boot_mongo_domain_access_layer.domain.Order;
import de.qhun.stackoverflow.spring_boot_mongo_domain_access_layer.repository.CustomerRepository;
import de.qhun.stackoverflow.spring_boot_mongo_domain_access_layer.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application {

    private static final Logger log = Logger.getLogger(Application.class.getName());

    @Bean
    public CommandLineRunner commandLineRunner(OrderRepository orderRepository, CustomerRepository customerRepository) {
        return args -> {

            var customer = new Customer()
                    .displayName("John Doe")
                    .save();
            log.info("Saved customer " + customer);
            var firstOrder = new Order()
                    .category(List.of(3, 5))
                    .price(17.58f)
                    .quality(3)
                    .qualityDescription("Prime")
                    .customer(customer.getId())
                    .save();

            log.info("Saved order " + firstOrder);
            var secondOrder = new Order()
                    .category(List.of(2, 5))
                    .price(59.58f)
                    .quality(2)
                    .qualityDescription("Prime+")
                    .customer(customer.getId())
                    .save();
            log.info("Saved order " + secondOrder);

            log.info("There are " + orderRepository.count() + " orders");
            log.info("There are " + customerRepository.count() + " customers");

            var ordersForCustomer = customer.orders().stream().map(Order::getId).collect(Collectors.joining(", "));
            log.info("Listing order ids of customer " + customer.getDisplayName() + ": " + ordersForCustomer);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
