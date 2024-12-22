package com.ato.helpers

import coil3.ImageLoader
import coil3.PlatformContext
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.request.crossfade
import coil3.util.DebugLogger

fun getAsyncImageLoader(context: PlatformContext): ImageLoader {
    return ImageLoader.Builder(context)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .memoryCache {
            MemoryCache
                .Builder()
                .maxSizeBytes(500 * 1024 * 1024) // 500 MB
                .strongReferencesEnabled(true)
                .build()
        }
        .crossfade(true)
        .logger(DebugLogger())
        .build()
}
