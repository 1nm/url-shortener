# URL Shortener

## Usage
* Start Server
  ```
  ./gradlew bootRun
  ```

* Shorten URL
  ```bash
  curl -X POST "http://localhost:8080/api/v1/encode" -H  "accept: application/json" -H  "Content-Type: application/json" -d "{\"url\":\"https://google.com\"}"
  ```
  ```json
  {
    "url": "https://google.com",
    "key": "e2f6e918-ca8f-4eba-9b77-eb056a701c45",
    "createdDate": "2020-12-10T22:15:38.327",
    "lastModifiedDate": "2020-12-10T22:15:38.327"
  }
  ```

* Expand URL
  ```bash
  curl -X GET "http://localhost:8080/api/v1/decode/e2f6e918-ca8f-4eba-9b77-eb056a701c45" -H  "accept: application/json"
  ```
  ```json
  {
    "url": "https://google.com",
    "key": "e2f6e918-ca8f-4eba-9b77-eb056a701c45",
    "createdDate": "2020-12-10T22:15:38.327",
    "lastModifiedDate": "2020-12-10T22:15:38.327"
  }
  ```

## H2 Console
http://localhost:8080/h2-console

## Swagger UI
http://localhost:8080/swagger-ui.html

## TODO

Use a better unique id generator like [Twitter snowflake](https://blog.twitter.com/engineering/en_us/a/2010/announcing-snowflake.html) to replace UUIDv4