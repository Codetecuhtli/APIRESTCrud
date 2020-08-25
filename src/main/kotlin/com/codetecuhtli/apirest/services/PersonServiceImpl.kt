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
        return personRepository.findAll().map { it.toPerson() }
    }

    override fun getPersonById(id: Long): Person {
        return personRepository.findPersonEntityById(id)?.toPerson() ?: throw NotFoundException()
    }

    override fun createPerson(person: Person) {
        personRepository.save(person.toPersonEntity())
    }

    override fun updatePerson(id: Long, person: Person): Person {
        val personFound = personRepository.findPersonEntityById(id) ?: throw NotFoundException(key = Messages.UPDATE_NOT_FOUND_KEY)
        personFound.name = person.name!!
        personFound.phone = person.phone!!
        return personRepository.save(personFound).toPerson()
    }

    override fun deletePersonById(id: Long) {
        personRepository.deleteById(id)
    }

}