package com.example.jectpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.CrossFade
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.jectpack.model.Movie
import com.example.jectpack.retrofit.RetrofitApi
import com.example.jectpack.viewmodel.LatestMoviesViewModel

class MovieListActivity : ComponentActivity() {
    private val viewModel: LatestMoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Preview()
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.fetchMovies()
    }

    @Preview(showSystemUi = true)
    @Composable
    private fun Preview() {
        DisplayList()
    }

    @Composable
    private fun DisplayList() {
        val movies = viewModel.movie.observeAsState(emptyList())

        Column {
            if (movies.value.isEmpty()) {
                Text(text = "Loading.....")
            } else {
                LazyColumn {
                    items(movies.value) { movie ->
                        CardMovie(movie = movie)
                        Divider(modifier = Modifier.padding(15.dp,0.dp))
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    private fun CardMovie(movie: Movie) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier.padding(10.dp),
            colors = CardDefaults.cardColors(containerColor= Color.White),
        ) {
            Row{
                GlideImage(
                    model = RetrofitApi.BASE_URL_IMAGE_200 + movie.posterPath,
                    contentDescription = "",
                    modifier = Modifier.padding(10.dp),
                    transition = CrossFade
                )

                Column(modifier = Modifier.padding(10.dp)) {
                    Text(text = movie.title ?: "", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text(text = movie.title ?: "")
                    Text(text = movie.releaseDate ?: "")
                    Text(text = movie.overview ?: "")
                }


            }
        }
    }
}