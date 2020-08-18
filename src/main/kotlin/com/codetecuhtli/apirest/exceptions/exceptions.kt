package com.codetecuhtli.apirest.exceptions

import java.lang.Exception

class NotFoundException(var key: String? = null, message: String? = null): Exception(message)

class BadRequestException(var key: String? = null, message: String? = null): Exception(message)