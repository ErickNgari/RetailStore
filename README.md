Retail Store Project
************************************
Requirement
************************************
	i) Apache Netbeans IDE 11.2   and or
	ii) Maven CLI
	 

Running the code
************************************
	i) Apache Netbeans IDE 11.2
		- Click on "Team -> Git -> Clone" on the Menu Bar
		- Input Github repository URL
		- Select Destination Folder
		- Click Finish and wait for the project to complete downloading
		- Once download is complete, right click on your project from the left navigation pane and click "Build with Dependencies". Wait for the project to complete downloading the required dependencies and build the project.
		- Once the project builds successfully, right click the project and click "Run"
	
	ii) Maven CLI
		Requirements(An installation of Maven CLI and a setup of MAVEN_HOME, M2_HOME and Maven bin path in the environment variables, and Git)
		- Create a project folder to clone into
		- Open terminal or command prompt on this folder location and paste the command "git clone https://github.com/ErickNgari/RetailStore.git" and hit enter
		- Run the following commands:
			cd RetailStore/
			mvn clean install
			mvn spring-boot:run -Dspring.profiles.active=testing			


Running Tests and Generating coverage reports
**************************************************
	i) Apache Netbeans IDE 11.2
		- Right click on the project and click "test" and wait for the test to run to completion
		- Then right click on the project and click "Code Coverage -> Show Report"
		- Then click "Run All Tests" to generate code coverage reports
		
	ii) Maven CLI
		- Open terminal on the project location
		- Run the following commands:
			mvn test
			mvn jacoco:report			
		- Navigate to target/site/jacoco/ from the projects folder and open the index.html on your browser to view test and code coverage reports
		
		
API Documentation with SpringDoc and OpenAPI 3 specification
***************************************************************
after running the application, the OpenAPI descriptions will be accessible via http://localhost:4040/api-descriptions/ and API documentation via http://localhost:4040/api-documentation.html 
		
		
		