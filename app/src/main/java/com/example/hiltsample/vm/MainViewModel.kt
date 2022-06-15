package com.example.hiltsample.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltsample.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _dataFlow: MutableStateFlow<String> = MutableStateFlow("")
    val dataFlow: StateFlow<String> = _dataFlow.asStateFlow()

    private val _actionFlow: MutableSharedFlow<Action> = MutableSharedFlow()

    init {
        viewModelScope.launch {
            _actionFlow.collectLatest { action ->
                when (action) {
                    is Fetch -> repository.fetch().collectLatest(_dataFlow::emit)
                }
            }
        }
    }

    fun post(action: Action) = viewModelScope.launch { _actionFlow.emit(action) }
}

interface Action

object Fetch : Action