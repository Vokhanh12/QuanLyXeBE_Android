# Car Rental Management System Backend

This project is a Car Rental Management System backend developed using Kotlin and Ktor framework, following Clean Architecture principles. The backend provides APIs for managing car rentals, user authentication, and route visualization.


Database Sql server:


![image](https://github.com/Vokhanh12/QuanLyXeBE_Android/assets/36543564/636e918d-4d14-445d-b32d-1d9b7714f00d)



## Table of Contents
- [Features](#features)
- [Architecture](#architecture)
- [Installation](#installation)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Features
- User authentication and authorization.
- Management of car rental information.
- Integration with BoxMap for route visualization.
- RESTful API endpoints for frontend integration.

## Architecture
This project follows the Clean Architecture principles, ensuring a clear separation of concerns and maintainable code. The architecture is divided into the following layers:

1. **Presentation Layer**: Handles the HTTP requests and responses.
2. **Domain Layer**: Contains the business logic and domain models.
3. **Data Layer**: Manages data sources such as databases and external APIs.

![Clean Architecture](https://in-kotlin.com/frameworks/ktor/clean-architecture/clean-architecture-diagram.png)

## Installation

1. **Clone the repository**
    ```bash
    git clone https://github.com/yourusername/your-repo-name.git
    cd your-repo-name
    ```

2. **Build the project**
    ```bash
    ./gradlew build
    ```

3. **Run the project**
    ```bash
    ./gradlew run
    ```

## Usage

### Project Structure
The project is structured as follows:
- `src`: Contains all the source code.
  - `presentation`: Handles HTTP requests and routes.
  - `domain`: Contains use cases and domain models.
  - `data`: Manages data sources and repositories.
- `resources`: Contains configuration files and static resources.

### Running the Server

To run the server, use the following command:
```bash
./gradlew run





