package com.ato.sonic_ui.nasa.apod


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ato.sonic_ui.video.YoutubePlayer
import com.ato.ui_state.nasa.apod.ApodUiState
import com.ato.ui_state.nasa.apod.MediaTypeUi


@Composable
fun Apod(
    uiState: ApodUiState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
    ) {
        when (uiState.mediaType) {
            MediaTypeUi.IMAGE -> MyImageComposable(uiState.url)
            MediaTypeUi.YOUTUBE -> YoutubePlayer(uiState.url /*LocalLifecycleOwner.current*/)
//            MediaTypeUi.VIDEO -> VideoPlayer(Uri.parse(uiState.url))
            else -> Text("Media type is not supported ${uiState.mediaType}")
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = uiState.title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = uiState.explanation,
            textAlign = TextAlign.Start,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = uiState.date,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
        )
    }
}

@Composable
fun MyImageComposable(url: String) {
//    var imageWidth by remember { mutableIntStateOf(0) }
//    var imageHeight by remember { mutableIntStateOf(0) }
//    val context = LocalContext.current
//    val imageLoader = ImageLoader(context)
//    val coroutineScope = rememberCoroutineScope()
//
//    LaunchedEffect(url) {
//        val request = ImageRequest.Builder(context)
//            .data(url)
//            .allowHardware(false) // Важно для получения размеров
//            .build()
//
//        val result = (imageLoader.execute(request) as? SuccessResult)?.drawable
//        result?.intrinsicWidth?.let { width ->
//            imageWidth = width
//        }
//        result?.intrinsicHeight?.let { height ->
//            imageHeight = height
//        }
//    }
//
//    AsyncImage(
//        model = ImageRequest.Builder(LocalContext.current)
//            .data(url)
//            .crossfade(true)
//            .build(),
////        placeholder = painterResource(R.drawable.placeholder_view_vector),
//        contentDescription = null,
//        contentScale = ContentScale.None,
//        modifier = Modifier
//            .fillMaxWidth()
//    )
}

@Composable
private fun ApodImage(
    uiState: ApodUiState
) {
//    val context = LocalContext.current
//    var isClicked by remember { mutableStateOf(false) }
//
//    AsyncImage(
//        model = ImageRequest.Builder(LocalContext.current)
//            .data(uiState.url)
//            .crossfade(true)
//            .build(),
////        placeholder = painterResource(R.drawable.placeholder_view_vector),
//        contentDescription = null,
//        contentScale = ContentScale.Crop,
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable { isClicked = true }
//    )
//
//    if (isClicked) {
//        isClicked = false
//        setWallpaper(context, uiState.hdurl)
//    }
}

@Composable
private fun setWallpaper(imageUrl: String) {
//    val imageLoader = ImageLoader(context)
//    val request = ImageRequest.Builder(context)
//        .data(imageUrl)
//        .build()
//
//    val wallpaperManager = WallpaperManager.getInstance(context)
//
//    // This coroutine will run in the background to fetch the image and set it as wallpaper
//    LaunchedEffect(imageUrl) {
//        withContext(Dispatchers.IO) {
//            val result = (imageLoader.execute(request) as SuccessResult).drawable
//            val bitmap = (result as BitmapDrawable).bitmap
//
//            // Get screen dimensions
//            val displayMetrics = context.resources.displayMetrics
//            val screenWidth = displayMetrics.widthPixels
//            val screenHeight = displayMetrics.heightPixels
//
//            // Resize bitmap to fit the screen
//            val resizedBitmap = Bitmap.createScaledBitmap(bitmap, screenWidth, screenHeight, true)
//
//            wallpaperManager.setBitmap(resizedBitmap)
//        }
//    }
}