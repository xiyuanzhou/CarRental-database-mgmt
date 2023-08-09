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
**Timeline and Minutes Used**

Week 1:

Wen Luo:
Decide the E(ER) diagram: 180 minutes (3 hours)
Begin work on the MySQL database; determining schema, tables, and relationships: 300 minutes (5 hours)
Begin to set up Eclipse Environments for the team: 120 minutes (2 hours)
Xiyuan Zhou:
Collaborate with Wen on deciding data and associated MySQL code: 240 minutes (4 hours)
Set up JDBC and test database connection: 150 minutes (2.5 hours)
Begin work on making a connection with the Online Web View: 180 minutes (3 hours)

Week 2:

Wen Luo:
Continue with MySQL tasks and finalize the database structure: 240 minutes (4 hours)
Work on coding model and class objects decided in Java: 360 minutes (6 hours)
Begin assisting with the Eclipse setup for the rest of the team: 90 minutes (1.5 hours)
Xiyuan Zhou:
Ensure the connection between the web app and the database is stable: 180 minutes (3 hours)
Start work on passing values between the web app and database: 240 minutes (4 hours)
Begin creating JSP files and establish connections: 300 minutes (5 hours)

Week 3:

Wen Luo:
Start working on the report: 240 minutes (4 hours)
Begin with CSS touch-up for the user interface: 180 minutes (3 hours)
Work with Xiyuan on query decisions and writing: 150 minutes (2.5 hours)
Xiyuan Zhou:
Complete all JSP file creations and ensure connections are seamless: 240 minutes (4 hours)
Work on deciding and writing the necessary queries for the database: 240 minutes (4 hours)
Troubleshoot and test data transfers between the web app and database: 210 minutes (3.5 hours)

Week 4:

Wen Luo:
Continue and finalize the report: 240 minutes (4 hours)
Start bug-testing the user interface: 360 minutes (6 hours)
Finalize all queries with Xiyuan and test them: 180 minutes (3 hours)
Xiyuan Zhou:
Final testing on passing values between the web app and database: 240 minutes (4 hours)
Finalize and test all JSP file connections: 240 minutes (4 hours)
Collaborate with Wen on any final adjustments and refinements: 180 minutes (3 hours)


