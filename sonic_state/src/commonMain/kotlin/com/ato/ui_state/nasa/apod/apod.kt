package com.ato.ui_state.nasa.apod


data class ApodUiState(
    val copyright: String,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val mediaType: MediaTypeUi?,
    val serviceVersion: String,
    val title: String,
    val url: String
)

enum class MediaTypeUi{
    VIDEO, YOUTUBE, IMAGE;
}

fun String.isYoutubeUrl(): Boolean {
    val regex = Regex("""(?:https?://)?(?:www\.)?(youtube\.com|youtu\.be)(/[^"&?/ ]*)?""")
    return regex.containsMatchIn(this)
}


fun String.extractYoutubeVideoId(): String {
    val regex = Regex("""(?:https?://)?(?:www\.)?(?:youtube\.com/(?:[^/]+/.+/|(?:v|e(?:mbed)?)/|.*[?&]v=)|youtu\.be/)([^"&?/ ]{11})""")
    val matchResult = regex.find(this)
    return matchResult?.groups?.get(1)?.value.orEmpty()
}