package com.codetecuhtli.apirest.models

data class Person(var id: Long, var name: String, var phone: String, var errorMessage: String? = null): BaseResponse(errorMessage)