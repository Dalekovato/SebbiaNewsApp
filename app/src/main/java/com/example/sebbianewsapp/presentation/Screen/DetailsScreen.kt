package com.example.sebbianewsapp.presentation.Screen

import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sebbianewsapp.presentation.ViewModel.DetailsViewModel

@Composable
fun DetailsScreen(id:Long) {

    val detailsViewModel: DetailsViewModel = hiltViewModel()
    val category by detailsViewModel.all.collectAsState()

    // Запуск загрузки данных
    LaunchedEffect(id) {
        detailsViewModel.getDetails(id)
    }

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onPrimary),
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            category?.let {
                Text(text = ParseDate(it.date)+"\n")
                Text(text = it.title + "\n")
                Text(text = it.shortDescription + "\n")
                HtmlText(it.fullDescription )
            } ?: run {
                Text(text = "Loading...")
            }
        }
    }

}

@Composable
fun HtmlText(
    html: String,
){
    AndroidView(factory = { context ->
        TextView(context).apply {
            text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY)
            movementMethod = LinkMovementMethod.getInstance() // Позволяет кликабельные ссылки
            linksClickable = true
        }
    })
}