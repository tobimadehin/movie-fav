## Movie-Fav

Movie-Fav is a web application that allows users to list their favorite movies and rank them. It utilizes React for the frontend and Spring Boot for the backend.

### Features

- **Add Movies:** Users can add their favorite movies to the list.
- **Ranking:** Movies can be ranked based on the user's preference.
- **Sorting:** Movies can be sorted based on ranking or alphabetical order.
- **Backend Storage:** Utilizes Spring Boot backend to store and manage movie data.

### Technologies Used

- **Frontend:**
  - React: A JavaScript library for building user interfaces.
  - CSS: Styling the user interface.
  
- **Backend:**
  - Spring Boot: A Java-based framework for building web applications.
  - Spring Data JPA: Simplifies data access layer implementation.
  - H2 Database: An in-memory database for storing movie data.

### Getting Started

To run Movie-Fav locally, follow these steps:

1. Clone the repository: `git clone <repository-url>`
2. Navigate to the backend directory: `cd movie-fav-backend`
3. Run the Spring Boot application: `./mvnw spring-boot:run`
4. Navigate to the frontend directory: `cd movie-fav-frontend`
5. Install dependencies: `npm install`
6. Start the React application: `npm start`
