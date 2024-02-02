# RenaultEV_RestAPI

- Environment Setup  : 

    1) add official repository  : 
         
              $ sudo apt install wget ca-certificates
              $ wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -
              $ sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt/ $(lsb_release -cs)-pgdg main" >> /etc/apt/sources.list.d/pgdg.list' 
              
    2) install postgresql  : 
        
              $ sudo apt update
              $ apt install postgresql postgresql-contrib
              
    3) check postgresql status : 
        
              $ service postgresql status 
              
    4)  create databse "EV_database" and user "renault_admin" and give him "wellop" as password (you can change these as long as you change them as well in the application properties) : 
   
              $ sudo -u postgres psql
              postgres=# create user renault_admin with encrypted password 'wellop';
              postgres=# create database "EV_database" ;      
              postgres=# grant all privileges on database "EV_database" to renault_admin ;
              
              
- Setup intellij  IDEA or Spring Tool Suite (STS) then import and run application (you can get intellij IDEA through this link https://www.jetbrains.com/idea/download/#section=linux) 

- Get token for testing with postman  : 

   1) go to the authorization tab select Oauth2.0 and fill the get token section as follows : 
    
        ![Screenshot from 2022-04-29 09-06-55](https://user-images.githubusercontent.com/82954787/165907275-9becb105-f27b-4aa3-9652-e0206527c261.png)
        
   2) fill username and password with the username and password provided in the application.propreties (as set in the project renault_admin / renault_password ) : 
   
        ![Screenshot from 2022-04-29 09-10-36](https://user-images.githubusercontent.com/82954787/165907650-5d63b9fe-4af4-49ee-ad05-6decdd0b736a.png)
        
   3) on login postman will automatically follow the authorization code flow and give you a valid access token with a refresh token . the just click use token and postman will add that token in an authorization header : 
         
        ![Screenshot from 2022-04-29 09-15-29](https://user-images.githubusercontent.com/82954787/165908645-e171ea78-2cbd-4866-8ee6-ccd58e9c566a.png)
       

- Fill the database from goingelectric by passing the following get requests : 

                GET http://localhost:8080/api/parse_goingelectric
                GET http://localhost:8080/api/parse_goingelectric_images (optional) 
                

                
                
              

