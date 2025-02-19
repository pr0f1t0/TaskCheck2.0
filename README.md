# TaskCheck 2.0 - REST API for TaskCheck Application

## About the Project
TaskCheck 2.0 is a REST API for the TaskCheck application, designed to make it easier for users to manage their tasks and plans.

## Technologies
- ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
- ![Spring Boot](https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=Spring&logoColor=white)
- ![PostgreSQL](https://img.shields.io/badge/postgresql-4169e1?style=for-the-badge&logo=postgresql&logoColor=white)
- ![Docker](https://camo.githubusercontent.com/c9a85f6869aa992f1500dd9d4d4bdff7d405605292ca152587394c1f92552d4f/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f646f636b65722d2532333064623765642e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d646f636b6572266c6f676f436f6c6f723d7768697465)

## Installation

To get started, you can either install or clone this repository on your local machine.

### Cloning the Repository
To clone the repository using Git, run the following command in your terminal:

```bash
git clone https://github.com/pr0f1t0/TaskCheck2.0.git
```
## Running the application
### Prerequisites
To run the API, you need [Docker](https://www.docker.com/get-started/) installed on your machine.
Before running the application, please ensure that the following ports are available and not occupied:

- `8080` for the backend
- `5432` for the database

### Running
Go to /repository-path/ and execute the following command:
```bash
docker compose up -d --build
```
### Accessing
After running the API, you will be able to access the [Swagger UI](http://localhost:8080/swagger-ui/index.html#/):
`http://localhost:8080/swagger-ui/index.html#/`
