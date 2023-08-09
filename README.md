## CarRental Database Management Web App 

### Team member: 
  - Wen Luo
  - Xiyuan Zhou, 013311259

----------------------------------------
#### Work Divsion
 - Wen Luo
   - Work on the MySQL database and decide
   - Help set up Eclipse Environments
   - Decide the E(ER) diagram
   - Help with coding model and class objects decided in Java
   - Work on the report
   - CSS touch up
   - Bug and test the UI
   - Decide and write query
  
 - Xiyuan Zhou
   - Work on the data decision and involved MySQL code
   - Setup JDBC, starting code to test Database
   - Made a connection with the Online Web View
   - Work passing value between a Web app and database
   - JSP files created and connection
   - Decide and write query
-----------------------------------------
#### Requirement development tools
  - Eclipse (Any version that has JDK 1.8 or higher)
  - MySQL(8.0.32) or higher 

#### Extra jar files required (Move to ../WEB-INF/lib)
  - jsp-api-2.2.jar
  - jstl-1.2.jar
  - mysql-connector-j-8.0.32.jar
  - servlet-api-2.5.jar

#### Apache Tomcat version 8 or higher 
  - apache-tomcat-8.5.85 (needed installing inside Eclipse)

If the program don't run or have red error at the first time,
check the __BuildPath__ . (Maybe your jar files are not included or
the version is not JDK 1.8. Also, the Apache Tomcat isn't available)

-------------------------------------------

#### To run the program
  - Git Clone the project first
  - Then run Eclipse and MySQL
  - First open creatdb.sql file and run on your local MySQL any Schema you want
    - Exexute creatdb.sql included all the Tables and Valid Datas
  - After that Go to *Eclipse*
  - open the code, negative to src/utils/DatabaseUtils.java
    - Inside the code "jdbcURL = "jdbc:mysql://localhost:3306/....", need put
      your database path and connect, put the database Schema you want to connect.
    - jdbcUsername = "root" and jdbcPassword = required
      - Put your MySQL database user information, username/password
  - right click the project __root__ (projectrental) -> Select Run As -> Run on Server
    - Suppose to connect with Apache Tomcat
      
------------------------------------------------
