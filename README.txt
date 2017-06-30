Automation Framework

There are five important components in this framework:
1.Test Scripts.
2.Function Library.
3.Object Repository.
4.Test Data
5.Test Results.

Test Scripts:
             Each individual manual test case will be converted into a corresponding test script. The test scripts are the ones that test the expected and actual behavior of the application.

Function Library:
                Function library is a library which consists blocks of code(functions) that does repetitive tasks in the application. The main intent of these functions is to increase the reusability and decrease the use of large pieces of code while developing the test script. It also makes it easy to maintain the scripts while there is a major change in the application.
                
Object Repository:
                  Object repository is a place where different application objects are stored and can be easily accessed from the test scripts. All the test Objects are placed in one repository, so that it makes it easy to access and maintain the objects.
                 
Test Data:
          Test data is the input that needs to be submitted to the script, which in turn performs various operations on the application. As of now the data is passed from an excel spreadsheet.
          
Test Results:
            TestNG framework is used to generate test results. Results are generated in various formats after the completion of a test run. TestNG plugin for eclipse has to be installed for this to work.

Steps to run the scripts:
1.	Required data needs to be inserted into the excel spreadsheet. Various combinations can be entered in multiple columns, if you want to test the same script with different inputs.
2.	There is a file named testng.xml, which is called the driver. Enter the names of the test scripts that you want to run in this file.
3.	Navigate to the bin folder which contains the testng.xml file and run the following commands:

To set the class path: This command needs to be run only once before starting execution.

set CLASSPATH="System Path to the Functions Folder":
"System Path to the Object Repositories Folder":"System Path to the test scripts Folder"

To run the test scripts:
"//java -cp "../lib/*:" org.testng.TestNG testng.xml"     
 
