package com.example.pablo.kotlincoroutinestestapp

import kotlinx.coroutines.experimental.delay

/**
 * Created by Pablo on 11/15/2017.
 */
interface RemoteDataRepository {
    suspend fun getRemoteData(): String
    suspend fun getMoreRemoteData(dataFromTheFirstRequest: String): Int
    suspend fun getMoreRemoteData2(dataFromTheFirstRequest: String): Double
    suspend fun getTheLastPieceOfRemoteData(dataFromTheSecondRequest1: Int, dataFromTheSecondRequest2: Double): ArrayList<String>
}