package com.example.meet7.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

import com.example.meet7.ui.view.screen.SplashView
import com.example.meet7.ui.view.viewmodel.MahasiswaViewModel
import com.example.meet7.ui.view.viewmodel.RencanaStudyViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meet7.ui.view.screen.MahasiswaFormView
import com.example.meet7.ui.view.screen.RencanaStudyView



enum class Halaman{
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}
@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
  val mahasiswaUiState = mahasiswaViewModel.mahasiswaUiState.collectAsState().value

    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = modifier.padding()
    ) {
        composable(route = Halaman.Splash.name) {
            SplashView (onMulaiButton = {
                navController.navigate(Halaman.Mahasiswa.name)
            })

        }
        composable(route = Halaman.Mahasiswa.name){
            MahasiswaFormView(
                onSumbitButtonClicked = {
                    mahasiswaViewModel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.Matakuliah.name)
                },
                onBackButtonCliked = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Halaman.Matakuliah.name){
            RencanaStudyView(mahasiswa = mahasiswaUiState,
                onSumbmitButtonClicked = {krsViewModel.saveDataKRS(it)},
                onBackButtonClicked = {navController.popBackStack()}
            )
        }
    }
}