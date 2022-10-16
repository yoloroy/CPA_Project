package com.yoloroy.cpa_project

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.yoloroy.cpa_project.databinding.ActivityMainBinding
import com.yoloroy.cpa_project.databinding.ListItemMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var itemHolders: List<MainListItemHolder>
    private lateinit var list: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        list = binding.listActivityMain
        itemHolders = list.children
            .map {
                val itemBinding = ListItemMainBinding.bind(it)
                return@map MainListItemHolder.bind(itemBinding)
            }
            .toList()
        setContentView(binding.root)
    }

    override fun onStart() {
        itemHolders.forEachIndexed { index, itemHolder ->
            itemHolder.state = MainListItemHolder.State("title $index", "sub title $index") {
                val intent = Intent(this, ItemActivity::class.java)
                ItemActivity.putExtra(intent, "title $index", "sub title $index")
                startActivity(intent)
            }
        }
        super.onStart()
    }
}
