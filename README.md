# Full Text Search
This project exposes simple HTTP API with 2 endpoints:
1. POST /document  
```sh
{
  "id": "1",
  "text": "India is Great"
}
```
2. GET /search?query="INDIA"
```sh
 {
  "count": 1,
  "documents": [
    {
      "id": "1",
      "text": "India is Great"
    }
  ]
}
```
### Health Check by Actuator
```sh
http://localhost:8080/actuator/health
```
### Add Documents [One Document at a time. This could be in batch]
```sh
curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/document/ --data '{ "id": "1", "text": "India is Great" }'
```
### Search Documents by text
```sh
http://localhost:8080/fts/search?query=INDIA
```
