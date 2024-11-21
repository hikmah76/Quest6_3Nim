package com.example.meet7.ui.view.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.meet7.model.Mahasiswa
import com.example.meet7.model.RencanaStudy

@Composable
fun TampilDataView(
    mahasiswa: Mahasiswa,
    rencanaStudy: RencanaStudy
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Data Mahasiswa", style = androidx.compose.material3.MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        TampilData(
            judul = "NIM",
            isinya = mahasiswa.nim // untuk menampilkan nim
        )
        TampilData(
            judul = "Nama",
            isinya = mahasiswa.nama // untuk menampilkan data nama mahasiswa
        )
        TampilData(
            judul = "Email",
            isinya = mahasiswa.email //untuk menampilkan data email mahasiswa
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Rencana Studi", style = androidx.compose.material3.MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        TampilData(
            judul = "Mata Kuliah",  //untuk menampilkan data pilihan matakulihan mahasiswa
            isinya = rencanaStudy.namaMK
        )
        TampilData(
            judul = "Kelas",
            isinya = rencanaStudy.kelas
        )
    }
}

@Composable
fun TampilData(
    judul: String,
    isinya: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(judul, modifier = Modifier.weight(1f))
        Text(":", modifier = Modifier.weight(0.1f))
        Text(isinya, modifier = Modifier.weight(2f))
    }
}