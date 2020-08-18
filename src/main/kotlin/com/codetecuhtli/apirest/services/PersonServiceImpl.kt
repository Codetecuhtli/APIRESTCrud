package com.codetecuhtli.apirest.services

import com.codetecuhtli.apirest.constants.Messages
import com.codetecuhtli.apirest.exceptions.NotFoundException
import com.codetecuhtli.apirest.models.Person
import com.codetecuhtli.apirest.repositories.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonServiceImpl: PersonService {

    @Autowired
    private lateinit var personRepository: PersonRepository

    override fun getAllPeople(): List<Person> {
        return personRepository.people()
    }

    override fun getPersonById(id: Long): Person {
        return personRepository.findPersonById(id) ?: throw NotFoundException()
    }

    override fun createPerson(person: Person) {
        personRepository.createPerson(person)
    }

    override fun updatePerson(id: Long, person: Person): Person {
        return personRepository.updatePerson(id, person) ?: throw NotFoundException(key = Messages.UPDATE_NOT_FOUND_KEY)
    }

    override fun deletePersonById(id: Long) {
        personRepository.deletePersonById(id)
    }

}