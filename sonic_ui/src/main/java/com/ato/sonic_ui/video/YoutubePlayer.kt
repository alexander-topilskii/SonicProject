package com.ato.sonic_ui.video

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleOwner

//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@Composable
fun YoutubePlayer(
    youtubeVideoId: String,
    lifecycleOwner: LifecycleOwner
) {

//    AndroidView(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//            .clip(RoundedCornerShape(16.dp)),
//        factory = { context ->
////            YouTubePlayerView(context = context).apply {
////                lifecycleOwner.lifecycle.addObserver(this)
////
////                addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
////                    override fun onReady(youTubePlayer: YouTubePlayer) {
////                        youTubePlayer.loadVideo(youtubeVideoId, 0f)
////                    }
////                })
////            }
//        })
}

@Composable
fun VideoPlayer(
    videoUri: Uri
) {

//    AndroidView(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//            .clip(RoundedCornerShape(16.dp)),
//        factory = { context ->
//            VideoView(context).apply {
//                setVideoURI(videoUri)
//
//                val mediaController = MediaController(context)
//                mediaController.setAnchorView(this)
//
//                setMediaController(mediaController)
//
//                setOnPreparedListener {
//                    start()
//                }
//            }
//        })

}