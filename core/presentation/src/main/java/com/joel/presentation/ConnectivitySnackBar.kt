package com.joel.presentation

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun NetworkStatusSnackBar(
    networkViewModel: ConnectivityViewModel = viewModel(factory = ViewModelFactory.Factory),
    snackbarHostState: SnackbarHostState
) {
    val isOffline by networkViewModel.isOffline.collectAsState()

    // If the user is not connected to the internet show a snack bar to inform them.
    val notConnectedMessage = stringResource(R.string.not_connected)

    LaunchedEffect(isOffline) {
        if (isOffline) {
            snackbarHostState.showSnackbar(
                message = notConnectedMessage,
                duration = SnackbarDuration.Indefinite,
            )
        }
    }

}