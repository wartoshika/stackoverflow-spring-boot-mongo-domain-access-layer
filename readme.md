# Spring repository access within the domain layer for MongoDB

This repository is a show case how a persistent layer can simply be accessed by a domain object.

> Please do not consider this example a best practice work, the target is to get a working solution and derive your own implementation from it

Relevant Stackoverflow Question is [here](https://stackoverflow.com/questions/72531864).

## Dependencies

- Some IDE
- Maven
- Internet Connection for the embedded MongoDB

## How to use it

1. Clone repository
2. Load this project into your favorite IDE
3. Run the main method in `de.qhun.stackoverflow.spring_boot_mongo_domain_access_layer.Application`

## Expected result

This text can be found within the console log when the application runs. It stops automatically when these results are printed.

```text
Saved customer Customer(id=629f8406182b74797eb619a9, displayName=John Doe)
Saved order Order(id=629f8406182b74797eb619aa, quality=3, price=17.58)
Saved order Order(id=629f8406182b74797eb619ab, quality=2, price=59.58)
There are 2 orders
There are 1 customers
Listing order ids of customer John Doe: 629f8406182b74797eb619aa, 629f8406182b74797eb619ab
```

## Idea

The core idea how the access of repositories within the domain layer can be achieved is the `ApplicationContextHolder`. This class
implements the `ApplicationContextAware` interface with tells Spring to feed it the `ApplicationContext`.

Having the `ApplicationContext` statically accessible a domain object may get it just by calling the relevant getter method. This context
provides possibilities to get any bean of the Spring context (including `MongoRepository` classes).

By declaring an abstract class `DomainObject` the implementing classes just need to know the concrete repository and this `DomainObject` will
provide read or write access to the database.