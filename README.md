# unit-testing-rest-services-with-spring-boot-and-junit
unit-testing-rest-services-with-spring-boot-and-junit

# Maven 3.0+ is your build tool \n
# Your favorite IDE. I used Eclipse.\n
# JDK 1.8+ 

#Used PostMan
We will fire a request to http://localhost:8080/students/Student1/courses/Course1 to test the service. Response is as shown below.

{
  "id": "Course1",
  "name": "Spring",
  "description": "10 Steps",
  "steps": [
    "Learn Maven",
    "Import Project",
    "First Example",
    "Second Example"
  ]
}

POST : http://localhost:8080/students/Student1/courses.
{
  "name": "Mickito",
  "description": "10 Steps",
  "steps": [
    "Learn How to Break Things Up",
    "Automate the hell out of everything",
    "Have fun"
  ]
}


