package com.mobile.techassessmentapp.ui.activity.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.mobile.techassessmentapp.R
import com.mobile.techassessmentapp.databinding.ActivityDetailBinding
import com.mobile.techassessmentapp.model.Results
import com.mobile.techassessmentapp.ui.activity.base.BaseActivity
import com.skydoves.githubfollows.extension.loadImage
import com.skydoves.githubfollows.extension.vm
import kotlinx.android.synthetic.main.toolbar_default.*
import kotlinx.android.synthetic.main.toolbar_default.view.*
import javax.inject.Inject

/**
 * Developed by skydoves on 2018-01-27.
 * Copyright (c) 2018 skydoves rights reserved.
 */

class DetailActivity : BaseActivity() {

    private val viewModel by lazy { vm(viewModelFactory, DetailActivityViewModel::class) }

    private lateinit var dataItem: Results

    override fun getContentView(): Int {
        return R.layout.activity_detail
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeListeners()
        dataItem = getDataItemfromIntent()
        initializeUI()
    }

    private fun initializeListeners() {
        //binding.
        //toolbar.toolbar_home?.setOnClickListener { onBackPressed() }
    }

    private fun initializeUI() {

        dataItem?.let {
            binding.textviewTitle.text = it.title
            binding.textviewDesscription.text = it.abstract
            binding.textviewDate.text = it.published_date

            if (!it.media.isNullOrEmpty()) {
                loadImage(
                    binding.imageviewItemimage.context,
                    binding.imageviewItemimage,
                    it.media[0].media_metadata[0].url
                )
            }

        }
    }

    private fun observeViewModel() {
//        viewModel.setUser(getLoginFromIntent())
//        observeLiveData(viewModel.githubUserLiveData) { updateUI(it) }
    }

//    private fun updateUI(resource: Resource<GithubUser>) {
//        when (resource.status) {
//            Status.SUCCESS -> {
//                resource.data?.let {
//                    binding.detailHeader.githubUser = it
//                    binding.executePendingBindings()
//
//                    val itemList = ArrayList<ItemDetail>()
//                    itemList.add(
//                        ItemDetail(
//                            fromResource(this, R.drawable.ic_person_pin),
//                            it.html_url
//                        )
//                    )
//                    it.company?.let {
//                        itemList.add(
//                            ItemDetail(
//                                fromResource(
//                                    this,
//                                    R.drawable.ic_people
//                                ), it
//                            )
//                        )
//                    }
//                    it.location?.let {
//                        itemList.add(
//                            ItemDetail(
//                                fromResource(
//                                    this,
//                                    R.drawable.ic_location
//                                ), it
//                            )
//                        )
//                    }
//                    it.blog?.let {
//                        itemList.add(
//                            ItemDetail(
//                                fromResource(
//                                    this,
//                                    R.drawable.ic_insert_link
//                                ), it
//                            )
//                        )
//                    }
//                    adapter.addItemDetailList(itemList)
//                    detail_body_recyclerViewFrame.addVeiledItems(itemList.size)
//
//                    GlideUtils.getSvgRequestBuilder(this)
//                        .load("${getString(R.string.ghchart)}${it.login}")
//                        .listener(object : RequestListener<PictureDrawable> {
//                            override fun onLoadFailed(
//                                e: GlideException?,
//                                model: Any?,
//                                target: Target<PictureDrawable>?,
//                                isFirstResource: Boolean
//                            ): Boolean {
//                                detail_body_recyclerViewFrame.unVeil()
//                                detail_body_veilLayout.unVeil()
//                                return false
//                            }
//
//                            override fun onResourceReady(
//                                resource: PictureDrawable?,
//                                model: Any?,
//                                target: Target<PictureDrawable>?,
//                                dataSource: DataSource?,
//                                isFirstResource: Boolean
//                            ): Boolean {
//                                detail_body_recyclerViewFrame.unVeil()
//                                detail_body_veilLayout.unVeil()
//                                return false
//                            }
//                        })
//                        .into(detail_body_contributes)
//                }
//            }
//            Status.ERROR -> toast(resource.message.toString())
//            Status.LOADING -> Unit
//        }
//    }

    private fun getDataItemfromIntent(): Results {
        return intent.getParcelableExtra<Results>(INTENT_DATA)
    }

//    private fun getAvatarFromIntent(): String {
//        return intent.getStringExtra(intent_avatar)
//    }

    companion object {
        const val INTENT_DATA = "intent_data"
//        const val intent_avatar = "avatar_url"
//        const val intent_requestCode = 1000

        fun startActivity(activity: Activity, dataItem: Results) {
//            if (activity.checkIsMaterialVersion()) {
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(INTENT_DATA, dataItem)
            activity.startActivity(intent)
//            } else {
//                activity.startActivityForResult<DetailActivity>(
//                    intent_requestCode,
//                    intent_login to githubUser.login,
//                    intent_avatar to githubUser.avatar_url
//                )
//            }
        }
    }
}
