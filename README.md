# Nutritionist-App
Why we need this application?
Eating unhealthy food is common now a days. Poor Nutrition affects as being overweight or obese, tooth decay, high blood pressure, high cholesterol, heart disease and many more other problems. So for providing people a healthier Lifestyle we need a proper system which can guide people about good nutrition.

Application About :
Nutrition App is a application which provides user to search healthy food, enables user to add food to favourite food whichever he/she likes. User can get in details nutrition desciption of any food he/she searches. 
Important features User get recommendation of food according to their interest. 

Technologies used:
Programming languages : Java, JavaScript
Frameworks : Spring Boot, ReactJS
IDE : Eclipse, Visual Studio Code
Database : Mysql, MangoDB
Version Control : Git Hub
another tool/platform : Docker 

Concept used : 
A microservices conept is used in this application, we have five microservice running in it i.e. 
1) Api-Gateway : Which is a gateway between our backend and frontend so that user has not to remmember so many different URLs and can easily acces through one URL only.
2) User-Service : It maintains the users for the application and stores the user data in mysql database.
3) Service- Discovery : Used Eureka Server and created applications own server and that manages all clients services, it knows all client applications running on which port and IP address.
4) Favourite-service : Manages User's favourite food features.
5) Recommendation-service : Recommend user foods according to their interest.
