```toml
name = 'DELETE Product  1'
method = 'DELETE'
url = 'http://localhost:8181/api/products/1'
sortWeight = 5000000
id = '493c3316-c1cf-402a-983b-b4572b5a4ca4'

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
