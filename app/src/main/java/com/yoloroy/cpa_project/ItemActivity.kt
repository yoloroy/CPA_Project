package com.yoloroy.cpa_project

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.yoloroy.cpa_project.databinding.ActivityItemBinding

class ItemActivity : AppCompatActivity() {

    private lateinit var image: ImageView
    private lateinit var title: TextView
    private lateinit var body: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityItemBinding.inflate(layoutInflater)
        binding.apply {
            image = imageActivityItem
            title = titleActivityItem
            body = bodyActivityItem
        }
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        val titleText = intent.extras?.getString(TITLE) ?: "error"
        val bodyText = intent.extras?.getString(BODY) ?: "error"
        title.text = titleText
        body.text = bodyText
    }

    companion object {
        private const val TITLE = "TITLE"
        private const val BODY = "BODY"

        fun putExtra(intent: Intent, title: String, body: String) {
            intent.apply {
                putExtra(TITLE, title)
                putExtra(BODY, body)
            }
        }
    }
}
