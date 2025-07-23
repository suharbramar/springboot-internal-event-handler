# Spring Boot Internal Event Handler (Async)

This project demonstrates how to handle internal application events in a Spring Boot 3.5.3 app using `@EventListener` and `@Async`.

## Features
- Decoupled event publishing and handling
- Asynchronous event processing
- Uses `ApplicationEventPublisher` and `@Async` listener

## How to Run

```bash
curl -X POST http://localhost:8080/orders/12345

To verify the Asynchronous event handling, check the logs for the thread [task-xxx] not the one handling the HTTP request [http-nio-xxx].

```
