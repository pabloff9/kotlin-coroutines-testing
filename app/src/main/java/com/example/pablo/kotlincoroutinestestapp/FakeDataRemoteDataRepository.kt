package com.example.pablo.kotlincoroutinestestapp

import kotlinx.coroutines.experimental.delay

class FakeDataRemoteDataRepository : RemoteDataRepository {

    suspend override fun getRemoteData(): String {
        delay(3000L)
        return "Remote data!"
    }

    suspend override fun getMoreRemoteData(dataFromTheFirstRequest: String): Int {
        delay(3000L)
        return 35
    }

    suspend override fun getMoreRemoteData2(dataFromTheFirstRequest: String): Double {
        delay(4000L)
        return 1.5
    }

    suspend override fun getTheLastPieceOfRemoteData(dataFromTheSecondRequest1: Int,
                                                     dataFromTheSecondRequest2: Double): ArrayList<String> {
        delay(1000L)
        return arrayListOf("Result!", "Result 2!")
    }
}