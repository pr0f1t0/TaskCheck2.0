# TaskCheck 2.0 - REST API for TaskCheck Application

## About the Project
TaskCheck 2.0 is a REST API for the TaskCheck application, designed to make it easier for users to manage their tasks and plans.

## Technologies
- Java
- Spring Boot
- Docker

## Installation

To get started, you can either install or clone this repository on your local machine.

### Cloning the Repository
To clone the repository using Git, run the following command in your terminal:

```bash
git clone https://github.com/yourusername/TaskCheck2.0.git
```
## Running the application
### Prerequisites
To run the API, you need [Docker](https://www.docker.com/get-started/) installed on your machine.
Before running the application, please ensure that the following ports are available and not occupied:

- **8080** for the backend
- **4200** for the client
- **5432** for the database

### Running
Go to /repository-path/ and execute the following command:
```bash
docker compose up -d --build
```
### Accessing
After running the API, you will be able to access the Swagger UI:
[http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)
