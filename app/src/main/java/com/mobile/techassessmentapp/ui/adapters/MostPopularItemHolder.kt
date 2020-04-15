package com.mobile.techassessmentapp.ui.adapters

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.mobile.techassessmentapp.R
import com.mobile.techassessmentapp.databinding.ListitemMostpopularBinding
import com.mobile.techassessmentapp.model.Results


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
    fun bindData(result: Results?, isSimple: Boolean = false, showBookmark: Boolean = true) {

        result?.let { binding.textviewTitle.text = it.title }

        setupClickListener(result)
    }


    /**
     * Setup click listener events on views.
     * @param displayItem [ChallengeModel] instance
     */
    private fun setupClickListener(item: Results?) {
        binding.root.setOnClickListener {
            item?.let { item -> callback.onItemClick(item, binding.root) }
        }
    }

    /**
     * Load image from network using [Glide].
     * @param context Calling context.
     * @param thumbLoadUrl Thumbnail image URL for faster load.
     * @param fullImageUrl Full image URL
     */
    private fun loadImage(
        context: Context,
        imageView: ImageView,
        thumbLoadUrl: String
    ) {
        val requestOptions = RequestOptions()
            .placeholder(ColorDrawable(ContextCompat.getColor(context, R.color.lightGrey)))
            .error(ColorDrawable(ContextCompat.getColor(context, R.color.lightGrey)))
            .format(DecodeFormat.PREFER_RGB_565)
        Glide.with(context)
            .load(thumbLoadUrl)
            .dontAnimate()
            .apply(requestOptions)
            //.listener(ImageRequestListener(this))
            /*.fitCenter()*/
            .into(imageView)
    }
}
