# CS 320: Software Testing, Automation, and Quality Assurance

This repository contains selected work from my CS 320 projects. These assignments helped me practice writing Java code, creating JUnit tests, and checking that software meets its requirements.

## Portfolio Artifacts

From Project One, I included Contact.java, ContactService.java, ContactTest.java, and ContactServiceTest.java. These files demonstrate how I developed and tested a contact service with input validation and operations for adding, updating, and deleting contacts.

From Project Two, I included my Summary and Reflections Report, which explains my testing approach and what I learned about software quality.

## How can I ensure that my code, program, or software is functional and secure?

I can improve functionality by using the requirements to create tests for expected behavior, invalid inputs, and boundary values. For the contact service, this includes checking required fields, field length limits, and the phone number requirements. I can also rerun the JUnit tests after making changes to check whether existing functionality still works. For security, I need to validate input, handle errors appropriately, review my code, and check any dependencies for known vulnerabilities. Passing unit tests is useful evidence, but it does not guarantee that software is completely functional or secure.

## How do I interpret user needs and incorporate them into a program?

I start by breaking user needs into specific requirements that I can implement and test. For example, a requirement that a contact ID must be unique affects how the service adds and stores contacts. A requirement that a field has a maximum length needs both a validation rule and tests for values at and beyond that limit. If a requirement is unclear, I would ask questions before making assumptions. Connecting each requirement to the code and its tests helps me check that the program does what the user requested.

## How do I approach designing software?

I approach software design by identifying the program’s purpose, its requirements, and the responsibilities of each class. In the contact service project, the Contact class represents contact information and validates its fields, while ContactService manages the contacts. Keeping these responsibilities separate makes the code easier to understand and test. I then work in small steps, test each part, and make improvements when I find problems. I also consider readability and maintenance so that future changes are easier to make.
