<br />
<div align="center">
<h3 align="center">PRAGMA POWER-UP</h3>
  <p align="center">
    In this challenge you are going to design the backend of a system that centralizes the services and orders of a restaurant chain that has different branches in the city.
  </p>
</div>

### Built With

* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
* ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
* ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
* ![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)


<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these steps.

### Prerequisites

* JDK 17 [https://jdk.java.net/java-se-ri/17](https://jdk.java.net/java-se-ri/17)
* Gradle [https://gradle.org/install/](https://gradle.org/install/)
* MySQL [https://dev.mysql.com/downloads/installer/](https://dev.mysql.com/downloads/installer/)

### Recommended Tools
* IntelliJ Community [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/)
* Postman [https://www.postman.com/downloads/](https://www.postman.com/downloads/)

### Installation

1. Clone the repository
2. Change directory
   ```sh
   cd power-up-arquetipo-v3
   ```
3. Create a new database in MySQL called powerup
4. Update the database connection settings
   ```yml
   # src/main/resources/application-dev.yml
   spring:
      datasource:
          url: jdbc:mysql://localhost/powerup
          username: root
          password: <your-password>
   ```
5. After the tables are created execute src/main/resources/data.sql content to populate the database
6. Open Swagger UI and search the /auth/login endpoint and login with userDni: 123, password: 1234

<!-- USAGE -->
## Usage

1. Right-click the class PowerUpApplication and choose Run
2. Open [http://localhost:8090/swagger-ui/index.html](http://localhost:8090/swagger-ui/index.html) in your web browser

<!-- ROADMAP -->
## Tests

- Right-click the test folder and choose Run tests with coverage

## Proyect Structure

### Configuration Layer

It is the outermost layer and is responsible for security configuration using Spring Security and JWT, class assignment, dependency injection, exception usage and bean configurations.

### Adapters Layer

This layer contains two layers: the driven layer and the driven layer, which are responsible for all reception and adaptation by the client or server.

#### Drivin Layer

It is the user's entry point when connecting to the application, it allows the user to interact with the api.

### Domain Layer

It is the most internal module of the architecture, it belongs to the domain layer and encapsulates the business logic and rules.

## Entry Points

### User Controller

![image](https://github.com/Nirsch95/PowerUp/assets/37886668/58528f68-fb97-4864-84dd-1c5bcd5901f3)

- Create User

![image](https://github.com/Nirsch95/PowerUp/assets/37886668/dbcbf20d-6421-4acd-ac64-c377f06cb973)

- Get User

![image](https://github.com/Nirsch95/PowerUp/assets/37886668/7c7f8f94-c084-458b-93b0-189adaa0ce48)

### Login Controller

![image](https://github.com/Nirsch95/PowerUp/assets/37886668/1983f305-eb4f-46fc-bbb8-e55106a6c0ee)

- Refresh

![image](https://github.com/Nirsch95/PowerUp/assets/37886668/2dd12c56-21fb-4998-a7b1-1e534c1747bd)

- Login

![image](https://github.com/Nirsch95/PowerUp/assets/37886668/1420e3da-2795-414d-8723-735fb24e9872)

### Role Controller

![image](https://github.com/Nirsch95/PowerUp/assets/37886668/76f08cf5-a9fa-4a4b-b4ba-b6e1e92ec014)

## Author

[@Nirsch95](https://github.com/Nirsch95) - Andrés Castro :wolf:
