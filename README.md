# MongoCRUDBackend
Backend Service using spring boot 
port=8080

Get all users
http://localhost:8080/api/v1/getAllUsers

Add user
http://localhost:8080/api/v1/addUser

Update user by id
http://localhost:8080/api/v1/updateUser/{id}

delete user by id
http://localhost:8080/api/v1/deleteUser/{id}

get user details by id
http://localhost:8080/api/v1/getUserById/{id}
 
 #Configurations befroe running application
 
 write you mongodb uri and database name  in resouces > application.properties
 spring.data.mongodb.database=Arun
 spring.data.mongodb.uri=mongodb://localhost:27017/
 
 create a collection named User
 {
  "_id":'',
  "name": "",
  "age": ,
  "email": "",
  "sex": "", (M or F)
  "job": "",
  "friends": Array
}
 
 #To run application

 Run as > Spring boot App
 
 
