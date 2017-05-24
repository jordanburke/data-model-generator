package com.datawizards.dmg.dialects

import com.datawizards.dmg.{DataModelGenerator, DataModelGeneratorBaseTest}
import com.datawizards.dmg.TestModel._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GenerateElasticsearchMappingTest extends DataModelGeneratorBaseTest {

  test("Simple model") {
    val expected =
      """{
        |   "mappings": {
        |      "Person": {
        |         "name": {"type": "string"},
        |         "age": {"type": "integer"}
        |      }
        |   }
        |}""".stripMargin

    assertResultIgnoringNewLines(expected) {
      DataModelGenerator.generate[Person](ElasticsearchDialect)
    }
  }

  test("ClassWithAllSimpleTypes") {
    val expected =
      """{
        |   "mappings": {
        |      "ClassWithAllSimpleTypes": {
        |         "strVal": {"type": "string"},
        |         "intVal": {"type": "integer"},
        |         "longVal": {"type": "long"},
        |         "doubleVal": {"type": "double"},
        |         "floatVal": {"type": "float"},
        |         "shortVal": {"type": "short"},
        |         "booleanVal": {"type": "boolean"},
        |         "byteVal": {"type": "byte"},
        |         "dateVal": {"type": "date"},
        |         "timestampVal": {"type": "date"}
        |      }
        |   }
        |}""".stripMargin

    assertResultIgnoringNewLines(expected) {
      DataModelGenerator.generate[ClassWithAllSimpleTypes](ElasticsearchDialect)
    }
  }

  test("Array type") {
    val expected =
      """{
        |   "mappings": {
        |      "CV": {
        |         "skills": {"type": "string"},
        |         "grades": {"type": "integer"}
        |      }
        |   }
        |}""".stripMargin

    assertResultIgnoringNewLines(expected) {
      DataModelGenerator.generate[CV](ElasticsearchDialect)
    }
  }

  test("Nested array type") {
    val expected =
      """{
        |   "mappings": {
        |      "NestedArray": {
        |         "nested": {"type": "string"},
        |         "nested3": {"type": "integer"}
        |      }
        |   }
        |}""".stripMargin

    assertResultIgnoringNewLines(expected) {
      DataModelGenerator.generate[NestedArray](ElasticsearchDialect)
    }
  }

}