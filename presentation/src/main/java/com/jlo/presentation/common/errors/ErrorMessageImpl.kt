package com.jlo.presentation.common.errors

import android.content.Context
import com.jlo.domain.common.Errors
import com.jlo.presentation.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ErrorMessageImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ErrorMessage {

    override fun getMessage(error: Errors?): String = when (error) {
        Errors.NetworkError -> context.getString(R.string.error_msg_network)
        else -> context.getString(R.string.error_msg_database)
    }
}
