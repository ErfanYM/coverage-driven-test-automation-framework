# Coverage-Driven Test Automation Framework

A Java-based software testing project focused on improving unit test quality, increasing code coverage, and strengthening regression reliability across an algorithms codebase using JUnit, JaCoCo, and manual/LLM-assisted test engineering.

## Overview

This project analyzes and improves the quality of tests for a Java Maven repository containing algorithm and data-structure implementations. The workflow begins with baseline coverage analysis, then expands the test suite using LLM-generated tests and manual refinements, and finally validates improvements through JaCoCo coverage reports.

Rather than being a user-facing application, this repository demonstrates practical software engineering skills in test automation, code coverage analysis, regression testing, and quality assurance.

## Tech Stack

- Java 8
- Maven
- JUnit 4
- JaCoCo
- SpotBugs
- PIT
- LLM-assisted test generation

## Project Goals

- measure baseline unit test quality
- identify low-coverage classes and logic gaps
- generate additional unit tests with LLM assistance
- manually refine weak or invalid tests
- improve statement and branch coverage
- convert edge cases and defects into regression tests

## Architecture

This project follows a single-module Maven structure:

- `src/main/java`
  - core Java implementations for algorithms and data structures
- `src/test/java`
  - original tests
  - LLM-generated tests
  - manually refined tests
- `pom.xml`
  - dependency and plugin configuration for testing and reporting

### Main Tooling

- **JUnit 4** for unit testing
- **JaCoCo** for statement and branch coverage analysis
- **SpotBugs** for static analysis
- **PIT** for mutation-testing support
- **Maven** for build and test orchestration

## Key Features

- coverage-driven test design
- baseline vs improved coverage analysis
- LLM-assisted unit test generation
- manual regression test refinement
- edge-case and branch-focused validation
- defect discovery through targeted testing

## Engineering Highlights

- Expanded testing coverage across a large Java algorithms codebase containing recursion-heavy, branch-heavy, and edge-case-sensitive modules
- Improved low-tested areas through a combination of automated and manual test engineering
- Strengthened test adequacy beyond basic line coverage by targeting deeper logical paths and failure scenarios
- Converted risky behaviors into reproducible regression tests

## How to Run

### Prerequisites

- Java 8 or higher
- Maven installed

### Run tests

```bash
mvn clean test
