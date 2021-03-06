package com.example.util.simpletimetracker.navigation.params

import android.os.Parcelable
import androidx.annotation.ColorInt
import kotlinx.android.parcel.Parcelize

sealed class ChangeCategoryParams : Parcelable {
    abstract val id: Long

    @Parcelize
    data class Change(
        override val id: Long,
        val preview: Preview? = null
    ) : ChangeCategoryParams() {

        @Parcelize
        data class Preview(
            val name: String,
            @ColorInt val color: Int
        ) : Parcelable
    }

    @Parcelize
    object New : ChangeCategoryParams() {
        override val id: Long get() = 0
    }
}
