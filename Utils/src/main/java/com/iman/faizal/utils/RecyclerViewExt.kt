package com.iman.faizal.utils

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Iman Faizal on 21/May/2022
 **/

fun RecyclerView.addVerticalItemDecoration() {
    addItemDecoration(
        DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
    )
}

fun RecyclerView.addHorizontalItemDecoration() {
    addItemDecoration(
        DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL)
    )
}