package com.ato.sonic_ui.wishlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.ato.ui_state.wishlist.WishlistWish


@Composable
fun DisplayWish(
    wish: WishlistWish,
    onClick: (WishlistWish) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        onClick = remember(wish) { { onClick.invoke(wish) } },
    ) {
        Box {
            if (wish.isCompleted == true) {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 8.dp)
                )
            }
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                wish.name?.let { name ->
                    Text(
                        text = name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }

                Text(
                    text = wish.description.orEmpty(),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Composable
fun DisplayFullWish(
    wish: WishlistWish,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
//        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            wish.name?.let { name ->
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                )
            }

            if (!wish.description.isNullOrEmpty()) {
                Text(
                    text = wish.description.orEmpty(),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            if (!wish.url.isNullOrEmpty()) {
                ClickableUrlText(
                    url = wish.url!!,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

@Composable
fun ClickableUrlText(url: String, modifier: Modifier = Modifier) {
    val uriHandler = LocalUriHandler.current

    val annotatedText = buildAnnotatedString {
        pushStringAnnotation(tag = "URL", annotation = url)
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.error)) {
            append(url)
        }
        pop()
    }

    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations(tag = "URL", start = offset, end = offset)
                .firstOrNull()?.let { annotation ->
                    try {
                        uriHandler.openUri(annotation.item)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
        },
        modifier = modifier
    )
}
