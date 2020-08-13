# LifeWay Coding Challenge

These instructions assume the following are installed:
- Maven
- Java 8 or newer
- curl

To build and run, open a command prompt and navigate to the project's root directory and execute the following command:

``` mvn spring-boot:run ```

To test the web service, run the following curl command:

``` curl -d '{"id": "1", "message": "\"In the beginning was the Word, and the Word was with God, and the Word was God.\""}' -H 'Content-Type: application/json' http://localhost:8080/countWords ```
