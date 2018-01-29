##User Management Service

This service manages the users in **Dproz**. It provides endpoints
for user registration and verification.




###Developer Guide:  

####Getting Started:

In order to run this app locally, you need docker running in the local machine.

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


***Running the app as standalone application***    