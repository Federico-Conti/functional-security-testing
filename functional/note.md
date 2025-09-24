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


