package com.yoloroy.cpa_project

import android.view.View
import androidx.viewbinding.ViewBinding

interface ViewHolder<Binding : ViewBinding> {

    interface Companion<Binding : ViewBinding> {
        fun bind(binding: Binding): ViewHolder<Binding>
    }
}
