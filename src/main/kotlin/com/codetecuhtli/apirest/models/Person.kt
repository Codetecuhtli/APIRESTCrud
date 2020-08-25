package com.codetecuhtli.apirest.models

import com.codetecuhtli.apirest.repositories.model.PersonEntity
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class Person(
        var id: Long?,
        @field:NotNull(message = "{error.null_name}")
        @field:NotEmpty(message = "{error.empty_name}")
        @field:Size(max = 50, message = "{error.size_name}")
        var name: String?,
        @field:NotNull(message = "{error.null_phone}")
        @field:NotEmpty(message = "{error.empty_phone}")
        @field:Size(min = 10, max = 10, message = "{error.size_phone}")
        var phone: String?) {

    fun toPersonEntity(): PersonEntity = PersonEntity(id ?: 0, name ?: "", phone ?: "")

}