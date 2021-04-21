package com.apollographql.apollo3.compiler.unified.codegen.adapter

import com.apollographql.apollo3.compiler.unified.codegen.CgContext
import com.apollographql.apollo3.compiler.unified.ir.IrModelGroup
import com.squareup.kotlinpoet.TypeSpec


interface ResponseAdapterBuilder {

  fun prepare()

  fun build(): List<TypeSpec>

  companion object {
    fun create(
        context: CgContext,
        modelGroup: IrModelGroup,
        path: List<String>
    ): ResponseAdapterBuilder = when(modelGroup.models.size) {
      0 -> error("Don't know how to create an adapter for a scalar type")
      1 -> MonomorphicFieldResponseAdapterBuilder(
          context = context,
          model = modelGroup.models.first(),
          path = path
      )
      else -> PolymorphicFieldResponseAdapterBuilder(
          context = context,
          modelGroup = modelGroup,
          path = path
      )
    }
  }
}