# 4thYearProjectManagement                   [![Build Status](https://travis-ci.com/4806/4thYearProjectManagement.svg?token=us4qsxqi7zv1aRoJAiLW&branch=master)](https://travis-ci.com/4806/4thYearProjectManagement)

Profs can enter 4th year project topics, delete ones they no longer offer, or archive them for later use. For a given 4th year project topic, they can enter a description, program restrictions, and the number of students required. Students can look up projects and apply for one that they like. When a project is full, no more students can apply for it. The 4th year project coordinator can search for students without a project and send them a reminder. For the oral presentations, profs and students enter their availability. The 4th year project coordinator can allocate the oral presentations to rooms based on availability. This can be done manually or using a very simple “best effort” algorithm. For the final project, students submit their reports online by a deadline specified by the 4th year project coordinator and enforced by the system.

## List of all use cases
- Profs can enter 4th year project topics
- Profs can delete 4th year project they no longer offer
- Profs can archive 4th year project for later use
- For a given 4th year project topic, they can enter a description, program restrictions, and the number of students required.
- Students can look up projects and apply for one that they like. 
- When a project is full, no more students can apply for it
- The 4th year project coordinator can search for students without a project and send them a reminder
- For the oral presentations, profs and students enter their availability
- The 4th year project coordinator can allocate the oral presentations to rooms based on availability. This can be done manually or using a very simple “best effort” algorithm.
- For the final project, students submit their reports online by a deadline specified by the 4th year project coordinator and enforced by the system.

## Milestone 1: Early prototype. Give a 10-15 minute demo during the lab March 6
For this milestone we are looking to see enough functionality to get a feel for the system and how it will
work. One important use case should be operational. It should collect data from the back end, do
something with it and display the result. The display doesn't need to be fancy. There should be a GitHub
repo, integrated with Travis CI (or other hosted CI), and the app should be up and running on Heroku.
We will also inspect the README file, the Issues, the Kanban, the code reviews, the tests, and we will
verify that everybody is participating in all aspects of the project (if that is not the case, different team
members will end up with different grades).

### Completed in Milestone 1 : 
 - PM-4: Use Case 1 : User Registration
 - PM-11: Use Case 2 : User Login
 - Use Case 3 : Display a Welcome Page when logged in
 
### Milestone 2 : Plan
 - Convert identity and access control to Spring Security
 - General backlog from M1
 - Create Projects use case
 - Delete Projects use Case
 - Archive Projects use Case
 - Unarchive Project use case
 - Describe Project use Case
 - Join Project use Case
 
### Milestone 1 Schema : 

## User
  - id   
  - username
  - password
  - confPassword
  - role

## Milestone 2: Alpha Release. Give a 10-15 minute demo during the lab March 20
For the alpha release your system should be somewhat usable, although not feature-complete. This
means that a user should be able to use several related features of the app and do something reasonably
useful. The README on GitHub must be updated with a plan for the next sprint.

## Milestone 3 - Final demo. Project complete. Public demo during the lab April 3 
### Completed Use cases : 
 - Profile Page: contains 
 - - USeer Info ,  Select Availability , and  Change Password 
- Forgot Password: allowes the user to reset passward 
-  Project Look up: allowes student to search for projects according to diffrent criteria 
- Project Deliverables: Superviser sets up deliverable for the project
- Project Specific Pages: supervisior sees the project that he supervises, student sees the projest that he joined 

### Tests: 
 more testes added to the models, and accrosse the app. 
 ### Database 
 User
 - Id 
 - usename 
 - password
 - confPassword
 - role
 - answerTosecurityQuestion

 Student 
 - Program 
 - ProjectName
 
 Superviser 
 - projects 
  
 Program
 - id 
 - name 
 - Acronym
 
 project 
 - id 
 - description 
 - numberOfstudents 
 - supervisor 
 - restrictions 
 - restrictionsProgram
 - status 
 
 Deliverable
 - Calendar
 - inputTime
 - inputDate 
 - title 
 - description 
 - file 
 - fileName 
 - late 
 - submissionDate
 - Status 
 
 
 
 
 



