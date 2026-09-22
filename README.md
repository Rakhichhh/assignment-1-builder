# Assignment 1 - Builder Pattern

## Student
Myrzabekov Rakhat

## Group
SE-2518

## Course
Software Design Patterns

## Project
Robot Configuration Builder

## Description

This project demonstrates the Builder Design Pattern using a robot configuration system.

The system allows the creation of robots with required and optional properties using a fluent API and method chaining.

## Builder Pattern Participants

- Product: `RobotConfiguration`
- Builder: `RobotConfigurationBuilder`
- Director: `RobotDirector`
- Client: `Main`
- Value Object: `Dimensions`

## Required Properties

- robotName
- model
- batteryCapacity
- maxSpeed

## Optional Properties

- camera
- gps
- lidar
- voiceControl
- loadCapacity
- autonomousMode
- emergencyStop
- dimensions

## Validation

The Builder performs validation before creating the final Product.

Main cross-field rules:

1. Autonomous robots require a camera or lidar.
2. Robots carrying more than 50 kg cannot exceed 5 m/s.

## Presets

The project contains three reusable configurations:

- BASIC
- WAREHOUSE
- AUTONOMOUS

## Testing

The project uses JUnit 5.

It contains automated tests for:

- valid configurations
- invalid configurations
- boundary cases
- individual constraint
- Builder reuse
- Product independence

## Project Structure

```text
src/main/java/kz/aitu/builder/
├── app/
│   └── Main.java
├── director/
│   └── RobotDirector.java
└── model/
    ├── Dimensions.java
    ├── RobotConfiguration.java
    └── RobotConfigurationBuilder.java

src/test/java/kz/aitu/builder/
└── RobotConfigurationBuilderTest.java

docs/
└── builder-uml.png



Technologies
Java 17+
Maven
JUnit 5
Git
GitHub


Run 
kz.aitu.builder.app.Main