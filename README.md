
## Selenium-cucumber : BDD-Automation Testing Framework Using Java

---
Selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web. It enables you to write and execute automated acceptance/unit tests. It is cross-platform, open source and free. Automate your test cases with minimal coding.

## Pre-requisites:

---
* [Java](https://java.com/en/download/manual.jsp).
* [Maven](https://maven.apache.org/download.cgi).
* [Eclipse](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2019-12/R/eclipse-inst-win64.exe) OR [IntelliJ IDEA-Community edition](https://www.jetbrains.com/idea/download/#section=windows).  
* Eclipse OR IntelliJ Plugins 
     * [Maven](https://download.eclipse.org/technology/m2e/releases/1.4/)
     * [Cucumber](http://cucumber.github.io/cucumber-eclipse/update-site/)
	
## Download a Framework
  * GITHub or GITLAB  [Add GIT URL]

## Framework Architecture

--------------
	Project-Name[TestUIPoroject]
		|
		|_src/main/java
		|	|_com.test.ui.lang
		|	|	|_PPConstants.java
		|	|_com.test.ui.pages
		|	|	|_LoginPage.java
		|	|	|_TestPage.java
		|	|_com.test.ui.utils
		|	|	|_Util.java
		|	|	|_WebElementFunctions.java
		|	|	|...
		|_src/main/resources
		|	|_LoginPage.properties
		|	|_TestPage.properties
		|	|	|...
		|_src/test/java
		|	|_cucumbersteps.stepDef
		|	|	|_LoginStepDefinitions.java
		|	|	|_TestStepDefination.java
		|	|	|...
		|	|_acceptancetest.runner
		|	|	|_RunCuke.java
		|_src/test/resources
		|	|_features
		|	|	|_<Feature Folder>
		|	|	| |_CucumberFeatureFile.feature
		|	|	|_<Feature Folder>
		|	|	| |_CucumberFeatureFile.feature
		|	|	|_<Feature Folder>
		|	|	| |CucumberFeatureFile.feature
		|	|	|...
		|_drivers
		|	|_chromedriver.exe
		|	|_geckodriver.exe
		|	|_IEDriverServer.exe
		|_Jenkinsfile
		|
		|_pom.xml
		|
		|_serenity.properties
            |
            |
            |target (auto generated)
            |     |_Site
			 |_index.html




* #### serenity.properties:

    	 1.Define webdriver to run tests. Possible values are: phantomjs, firefox, chrome, htmlunit, iexplorer, opera, safari.
		 
		 2.Setting default base url. For basic authentication add USER:PASSWORD@ webdriver.base.url=http://www.google.com
	 	
		 3.Configure when screenshots are taken, possible values are: FOR_EACH_ACTION, BEFORE_AND_AFTER_EACH_STEP, AFTER_EACH_STEP, FOR_FAILURES, DISABLED

* #### pom.xml:

       1.POM is an acronym for Project Object Model. The pom.xml file contains information of project and configuration information for the maven to build the project such as dependencies, build directory, source directory, test source directory, plugin, goals etc.


* #### src/test/resources/features:

      All the cucumber features files (files .feature ext) keep in features folder.

* #### src/test/resources/serenity.conf:

      Keeping the browers location.

* #### src/test/java/cucumbersteps :

       Define step defintion under this package for your feature steps.

* #### src/test/java/runner :

       This package contains cucumber runner (RunCuke.java) where you can configure your glue code location (step defintions), define test result output format.(html, json, xml).

* #### src/main/resources :

       This folder contains all Xpath and locators , this properties files are called as per the page object.

* #### src/main/java :

 	this folder contains all business logic:
	
      1.com.test.ui.utils: 
		This package contains all common functions and automation utility.
      2.com.test.ui.pages: 
		This package contains actual business logic.
      3.com.test.ui.lang:
		This package contains all type of messages.


##  Writing a test

---
The cucumber features goes in the features library and should have the ".feature" extension.

 https://cucumber.io/docs/bdd/.

 https://www.tutorialspoint.com/cucumber/cucumber_overview.htm




##  Running a test

---
	 1. |.runner
           |RunCuke.java : Use this class to run the test suite.
		 	
     a. run the single test case use below code snapit.
	 
      tags= {"@UserCreation1"}
	  
	 b. running multiple test cases use below code snapit.
	 
	  tags= {"@UserCreation1,@TestJD12"}

	 c. running whole automation suite just comment and run. 
	 
	 //tags= {""}

##  Test Automation Report

---
--------------
			 |target (auto generated)
				|_Site
				|_index.html

Target folder is automatic generator while running the automation script.
    										
	1.Navigate till the site folder (Inside that folder you can able to see the  index.html file open in browser)

![alt-text](drivers/img.png "Automation Test Report")


