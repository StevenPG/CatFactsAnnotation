# CatFacts Annotation Project

This project is based on a GitLab [Project Template](https://docs.gitlab.com/ee/gitlab-basics/create-project.html).

Improvements can be proposed in the [original project](https://gitlab.com/gitlab-org/project-templates/spring).

## Purpose
This project exists as an extremely simple java only configuration example on how to write custom Aspect Annotations in Spring. The project is properly version controlled and will be deployed to maven central. The steps followed to deploy the application to maven central will be listed here.

Once deployed, anyone can download the dependency and annotate their classes with @CatFacts, which will print a catfact to STDOUT whenever the method is called.

## Usage
For your Spring application to find the CatFacts advice, you will need to add 

    @ComponentScan(basePackages = {"com.stevenpg"})

to your SpringApplication file. This will allow Spring to pick up and load the CatFactsAspect into your Spring Context.

Usage of the annotation is as follows:

    @CatFacts
	@GetMapping("/")
	String home() {
		return "Spring is here!";
	}

Here is the sample output:

    2018-10-28 11:04:18.934  INFO 15736 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 4.334 seconds (JVM running for 20.372)
    2018-10-28 11:04:25.839  INFO 15736 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring FrameworkServlet 'dispatcherServlet'
    2018-10-28 11:04:25.839  INFO 15736 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
    2018-10-28 11:04:25.861  INFO 15736 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 22 ms
    2018-10-28 11:04:25.925  INFO 15736 --- [nio-8080-exec-1] com.stevenpg.aop.CatFactsAspect          : 4. Cats have over 20 muscles that control their ears.

## Project Reference Steps

### Creating a Custom Annotation - Components

These components should be all that is needed in Spring 2 to create a custom annotation that will execute a method on every method it is attached to.

[Aspect file example](https://gitlab.com/StevenPG/customspringaopannotation/wikis/aspect)
[Inteface file example](https://gitlab.com/StevenPG/customspringaopannotation/wikis/interface)

The interface defines the annotation, and the aspect file links when it is supposed to activate. This is the class that needs to be available in the spring context for the annotation to work properly.

### Caveats and Gotchas

### Creating a Release

### Uploading the Maven Central
