package com.example.newsapp.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsapp.ui.components.Loader
//import com.example.newsapp.ui.components.NewRowComponent
import com.example.newsapp.ui.components.NewsList
import com.example.newsapp.ui.components.NewsRowComponent

import com.example.newsapp.ui.viewmodel.NewsViewModel
import com.example.utilities.ResourceState

const val TAG="HomeScreen"
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel= hiltViewModel()
){
    val newsRes by newsViewModel.news.collectAsState()
    val pagerState= rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        // provide pageCount
        100
    }


    VerticalPager(state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 20.dp
        ) {page:Int->

        when(newsRes){

            is ResourceState.Loading ->  {
                Log.d(TAG,"Inside Loading")
                Loader()
            }
            is ResourceState.Success -> {
                Log.d(TAG,"Inside Success")
                val response=(newsRes as ResourceState.Success).data
                Log.d( TAG,"INSIDE SUCCESS ${response.status} = ${response.totalResults}")
                if(response.articles.isNotEmpty()){
                    NewsRowComponent(page,response.articles.get(page))
                }

            }
            is ResourceState.Error -> {
                val error= (newsRes as ResourceState.Error)
                Log.d(TAG,"Inside Error i $error")
            }
        }
        
    }

}
@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}