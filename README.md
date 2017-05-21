# data-model-generator
Data model generator based on Scala case classes.

[![Build Status](https://api.travis-ci.org/piotr-kalanski/data-model-generator.png?branch=development)](https://api.travis-ci.org/piotr-kalanski/data-model-generator.png?branch=development)
[![codecov.io](http://codecov.io/github/piotr-kalanski/data-model-generator/coverage.svg?branch=development)](http://codecov.io/github/piotr-kalanski/data-model-generator/coverage.svg?branch=development)
[<img src="https://img.shields.io/maven-central/v/com.github.piotr-kalanski/data-model-generator_2.11.svg?label=latest%20release"/>](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22data-model-generator_2.11%22)
[![License](http://img.shields.io/:license-Apache%202-red.svg)](http://www.apache.org/licenses/LICENSE-2.0.txt)

# Table of contents

- [Goals](#goals)
- [Getting started](#getting-started)
- [Examples](#examples)

# Goals

- Generate data model (e.g. DDL, avro schema, Elasticsearch mapping) based on Scala case classes

# Getting started

Include dependency:

```scala
"com.github.piotr-kalanski" % "data-model-generator_2.11" % "0.1.0"
```

or

```xml
<dependency>
    <groupId>com.github.piotr-kalanski</groupId>
    <artifactId>data-model-generator_2.11</artifactId>
    <version>0.1.0</version>
</dependency>
```

# Examples

## H2
```scala
import com.datawizards.dmg.{DataModelGenerator, dialects}

case class Person(name: String, age: Int)

object H2Example extends App {
  println(DataModelGenerator.generate[Person](dialects.H2))
}
```

```sql
CREATE TABLE Person(
   name VARCHAR,
   age INT
);
```

## Hive
```scala
import com.datawizards.dmg.{DataModelGenerator, dialects}

case class Person(name: String, age: Int)

object HiveExample extends App {
  println(DataModelGenerator.generate[Person](dialects.Hive))
}
```

```sql
CREATE TABLE Person(
   name STRING,
   age INT
);
```