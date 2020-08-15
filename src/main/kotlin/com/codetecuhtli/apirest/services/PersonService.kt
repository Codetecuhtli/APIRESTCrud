package com.codetecuhtli.apirest.services

import com.codetecuhtli.apirest.models.Person

interface PersonService {
    fun getAllPeople(): List<Person>
    fun getPersonById(id: Long): Person
    fun createPerson(person: Person)
    fun updatePerson(id: Long, person: Person): Person
    fun deletePersonById(id: Long)
}