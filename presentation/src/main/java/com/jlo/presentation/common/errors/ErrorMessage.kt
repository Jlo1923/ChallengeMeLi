package com.jlo.presentation.common.errors

import com.jlo.domain.common.Errors

interface ErrorMessage {
    fun getMessage(error: Errors?): String
}
