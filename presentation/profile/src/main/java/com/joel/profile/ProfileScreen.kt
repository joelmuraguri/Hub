package com.joel.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    popBackStack : () -> Unit
){

    Scaffold(
        topBar = {
           CenterAlignedTopAppBar(
               title = { /*TODO*/ },
               navigationIcon = {
                   IconButton(onClick = {
                       popBackStack()
                   }) {
                       Icon(
                           painter = painterResource(id = R.drawable.arrow_back),
                           tint = MaterialTheme.colorScheme.onBackground,
                           contentDescription = null
                       )
                   }
               }
           )
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "PROFILE")
        }
    }
}