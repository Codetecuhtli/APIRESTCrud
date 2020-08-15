package com.codetecuhtli.apirest.services

import com.codetecuhtli.apirest.models.Person
import com.codetecuhtli.apirest.repositories.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl: PersonService {

    @Autowired
    private lateinit var personRepository: PersonRepository

    override fun getAllPeople(): List<Person> {
        return personRepository.people()
    }

    override fun getPersonById(id: Long): Person {
        return personRepository.findPersonById(id) ?: TODO("throw not found exception")
    }

    override fun createPerson(person: Person) {
        personRepository.createPerson(person)
    }

    override fun updatePerson(id: Long, person: Person): Person {
        return personRepository.updatePerson(id, person) ?: TODO("throw not found exception")
    }

    override fun deletePersonById(id: Long) {
        personRepository.deletePersonById(id)
    }

}