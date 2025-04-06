----------------------------
POST
http://localhost:8080/auth/register
{   
    "login":"test123",
    "password": "123456",
    "role": "USER"
}
----------------------------
POST
http://localhost:8080/auth/login

{   
    "login":"test123",
    "password": "123456"  
}
Response
{
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InRlc3QxMiIsImV4cCI6MTc0MzkxNjMzOX0.HMUvFwQhxU6Ttls1ONqXAyV9AjbDGHupyxtTKK7QGRA"
}

----------------------------
Create User Request

POST 

http://localhost:8080/api/user/register

payload example:
Authorizations
Headers: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InRlc3QxMiIsImV4cCI6MTc0MzkxNjMzOX0.HMUvFwQhxU6Ttls1ONqXAyV9AjbDGHupyxtTKK7QGRA

{
"firstName":"Alan",
"lastName": "Lima",
"document":"9999999999",
"email":"test@test.com",
"password": "123456",
"balance": "1000",
"userType":"COMMON"
}

"document" and "email" are unique

{
"transferValue": 599.99,
"sender": 1,
"receiver": 2
}

"sender" "receiver" need ID information

H2 Console
http://localhost:8080/h2-console/
username=sa
password=password


