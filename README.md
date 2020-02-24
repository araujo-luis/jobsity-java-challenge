[![Build Status](https://travis-ci.org/l222p/jobsity-java-challenge.svg?branch=master)](https://travis-ci.org/l222p/jobsity-java-challenge)

# Jobsity Code Challenge

Luis Araujo Java Code Challenge - Bowling App

## Prerequisites

Clone repo and install dependencies

```
$ git clone https://github.com/l222p/jobsity-java-challenge
$ cd jobsity-java-challenge
$ mvn clean package
```

## Run

This is a command-line app which reads a file that contains Bowling Rolls as follows:

``` 
Luis	10
Luis	10
Luis	10
Luis	10
Luis	10
Luis	10
Luis	10
Luis	10
Luis	10
Luis	10
Luis	10
Luis	10
```

Run it as a Java application, file path is a parameter. There is a folder with three scenarios that can be use as parameters `perfect.txt`, `rolls.txt` and `zero.txt`    

```
$ java -jar target/codechallenge-0.0.1-SNAPSHOT.jar C:\Users\perfect.txt
```
