package com.example.sebbianewsapp.presentation.Screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sebbianewsapp.presentation.ViewModel.CategoryViewModel

@Composable
fun CategoryScreen(onBriefNews:(Long) -> Unit) {

    val categoryViewModel: CategoryViewModel = hiltViewModel()
    val category by categoryViewModel.all.observeAsState(emptyList())


    Column(
        modifier = Modifier
            .padding(40.dp)
            .fillMaxSize()
    ) {

        Text(
            text = "Категории",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = Color.Blue,
            fontSize = 25.sp,
            fontFamily = FontFamily.Serif
        )


        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(16.dp)

        ) {

            items(category){category->
                val id : Long = category.id.toLong()
                Button(
                    onClick = {
                        onBriefNews(id)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = category.name)
                }

            }

        }
    }

}

