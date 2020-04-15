package com.mobile.techassessmentapp.ui.viewholder

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.mobile.techassessmentapp.R
import com.mobile.techassessmentapp.databinding.ListitemMostpopularBinding
import com.mobile.techassessmentapp.model.Results
import com.skydoves.githubfollows.extension.loadImage


class MostPopularItemHolder(
    private val binding: ListitemMostpopularBinding,
    private val callback: ItemClickListener
) : RecyclerView.ViewHolder(binding.root) {
    companion object {

        /**
         * Create Instance of [DisplayItemHolder] which will be used by adapter
         * @param inflater [LayoutInflater] instance for populating layout
         * @param parent [ViewGroup] instance from parent view.
         * @param callback [DisplayItemClickListener] instance for item click events
         * @param profileClickable Profile Clickable state
         *
         * @return [DisplayItemHolder] instance
         */
        fun create(
            inflater: LayoutInflater,
            parent: ViewGroup, callback: ItemClickListener
        ): MostPopularItemHolder {
            val itemListBinding = ListitemMostpopularBinding.inflate(inflater, parent, false)
            return MostPopularItemHolder(
                itemListBinding,
                callback
            )
        }
    }

    interface ItemClickListener {
        fun onItemClick(result: Results, view: View)
    }

    /**
     * Binds data to layout view against [DisplayItem] item.
     * @param displayItem [DisplayItem] instance for reading values
     */
    fun bindData(result: Results?) {

        result?.let {
            binding.textviewTitle.text = it.title
            binding.textviewPreparedby.text = it.byline

            if (!it.media.isNullOrEmpty()) {
                loadImage(
                    binding.imageviewItemimage.context,
                    binding.imageviewItemimage,
                    it.media[0].media_metadata[0].url
                )
            }

        }

        setupClickListener(result)
    }


    /**
     * Setup click listener events on views.
     * @param displayItem [ResultModel] instance
     */
    private fun setupClickListener(item: Results?) {
        binding.root.setOnClickListener {
            item?.let { item -> callback.onItemClick(item, binding.root) }
        }
    }
}
