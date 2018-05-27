# boot-framework
Bootable framework providing CRUD APIs. Use the framework, add your entity and domain objects and get readily available APIs.

The repository comes with an example for CRUD APIs for a User entity.

#Steps to run the application
1. Clone the repository
2. Modify the database name in application.properties
2. Run the Application class
3. Checkout the service: curl localhost:8080/user/1

#Writing your own entity:
1. Create your entity class extending AbstractEntity adding Entity and Column annotations
2. Create your repository interface extending AbstractRepository adding Spring Repository annotation
3. Create your entry class extending AbstractEntry
4. Create your manager class extending AbstractManager adding Spring Service annotation
5. Create your mapper class extending EntryEntityMapper adding MapStruct Mapper annotation. Override the methods if Entry and Entity attributes have different names
5. Create your response class extending AbstractResponse
6. Create your controller class extending AbstractController adding RestController and RequestMapping annotation

#Technologies Used
1. Spring boot
2. MySQL
3. MapStruct