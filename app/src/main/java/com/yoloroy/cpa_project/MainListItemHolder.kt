package com.yoloroy.cpa_project

import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.yoloroy.cpa_project.databinding.ListItemMainBinding
import kotlin.properties.Delegates

// TODO image resource container
class MainListItemHolder : ViewHolder<ListItemMainBinding> {

    private lateinit var root: LinearLayout
    private lateinit var image: ImageView
    private lateinit var title: TextView
    private lateinit var body: TextView

    var state by Delegates.observable(State()) { _, oldState, newState ->
        if (newState.title != oldState.title) {
            title.text = newState.title
        }
        if (newState.body != oldState.body) {
            body.text = newState.body
        }
        if (newState.onClick != oldState.onClick) {
            root.setOnClickListener { newState.onClick.invoke() }
        }
    }

    companion object : ViewHolder.Companion<ListItemMainBinding> {
        override fun bind(binding: ListItemMainBinding) = MainListItemHolder().apply {
            root = binding.root
            image = binding.imageFragmentMainListItem
            title = binding.titleFragmentMainListItem
            body = binding.bodyFragmentMainListItem
        }
    }

    data class State(
        val title: String = "",
        val body: String = "",
        val onClick: () -> Unit = {}
    )
}
