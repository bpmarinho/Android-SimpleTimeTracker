package com.example.util.simpletimetracker.feature_dialogs.chartFilter.adapter

import android.view.ViewGroup
import com.example.util.simpletimetracker.core.adapter.BaseRecyclerAdapterDelegate
import com.example.util.simpletimetracker.core.adapter.BaseRecyclerViewHolder
import com.example.util.simpletimetracker.core.adapter.ViewHolderType
import com.example.util.simpletimetracker.core.extension.setOnClickWith
import com.example.util.simpletimetracker.core.viewData.CategoryViewData
import com.example.util.simpletimetracker.feature_dialogs.R
import kotlinx.android.synthetic.main.chart_filter_item_category_layout.view.*

class ChartFilterCategoryAdapterDelegate(
    private val onItemClick: ((CategoryViewData) -> Unit)
) : BaseRecyclerAdapterDelegate() {

    override fun onCreateViewHolder(parent: ViewGroup): BaseRecyclerViewHolder =
        CategoryViewHolder(parent)

    inner class CategoryViewHolder(parent: ViewGroup) :
        BaseRecyclerViewHolder(parent, R.layout.chart_filter_item_category_layout) {

        override fun bind(
            item: ViewHolderType,
            payloads: List<Any>
        ) = with(itemView.viewChartFilterCategoryItem) {
            item as CategoryViewData

            itemColor = item.color
            itemName = item.name
            itemTextColor = item.textColor
            setOnClickWith(item, onItemClick)
        }
    }
}