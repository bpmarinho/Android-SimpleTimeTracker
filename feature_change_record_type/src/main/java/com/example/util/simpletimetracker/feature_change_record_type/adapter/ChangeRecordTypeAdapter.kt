package com.example.util.simpletimetracker.feature_change_record_type.adapter

import com.example.util.simpletimetracker.core.adapter.BaseRecyclerAdapter
import com.example.util.simpletimetracker.core.adapter.ViewHolderType
import com.example.util.simpletimetracker.core.adapter.color.ColorAdapterDelegate
import com.example.util.simpletimetracker.core.viewData.ColorViewData
import com.example.util.simpletimetracker.feature_change_record_type.viewData.ChangeRecordTypeIconViewData

class ChangeRecordTypeAdapter(
    onColorItemClick: ((ColorViewData) -> Unit),
    onIconItemClick: ((ChangeRecordTypeIconViewData) -> Unit)
) : BaseRecyclerAdapter() {

    init {
        delegates[ViewHolderType.VIEW] = ColorAdapterDelegate(onColorItemClick)
        delegates[ViewHolderType.VIEW2] = ChangeRecordTypeIconAdapterDelegate(onIconItemClick)
    }
}