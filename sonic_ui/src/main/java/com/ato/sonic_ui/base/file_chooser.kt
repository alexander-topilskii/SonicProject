package com.ato.sonic_ui.base

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader

object LoadOptions {
    const val PLAIN_TEXT = "text/plain"
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MyApp() {
    var fileContent by remember { mutableStateOf("Press button to load text") }
    val readFilesLauncher by getLauncher(onStartLoading = {

    }) { loadedText ->
        fileContent = loadedText
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("File Picker Example") })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            Button(onClick = { readFilesLauncher.launch(LoadOptions.PLAIN_TEXT) }) {
                Text("Pick a Text File")
            }
            Text(text = fileContent)
        }
    }
}

@Composable
fun getLauncher(
    onStartLoading: () -> Unit = {},
    onLoaded: (String) -> Unit = {}
): State<ActivityResultLauncher<String>> {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {

            scope.launch {
                onStartLoading()
                val text = withContext(Dispatchers.IO) {
                    readTextFromUri(context, it)
                }

                onLoaded(text)
            }
        }
    }

    return rememberUpdatedState(launcher)
}

fun readTextFromUri(context: Context, uri: Uri): String {
    val stringBuilder = StringBuilder()
    context.contentResolver.openInputStream(uri)?.use { inputStream ->
        BufferedReader(InputStreamReader(inputStream)).use { reader ->
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                stringBuilder.append(line).append('\n')
            }
        }
    }
    return stringBuilder.toString()
}
