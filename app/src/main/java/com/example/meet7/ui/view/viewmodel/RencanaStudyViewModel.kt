package com.example.meet7.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import com.example.meet7.model.RencanaStudy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RencanaStudyViewModel : ViewModel() { //menyimpan dan memperbarui data mata kuliah dan kelas
    private val _krsState = MutableStateFlow(RencanaStudy())
    val krsStateUi: StateFlow<RencanaStudy> = _krsState.asStateFlow()

    fun setMataKuliah(mkPilihan: String) {
        _krsState.update { stateMK ->
            stateMK.copy(namaMK = mkPilihan)
        }
    }

    fun setKelas(kelasPilihan: String) {
        _krsState.update { stateKelas ->
            stateKelas.copy(kelas = kelasPilihan)
        }
    }

    fun saveDataKRS(ls: MutableList<String>) {
        if (ls.size >= 2) {
            _krsState.update { statusSaatIni ->
                statusSaatIni.copy(
                    namaMK = ls[0],
                    kelas = ls[1]
                )
            }
        }
    }
}