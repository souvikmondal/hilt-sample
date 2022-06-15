package com.example.hiltsample.repo

import kotlinx.coroutines.flow.Flow

interface Repository {

    fun fetch(): Flow<String>
}