package com.mobile.techassessmentapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.mobile.techassessmentapp.model.Results
import com.mobile.techassessmentapp.ui.viewholder.MostPopularItemHolder

class MostPopularAdapter(
    var mostPopularList: List<Results>,
    private val itemClick: MostPopularItemHolder.ItemClickListener
) : RecyclerView.Adapter<MostPopularItemHolder>() {

    override fun getItemCount() = mostPopularList.size

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, i: Int): MostPopularItemHolder {
        return MostPopularItemHolder.create(
            LayoutInflater.from(parent.context),
            parent,
            itemClick
        )
    }

    override fun onBindViewHolder(@NonNull holder: MostPopularItemHolder, position: Int) {
        holder.bindData(mostPopularList[position])
    }
}