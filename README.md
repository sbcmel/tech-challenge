#  My TechChallenge

This app is to access services provided by the Open ATMS system

## Tools

For building and running the application you need:

### springboot-apiserver-app

This project built using **Java** and the following tools:
- [Spring Boot](https://spring.io/projects/spring-boot) as server side framework
- [Gradle](https://gradle.org/) as build automation tool
- [Postman](https://www.postman.com) as API Testing tool
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows) as IDE

### react-app
- [nodeJS](https://nodejs.org/en/download/) as JavaScript library for creating user interfaces
- [VS Code](https://www.jetbrains.com/idea/download/#section=windows) as IDE

### Repo
- [Github](https://github.com/) as source codes repository
### RepoDeployment to Cloud 
- [AWS](https://aws.amazon.com/?nc2=h_lg) as cloud deployment solution

## Getting Started

### springboot
One way is to execute the main method in the techchallenge.apiserver.ApiserverApplication class from the IDE.

Alternative, you can use the [Spring Boot Gradle plugin](https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/) like so:

```terminal
# run Spring Boot App using gradle
./gradlew run
```

### react app
```terminal
# run react app from the IDE terminal
npm start
```

open the frontend project from the IDE.
## Deploy springboot App and react App to AWS
- Push and Commit source code to Github Repo 
- Then Github Actions will help to automate software workflow
- If no errors, means it has successfully deploy onto AWS
- Try and Test the AWS URL if it works

  [techchallenge](http://techchallenge-env.eba-2ksyirsk.us-west-2.elasticbeanstalk.com/)


## Rest API Endpoints
- /getAirports - Get all airport
- /sid2waypoints/{name} - Get SID top 2 waypoints by airport name 
- /stars2waypoints/{name} - Get top 2 waypoints by airport name

###### Have fun with tech challenge
