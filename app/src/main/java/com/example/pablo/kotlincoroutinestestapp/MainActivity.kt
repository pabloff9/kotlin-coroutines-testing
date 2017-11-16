package com.example.pablo.kotlincoroutinestestapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class MainActivity : AppCompatActivity() {

    private var repository = FakeDataRemoteDataRepository()
    private lateinit var progressBar: ProgressBar
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById(R.id.progress_bar)
        textView = findViewById(R.id.text_view)

        launch(UI) {

            textView.visibility = INVISIBLE
            progressBar.visibility = VISIBLE

            val finalData = getRemoteData()
            textView.text = finalData[0] + " " + finalData[1]

            textView.visibility = VISIBLE
            progressBar.visibility = INVISIBLE


        }


    }

    private suspend fun getRemoteData(): ArrayList<String> {
        val initialResponse = repository.getRemoteData()
        val moreRemoteDataResponse1 = async { repository.getMoreRemoteData(initialResponse) }
        val moreRemoteDataResponse2 = async { repository.getMoreRemoteData2(initialResponse) }
        return repository.getTheLastPieceOfRemoteData(moreRemoteDataResponse1.await(), moreRemoteDataResponse2.await())
    }
}
