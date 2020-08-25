package com.codetecuhtli.apirest.repositories.model

import com.codetecuhtli.apirest.models.Person
import javax.persistence.*

@Entity
@Table(name = "person")
data class PersonEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "_id")
        var id: Long,
        var name: String,
        var phone: String
        ) {

    constructor() : this(0, "", "")

    fun toPerson(): Person = Person(id, name, phone)
}