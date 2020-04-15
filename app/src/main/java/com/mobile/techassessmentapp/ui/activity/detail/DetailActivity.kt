package com.mobile.techassessmentapp.ui.activity.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.mobile.techassessmentapp.R
import com.mobile.techassessmentapp.model.Results
import com.mobile.techassessmentapp.ui.activity.base.BaseActivity
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
//    private val binding by lazy {
//        DataBindingUtil.setContentView<ActivityDetailBinding>(
//            this,
//            R.layout.activity_detail
//        )
//    }

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
        //toolbar.toolbar_title?.text = dataItem.title
//        Glide.with(this)
//            .load(getAvatarFromIntent())
//            .apply(RequestOptions().circleCrop().dontAnimate())
//            .listener(object : RequestListener<Drawable> {
//                override fun onLoadFailed(
//                    e: GlideException?,
//                    model: Any?,
//                    target: Target<Drawable>?,
//                    isFirstResource: Boolean
//                ): Boolean {
//                    supportStartPostponedEnterTransition()
//                    observeViewModel()
//                    return false
//                }
//
//                override fun onResourceReady(
//                    resource: Drawable?,
//                    model: Any?,
//                    target: Target<Drawable>?,
//                    dataSource: DataSource?,
//                    isFirstResource: Boolean
//                ): Boolean {
//                    supportStartPostponedEnterTransition()
//                    observeViewModel()
//                    return false
//                }
//            })
//            .into(detail_header_avatar)
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
