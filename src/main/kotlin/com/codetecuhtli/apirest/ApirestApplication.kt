package com.codetecuhtli.apirest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.i18n.SessionLocaleResolver
import java.util.*
import javax.validation.Validator

@SpringBootApplication
class ApirestApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<ApirestApplication>(*args)
        }
    }

    @Bean
    fun localeResolver(): LocaleResolver? = SessionLocaleResolver().apply {
        setDefaultLocale(Locale.getDefault())
    }

    @Bean
    fun messageSource(): ResourceBundleMessageSource? = ResourceBundleMessageSource().apply {
        setBasenames("i18n/messages")
        setUseCodeAsDefaultMessage(true)
    }

    @Bean
    fun validator(messageSource: MessageSource?): Validator? = LocalValidatorFactoryBean().apply {
        setValidationMessageSource(messageSource!!)
    }

}