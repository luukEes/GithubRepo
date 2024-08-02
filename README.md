##GithubRepo

# RepoRequest
Spring Boot application that retrieves a user's public repositories from GitHub using the GitHub REST API. 
Application consists of several components, including a client for making HTTP requests, a service layer for handling business logic, and a controller for exposing REST endpoints.
### RepoClient
Class is responsible for interacting with the GitHub API using `RestTemplate`. It contains a method `getUserRepo(String user)` that takes a GitHub username as a parameter and returns an array of `RepoDto` objects representing the user's repositories.

# RepoController
Class handles HTTP requests and maps them to the appropriate service methods. It also includes an exception handler to provide error responses. Its also cheking content type -> Headers in http request.
The endpoint `/getUser` retrieves the repositories of a specified GitHub user by calling the service layer.

# UserNotFoundException
Exception is thrown when a user is not found. This exception is handled in the `RepoController` to return a 404 status with a custom error message.

# RepoDto
 This Class is a data transfer object representing the structure of a GitHub repository's JSON response. It includes fields such as `name`, `full_name`, `owner`, `fork`, and `pushed_at`.

# RepoDtoOwner
Class represents the owner  login name of a GitHub repository. It includes a single field `login'.

# RepoService
The `RepoService` class contains the business logic for retrieving repositories and handling errors.
It calls the `RepoClient` to get the repositories and checks if the response is null or empty, throwing a `UserNotFoundException` if the user is not found.

# Main
The `Main` class is the entry point of the Spring Boot application. 


# Endpoints

- **GET /getUser**: Retrieves the repositories of a specified GitHub user.
  - **Request Param**: `username` (String) - GitHub username.
  - **Response**: JSON array of repositories.

# Dependencies
- Spring Boot
- Spring Web
- Lombok






