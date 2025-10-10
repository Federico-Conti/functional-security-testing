**Table of Contents**

- [Functional vs non-Functional testing](#functional-vs-non-functional-testing)
  - [(Functional) Software testing](#functional-software-testing)
  - [Test case and Test suite](#test-case-and-test-suite)
  - [Manual vs Automated](#manual-vs-automated)
- [Web Application Architecture](#web-application-architecture)
  - [Client-Server Architecture](#client-server-architecture)
  - [Web Application Heterogeneity](#web-application-heterogeneity)
  - [Document Object Model (DOM)](#document-object-model-dom)
  - [Web Application Models](#web-application-models)
    - [Multi-Page Applications (MPA)](#multi-page-applications-mpa)
    - [Single-Page Applications (SPA)](#single-page-applications-spa)
  - [AJAX and Asynchronous Communication](#ajax-and-asynchronous-communication)
  - [Key Characteristics of Web Applications](#key-characteristics-of-web-applications)
- [Web Application Testing Challenges](#web-application-testing-challenges)
  - [Systematic Black-Box Approach for E2E Testing](#systematic-black-box-approach-for-e2e-testing)
- [Testing Frameworks](#testing-frameworks)


## Functional vs non-Functional testing

Each software factor can be evaluated using specific types of testing:

Functional Testing

- Targets **correctness** by verifying that the software behaves as expected according to requirements.

Non-Functional Testing

- Examines non-functional aspects such as **efficiency**, **usability**, **reliability**, **security**, and other qualities of the software application.

### (Functional) Software testing

Is a systematic approach attempting to find defects, i.e., bugs in a software system

Goals of Software testing

1. Expose and eliminate bugs as early as possible
2. Increase confidence in software correctness
3. Increase software reliability (i.e., function well under
stated conditions for a specified period of time)

**NOT a goal of testing**: prove correctness, because
exhaustive testing is unaffordable (input domain is
huge!)
– Other techniques to do this, e.g. Model checking

Levels of Software Testing

1. Unit Testing --> Testing of a single
function/class
2. Integration Testing --> individual units are combined and tested as a group
3. E2E Testing (End-to-End Testing) --> Testing the system as a whole through the GUI in real conditions
    - considering network and external systems
    - It is performed from start to finish under real world
scenarios like communication of the application with
hardware, network, database and other applications …


Pros and Cons of E2E Testing

- Good things

    – Hide the complexity of the (backend) system
    – Uniformed interface (the GUI) – only one
    – A testing framework at the front-end can automate the tests
    – Particularly useful (when automated) for regression testing
        (next slide)

- Bad things

    – Time consuming to run
    – Prone to non-determinism problems (Flaky tests, e.g., no internet connection)  
    – Prone to the fragility problem (expensive to maintain)
    – Cannot pinpoint the root cause of failure (Anything in the entire flow could have contributed to the failure)

**Regression Testing**
The goal of regression testing is to ensure that previously developed and tested code still functions as expected after new changes

### Test case and Test suite

Test case = A set of inputs (test data), execution preconditions, and expected outcomes developed for a particular objective, such as to exercise a particular program path or to verify compliance with a specific requirement

Test suite = A collection of test cases

How to find good inputs (test data)?

To create effective test cases we have to find ‘good’ inputs (i.e., test data)

- We can not select them randomly!

There are two families/categories of approaches:

1. **White-box testing**: The tester has access to the internal structure of the software. The focus is on the internal logic and structure of the code.

2. **Black-box testing**: The tester does not have access to the internal structure of the software. The focus is on inputs and expected outputs.

### Manual vs Automated

Testers manually create and execute the test cases

- see [How ‘to write’ a test case](https://www.youtube.com/watch?v=BBmA5Qp6Ghk)

A testing framework automatically execute test scripts (implementation of test cases) that are produced by Testers

## Web Application Architecture

Web applications follow a client-server architecture that introduces unique characteristics and complexities for testing.

### Client-Server Architecture

**Client-side**: Hosts the browser (e.g., Edge, Firefox, Chrome), which displays pages and manages part of the application logic.

**Server-side**: Includes various components such as web server, application server, and database server, which generate pages and handle business logic.

### Web Application Heterogeneity

Web applications are heterogeneous because a single page is composed of different languages:

- **HTML** for structure
- **CSS** for styling
- **JavaScript** for logic and behavior

This multi-language composition creates complexity in both development and testing scenarios.

### Document Object Model (DOM)

When a browser loads a page, it parses the HTML and builds an internal model called the **Document Object Model (DOM)** - a tree representation of the page.

Key characteristics of DOM:
- Can be read and modified by JavaScript at runtime
- Follows **event-driven programming** paradigm
- User interactions (e.g., button click → onClick event) trigger JavaScript functions (event listeners)
- Event listeners update the DOM and consequently the page display

On the server side, scripts are often composed of multiple languages (e.g., PHP, HTML, SQL), introducing an additional level of dynamism since the same server-side page can produce different outputs depending on the inputs received.

### Web Application Models

Web applications are classified into two main models:

#### Multi-Page Applications (MPA)
- Traditional model
- Server sends a complete new HTML page for each request
- Synchronous interaction, less fluid user experience

#### Single-Page Applications (SPA)
- Modern model
- After initial page load, communicates with server through AJAX
- Browser receives only data (JSON or XML) instead of reloading entire page
- Asynchronous interaction, application remains always responsive

### AJAX and Asynchronous Communication

**AJAX** is the core of SPAs: a set of technologies that enable asynchronous communication between client and server, maintaining continuous interaction.

**Example**: Name validator
- User input triggers an AJAX request
- Server validates the name
- Response dynamically updates the page without reloading it

### Key Characteristics of Web Applications

Modern web applications exhibit two main characteristics that impact testing:

1. **Heterogeneity and Complexity**
   - Use multiple languages, technologies, and frameworks
   - Require diverse testing approaches for different components

2. **Dynamism**
   - **Client-side**: JavaScript and DOM runtime modifications
   - **Server-side**: Variable page generation based on inputs

SPAs represent the most advanced level of this dynamism. Today, the perceived difference between web applications and desktop applications is becoming increasingly minimal.
However, this complexity and dynamism create significant challenges for web application testing, which will be addressed in subsequent sections.


## Web Application Testing Challenges

Testing web applications presents unique challenges due to their complexity and interconnected nature. Below are the primary difficulties and approaches for different testing levels:

- Unit testing can be challenging due to the high level of interconnection between components. This often necessitates the use of mocking to simulate the behavior of dependent functions or modules.
- Integration testing is complex because it involves managing test data effectively. The setup and maintenance of test environments can be time-consuming and resource-intensive.

### Systematic Black-Box Approach for E2E Testing

A structured black-box process for generating E2E tests involves the following four phases:

1. **Select User Functions**  
  - List down the features (user functions) of the system that we want to test.

2. **Build Conditions Based on User Functions**  
  - Create a set of conditions for each user function selected.

3. **Build Test Scenarios**  
  - Define test scenarios for the user functions (paths, set of steps, or pages).

4. **Build Multiple Test Cases**  
  - Develop one or more test cases for each scenario defined. Test cases should include each condition.

Exhaustive testing is impractical due to the explosion of test combinations. Instead, the following techniques are used to reduce the number of test cases while maintaining effectiveness:

1. **Conventional Shortcut**: Select a few representative values for each input.
2. **Pairwise Testing**: Test all possible pairs of variable values, significantly reducing the number of tests while maintaining a high fault detection rate.
3. **Boundary Value Analysis**: Focus on values at the boundaries of input partitions, as errors often occur at these limits.


## Testing Frameworks

Two main categories of testing frameworks:

**Capture/Replay Frameworks**

- Record the actions performed by the tester using a specific tool/framework
- Examples: Selenium IDE, Katalon IDE
- Re-execute recorded actions automatically

**Programmable Testing Frameworks**

- Test scripts are software artifacts created using:
  - Standard programming languages and IDEs (e.g., Java + VS Code)
  - Specific web testing frameworks
- Examples: Selenium WebDriver (+JUnit), TestIM, Katalon Studio

| Tool              | Category         | Language                  | Main Use                     | Features                                      |
|-------------------|------------------|---------------------------|------------------------------|-----------------------------------------------|
| Selenium IDE      | Capture/Replay   | No-code                   | Test recording and replay    | Uses .side files, Selenese language           |
| Selenium WebDriver| Script-based     | Multi-language (Java, Python, etc.) | Automated E2E testing       | Object-oriented API for browser control       |




Selenium WebDriver provides a cross-platform API in different languages

- e.g. Interface WebDriver, methods click(), get(), …

Selenium WebDriver4 uses the native support implemented by each browser to carry out the automation process

For this reason a component called Driver between the script using the Selenium Web‐Driver API and the browser is needed!


Selenium WebDriver requires:

1. Download Selenium Library for Java
2. Download Browser Driver (e.g., Chrome Driver for Chrome)
   - Compatible with the browser version

But  Manual Driver management is costly in terms of effort and problematic in terms of maintenance

- For this reason, recently some specific libraries able to manage automatically drivers have been devised:
**WebDriverManager and Selenium Manager**

They are open-source Java libraries able to carry out automatically the management

- download, setup, and maintenance of the drivers required by Selenium WebDriver (e.g.,
chromedriver, geckodriver, msedgedriver, etc.) in a fully automated manner.

WebDriverManager Process

1. WebDriverManager tries to find the browser version (e.g., Chrome 135) installed in the local machine.  
2. WebDriverManager determines the correct driver version (e.g., chromedriver 135.0.4389.23) and, if not locally present, downloads it.  
3. WebDriverManager exports the downloaded driver path using the proper Java system property (i.e., `webdriver.chrome.driver`).  