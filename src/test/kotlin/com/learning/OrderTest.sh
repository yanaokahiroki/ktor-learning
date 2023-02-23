curl -X GET --location "http://127.0.0.1:8080/order" \
  -H "Content-Type: application/json"

curl -X GET --location "http://127.0.0.1:8080/order/2023-02-23-01" \
  -H "Content-Type: application/json"

curl -X GET --location "http://127.0.0.1:8080/order/2023-02-23-02/total" \
  -H "Content-Type: application/json"
