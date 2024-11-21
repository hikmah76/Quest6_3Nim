package com.example.meet7.ui.view.screen

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meet7.R

@Preview(showBackground = true)
@Composable
fun SplashView(
    onMulaiButton: () -> Unit = {}
){
    Column (modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.primary)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
    Image(painter = painterResource(R.drawable.umy),
        contentDescription = "",
        modifier = Modifier.size(50.dp)
    )
        Button(

            onClick = {
                onMulaiButton()
            },
            modifier = Modifier

                .padding(10.dp)
                .size(200.dp, 45.dp)
        ) {
            Text(text = "Mulai")

        }
    }
}