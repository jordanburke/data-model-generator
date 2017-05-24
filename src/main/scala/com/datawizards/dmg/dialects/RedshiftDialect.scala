package com.datawizards.dmg.dialects

import com.datawizards.dmg.model.{ArrayFieldType, ClassMetaData, FieldMetaData}

object RedshiftDialect extends DatabaseDialect {
  override def intType: String = "INTEGER"

  override def stringType: String = "VARCHAR"

  override def longType: String = "BIGINT"

  override def doubleType: String = "DOUBLE PRECISION"

  override def floatType: String = "REAL"

  override def shortType: String = "SMALLINT"

  override def booleanType: String = "BOOLEAN"

  override def byteType: String = "SMALLINT"

  override def dateType: String = "DATE"

  override def timestampType: String = "TIMESTAMP"

  override def arrayType: String = "VARCHAR"

  override protected def fieldAdditionalExpressions(f: FieldMetaData): String = ""

  override protected def additionalTableProperties(classMetaData: ClassMetaData): String = ""

  override protected def additionalTableExpressions(classMetaData: ClassMetaData): String =
    (
      if(classMetaData.comment.isDefined)
        s"\nCOMMENT ON TABLE ${classMetaData.className} IS '${classMetaData.comment.get}';"
      else ""
    ) + classMetaData.fields.map(f =>
      if(f.comment.isDefined)
        s"\nCOMMENT ON COLUMN ${classMetaData.className}.${f.name} IS '${f.comment.get}';"
      else ""
    ).mkString("")


  override protected def getArrayType(a: ArrayFieldType): String = {
    log.warn("Redshift doesn't support ARRAY type. Column converted to VARCHAR.")
    "VARCHAR"
  }

  override def toString: String = "RedshiftDialect"
}
