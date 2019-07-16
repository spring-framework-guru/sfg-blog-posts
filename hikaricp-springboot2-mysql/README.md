# HikariCP-SpringBoot2-MySQL Demo

Step 1: run the EmployeeCrudDemoApplication file

step 2: verify sql server is running on system

step 3: use below APIs to check the response in postman

****insert a record to employee table (method = POST)***

-->http://localhost:8080/api/employees

-- body --

`{
    "id": 1,
    "firstName": "Sam",
    "lastName": "Presto",
    "email": "sam.p@gmail.com"
}`



*** get all employees data***

-->http://localhost:8080/api/employees

***get paticular employee data by ID***

-->http://localhost:8080/api/employees/1

*** update data for any employee  (method = PUT)***

-->http://localhost:8080/api/employees

-- body --

`{
	"id"		:1,
    "firstName": "Sam",
    "lastName": "Presto",
    "email": "sam.p@gmail.com"
}`

*** delete any employee based on ID (method = DELETE) ***

--->http://localhost:8080/api/employees/1
    