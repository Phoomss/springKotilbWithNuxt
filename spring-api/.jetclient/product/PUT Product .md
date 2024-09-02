```toml
name = 'PUT Product '
method = 'PUT'
url = 'http://localhost:8181/api/products/1'
sortWeight = 4000000
id = 'a779f90b-ebfb-41e9-ab24-a0acd8628d0f'

[[headers]]
key = 'Content-Type'
value = 'application/json'

[body]
type = 'JSON'
raw = '''
{
  "prductName": "IPhone 17 Pro",
  "productPrice": 30000.50,
  "productQuantity": 1,
  "productImage": "iphone.jpg"
}'''
```
