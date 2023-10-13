package com.example.newsapp.ui.repository

import android.util.Log
import com.example.newsapp.data.datasource.NewsDataSource
import com.example.newsapp.data.entity.NewsResponse
import com.example.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.flow.internal.NopCollector.emit
import retrofit2.Response
import javax.inject.Inject
const val TAG= "ANKIT"
class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {
//    suspend fun getNewsHeadline(country:String):Response<NewsResponse>{
//        return newsDataSource.getNewsHeadline(country)
//    }
    suspend fun getNewsHeadline(country:String): Flow<ResourceState<NewsResponse>> {
    return flow {
        emit(ResourceState.Loading())
        val response = newsDataSource.getNewsHeadline(country )
        if(response.isSuccessful && response.body() !=null){
            Log.d(TAG,"NewsRepository sends successfully")
            emit(ResourceState.Success(response.body()!!))
        } else{

            emit(ResourceState.Error("Error fatching news data"))
        }
    }.catch { e->
        emit(ResourceState.Error(e?.localizedMessage?:"Some error in flow"))
        }
    }

}