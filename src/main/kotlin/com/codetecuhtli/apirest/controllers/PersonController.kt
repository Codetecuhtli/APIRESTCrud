package com.codetecuhtli.apirest.controllers

import com.codetecuhtli.apirest.models.Person
import com.codetecuhtli.apirest.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("person")
class PersonController {

    @Autowired
    private lateinit var personService: PersonService

    @GetMapping
    fun getPeople(): List<Person> =
            personService.getAllPeople()

    @GetMapping("/{id}")
    fun getPersonById(@PathVariable("id") id: Long) =
            personService.getPersonById(id)

    @PostMapping
    fun createPerson(@RequestBody person: Person) =
            personService.createPerson(person)

    @PatchMapping("/{id}")
    fun updatePerson(@PathVariable("id") id: Long, @RequestBody person: Person) =
            personService.updatePerson(id, person)

    @DeleteMapping("/{id}")
    fun deletePerson(@PathVariable("id") id: Long) =
            personService.deletePersonById(id)

}