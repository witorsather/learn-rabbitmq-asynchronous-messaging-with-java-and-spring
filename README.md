# RabbitMQ Messaging

A Spring Boot application with RabbitMQ that interacts with two separate projects, `rabbit-listener-project` and `rabbit-producer-project`, to provide messaging functionalities.

## Features

- **Message Production and Consumption:** Easily send and receive messages between the `rabbit-listener-project` and `rabbit-producer-project`.
- **AMQP Protocol:** Utilizes the AMQP protocol for message communication.

## Technologies Used

- **Spring Boot:** Java application development with Spring Boot.
- **RabbitMQ:** An open-source messaging system that supports the AMQP protocol.

## Project Structure

The application is divided into two projects:

1. **rabbit-listener-project:** This project is responsible for listening to the messages sent by the producer.
2. **rabbit-producer-project:** This project is responsible for producing and sending messages to the listener.

## API Reference

This application uses the RabbitMQ API to get message information. Official Documentation.

## How to Install and Run the Projects

1. **Clone the repository:**
    ```bash
    git clone https://github.com/witorsather/rabbitmq-messaging-app.git
    ```

2. **Navigate to the directory of each project and install the project dependencies:**
    ```bash
    cd rabbit-listener-project
    mvn install
    cd ..
    cd rabbit-producer-project
    mvn install
    ```

3. **Start each application:**
    ```bash
    cd rabbit-listener-project
    mvn spring-boot:run
    cd ..
    cd rabbit-producer-project
    mvn spring-boot:run
    ```

Remember to adjust the versions in the instructions as necessary, as versions may be updated.

## Contribution

Contributions are welcome! Follow these steps to contribute:

1. Fork the repository.
2. Create a new branch for your feature.
3. Make your changes and commit.
4. Submit a pull request detailing your changes.

## License

This project is licensed under the MIT License.
