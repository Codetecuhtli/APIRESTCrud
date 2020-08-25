package com.codetecuhtli.apirest.repositories

import com.codetecuhtli.apirest.repositories.model.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository: JpaRepository<PersonEntity, Long> {

    fun findPersonEntityById(id: Long): PersonEntity?

}