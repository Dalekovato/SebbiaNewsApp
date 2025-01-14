package com.example.sebbianewsapp.presentation.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.sebbianewsapp.presentation.ViewModel.BriefViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BriefScreen(
    id: Long,
    onDetailsScreen: (Long) -> Unit,
) {

    val briefViewModel: BriefViewModel = hiltViewModel()
    val data = briefViewModel.getBrief(id).collectAsLazyPagingItems()



    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(top = 40.dp)
    ) {

        items(data.itemSnapshotList) { post ->
            post?.let {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                                onDetailsScreen(it.id.toLong())
                        }
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onPrimary),
                    shape = MaterialTheme.shapes.small,
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    )
                ) {

                    Column(Modifier.padding(5.dp)) {
                        Text(text = ParseDate(it.date) + "\n")
                        Text(text = it.title + "\n")
                        Text(text = it.shortDescription + "\n")
                    }

                }
            }?: run {
                Text(text = "Loading...")
            }

        }
    }


}


@Composable
fun ParseDate(oldDate: String): String {

    // Создаем объект SimpleDateFormat
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    sdf.timeZone = TimeZone.getTimeZone("UTC")

    // Преобразуем строку в Date
    val date: Date = sdf.parse(oldDate)

    return date.toString()

}






