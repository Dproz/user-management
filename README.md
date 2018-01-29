## User Management Service

This service manages the users in **Dproz**. It provides endpoints
for user registration and verification.


### Rest Endpoint Exposed

#### Add User
 Adds an user to Dproz user domain. The user is not activated after adding the user.
 
```
POST /api/dproz/users HTTP/1.1
Host: gw-dev.dproz.com:8080
Content-Type: application/json
Accept: application/json
Cache-Control: no-cache
Postman-Token: ff31cae0-1411-06d1-e850-b6e1e55b681b

{
    "userType": "PRO",
    "firstName": "Prabhakar",
    "lastName": "Digumarthi",
    "middleName": "VS",
    "phone": {
        "phoneNumber": "8041000100",
        "primary": false,
        "contactMethod": "CALL"
    },
    "address": {
        "longitude": 0,
        "latitude": 0,
        "street": "Kilbrun",
        "district": "Godavari",
        "region": "Telangana",
        "country": "USA"
    },
    "emailAddress": "prabhakar.digumarthi@gmail.com",
    "active": true,
    "profilePictureUrl": null
}

``` 


#### Get Access Token:

In order to perform get and update operations on user, the user needs to login and get access token.
below is the sample request for getting access token.


```
curl -X POST \
  http://gw-dev.dproz.com:8080/oauth/token \
  -H 'Authorization: Basic d2ViX2FwcDpjaGFuZ2VpdA==' \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: e2b1c056-084f-ec48-51e7-2df021693dac' \
  -H 'content-type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW' \
  -F grant_type=password \
  -F username=prabhakar.digumarthi@gmail.com \
  -F password=Password@1 \
  -F scope=openid \
  -F client_id=web_app
```


#### Get User:

Gets a Dproz user details.

```
curl -X GET \
  http://gw-dev.dproz.com:8080/api/dproz/users/1 \
  -H 'Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyUmVmZXJlbmNlSWQiOiIxIiwidXNlcl9uYW1lIjoicHJhYmhha2FyLmRpZ3VtYXJ0aGlAZ21haWwuY29tIiwic2NvcGUiOlsib3BlbmlkIl0sImV4cCI6MTUxNzIwMDExMSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6IjQ2ODZkNjlhLTcwYzYtNDBiYi04MmZjLWJlZmM4NTgzZGY1OCIsImNsaWVudF9pZCI6IndlYl9hcHAifQ.T0vgOYvQ0BMzQ5FzJNmXFXoc_E3RhiSS4UF8E7uSDXHCk3X6StwHq2NjBhOlMDE0Y-AB12Dv4WQ0aJAtVqZJsBAvIXg6eJ-_1mQlBs8Mk-yxuXwerB-pdBonVXzo8kjcMSpkCvzrrDitdDWVY8H8Gjqfgf0EtyAU4wkf39OgcmJbUc5f-8vSRZIu2r98-muybtf_zm-5ENkOPmVn3h4ZCltL1t2xNK1TVcBgaj1oAP2IyS8jFNQGEL33oNt9gRvVSZGiXmTunc5R4Wug3--crvYF1EiIOs7kV0BeTygku4q0TI__DuhylNZiTs9quXP55mUEmdCKCGk0hj58_Wn_rw' \
  -H 'Cache-Control: no-cache' \
  -H 'Postman-Token: c984ad46-f5f8-b2a5-2d12-9c1f873a5bed'
```
### Developer Guide:  

#### Getting Started:

In order to run this app locally, you need docker running in the local machine.
Also docker compose needs be installed.

***Running the app for development***
1. Clone this repository, using the following command:

    ```
      git clone https://github.com/Dproz/user-management.git
    ``` 

2. Run the infra structure needed for running this application

    ```
      docker-compose -f ./src/main/docker/infra-local.yml up -d 
    ``` 
    
3. Now run the app using any IDE. If the IDE is setup properly, the spring dev tools let you do that hot deploy of the application.

4. After the changes to code, the below command will build the code and creates docker image after with the new built code.
    
    ```
      mvn clean install
    ```
5. Use the below command to push the docker image to docker hub.

    ```
      mvn dockerfile:push    
    ``` 

***Running the app as standalone application*** 

1. Clone this repository, using the following command:

    ```
      git clone https://github.com/Dproz/user-management.git
    ``` 

2. Run the application along with the infra needed.

    ```
      docker-compose -f ./src/main/docker/app.yml up -d 
    ``` 
    
3. Check the following url to ensure that app is running

    ```
      http://localhost:8080/application/health
    ```   