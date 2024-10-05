package com.ato.ui_state.base.image

data class UiImagePicker(
    val imageUrl: String?,
    val imageFile: ByteArray? = null,
    val showFileChooser: Boolean = false,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as UiImagePicker

        if (imageUrl != other.imageUrl) return false
        if (imageFile != null) {
            if (other.imageFile == null) return false
            if (!imageFile.contentEquals(other.imageFile)) return false
        } else if (other.imageFile != null) return false
        if (showFileChooser != other.showFileChooser) return false

        return true
    }

    override fun hashCode(): Int {
        var result = imageUrl?.hashCode() ?: 0
        result = 31 * result + (imageFile?.contentHashCode() ?: 0)
        result = 31 * result + showFileChooser.hashCode()
        return result
    }
}
