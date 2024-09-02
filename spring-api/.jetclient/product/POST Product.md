```toml
name = 'POST Product'
method = 'POST'
url = 'http://localhost:8181/api/products/create'
sortWeight = 3000000
id = 'afbd058e-2d30-4265-a811-98f83f16a5ad'

[[headers]]
key = 'Content-Type'
value = 'application/json'

[body]
type = 'JSON'
raw = '''
{
  "prductName": "IPhone 16 Pro",
  "productPrice": 24500.50,
  "productQuantity": 1,
  "productImage": "iphone.jpg"
}'''
```
