package com.codetecuhtli.apirest.repositories

import com.codetecuhtli.apirest.models.Person
import org.springframework.stereotype.Repository

@Repository
class PersonRepository {

    companion object {
        val people = mutableListOf(
                Person(1,"Pepe", "5512345678"),
                Person(2, "Maria", "5522334455"),
                Person(3, "Beto", "5566774411"),
                Person(4, "Ana", "5544332266")
        )
    }

    fun people(): List<Person> = people

    fun findPersonById(id: Long): Person? = people.find { it.id == id }

    fun createPerson(person: Person): Person = person.apply {
        id = (people.size + 1).toLong()
        people.add(this)
    }

    fun updatePerson(id: Long, person: Person): Person? {
        val personFound = findPersonById(id)

        personFound?.let {
            people.remove(it)

            if (it.phone != person.phone){
                it.phone = person.phone
            }

            if (it.name != person.name){
                it.name = person.name
            }

            people.add(it)
        }


        return personFound
    }

    fun deletePersonById(id: Long): Boolean{
        val person = findPersonById(id)

        person?.let {
            return people.remove(it)
        }

        return false
    }

}