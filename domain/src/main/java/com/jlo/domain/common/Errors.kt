package com.jlo.domain.common

sealed class Errors {
    object NetworkError : Errors()
    object DatabaseError : Errors()
    object UnknownError : Errors()
}
