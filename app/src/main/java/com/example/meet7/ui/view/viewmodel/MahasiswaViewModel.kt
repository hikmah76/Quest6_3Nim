package com.example.meet7.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import com.example.meet7.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel: ViewModel() { //untuk memperbarui status mahasiswa
    private val _mahasiswaUiState = MutableStateFlow(Mahasiswa())

    val mahasiswaUiState: StateFlow<Mahasiswa> = _mahasiswaUiState.asStateFlow()

    fun saveDataMahasiswa(ls: MutableList<String>) {
        _mahasiswaUiState.update { statusSaatIni ->
            statusSaatIni.copy(
                nim = ls[0],
                nama = ls[1],
                email = ls[2]
            )
        }
    }
}
