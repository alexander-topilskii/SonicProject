package com.ato.helpers

import coil3.PlatformContext
import okio.Path
import okio.Path.Companion.toOkioPath

actual fun getCacheDir(context: PlatformContext): Path {
   return context.cacheDir.toOkioPath()
}