# Book Management REST API

REST API service using Spring Framework and Java. This application has the capability to get a single book, create and update a book, calculate the total price, and show a list of barcodes for the books in stock grouped by quantity.

Antique books and science journals can also be added and managed. They are just like other books but have additional properties and different calculation methods for the total price.

## Starting the Book Management System
1. Install [Oracle JDK 17 (or 19)](https://www.oracle.com/java/technologies/downloads/#java17) on your machine. If on Windows, make sure that JAVA_HOME variable matches the location of the installation;

2. To start this web service, either Run LibraryApplication from your IDE (e.g. Intellij IDEA) or execute the following command in the root directory:

    ```./mvnw clean spring-boot:run```

3. Install an API platform (e.g. Postman) to use the REST Endpoints of the next section. The application is preloaded with some books (Antique and Science Journal included).

## REST Endpoints
The following REST endpoints are available upon deployment of the book management system. They work for ALL books, even if they are Antique Books or Science Journals:

| HTTP Method | URL                                                 | Description                                                                  |
|-------------|-----------------------------------------------------|:-----------------------------------------------------------------------------|
| `POST`      | `http://localhost:8080/books`                       | Creates a new book based on the payload contained in the request body        |
| `GET`       | `http://localhost:8080/books/{barcode}`             | Obtains the book corresponding to the supplied barcode                       |
| `PUT`       | `http://localhost:8080/books/{barcode}`             | Updates an existing book  with the data contained in the request body        |
| `GET`       | `http://localhost:8080/books/{barcode}/total-price` | Calculates the total price of the book corresponding to the supplied barcode |
| `GET`       | `http://localhost:8080/books`                       | Obtains a list of all barcodes for the books in stock grouped by quantity    |

## Using the API platform (e.g. Postman)
The endpoints with `GET` method are easy to use. Simply copy the URL, choose `GET` method, and replace ```{barcode}```.

The endpoints with `POST` and `PUT` require the following request header: key `'Content-Type'`, value `'application/json'`. Also, a request body needs to be sent. It should be in JSON format, here's an example:
```
{
    "type": "Book",
    "name": "How Not To Die",
    "author": "Dr. Michael Greger",
    "barcode": 3245325435,
    "quantity": 10,
    "priceUnit": 21.34
}
```

For an Antique Book to be created or updated, `"type"` should equal `"AntiqueBook"`, and property `"releaseYear"` included (needs to be =<1900):
```
{
    "type": "AntiqueBook",
    "name": "Crime and Punishment",
    "author": "Fyodor Dostoevsky",
    "barcode": 3254367676,
    "quantity": 20,
    "priceUnit": 20.34,
    "releaseYear": 1866
}
```

For a Science Journal to be created or updated, `"type"` should equal `"ScienceJournal"`, and property `"scienceIndex"` included (needs to be between 1-10):
```
{
    "type": "ScienceJournal",
    "name": "This Mortal Coil",
    "author": "Andrew Doig",
    "barcode": 243444443223,
    "quantity": 50,
    "priceUnit": 41.44,
    "scienceIndex": 4
}
```

NOTE: When using an endpoint which returns a book, the property `"id"` will appear. It is autogenerated and a primary key. For creating or updating a book, there's no need to include it in request body. Follow the JSON examples posted above.

