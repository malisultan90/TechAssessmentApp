package com.mobile.techassessmentapp.ui.activity.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobile.techassessmentapp.R
import com.mobile.techassessmentapp.model.Results
import com.mobile.techassessmentapp.ui.activity.base.BaseActivity
import com.mobile.techassessmentapp.ui.activity.detail.DetailActivity
import com.mobile.techassessmentapp.ui.adapter.MostPopularAdapter
import com.mobile.techassessmentapp.ui.viewholder.MostPopularItemHolder
import com.skydoves.githubfollows.extension.vm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MostPopularItemHolder.ItemClickListener {

    private val viewModel by lazy { vm(viewModelFactory, MostPopularViewModel::class) }

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupObservers()
        viewModel.fetchRepoList()
    }

    private fun setupObservers() {

        viewModel.data.observe(this, Observer {
            it?.data?.results?.let { setupAdapter(it) }
        })
    }

    private fun setupAdapter(list: List<Results>) {

        if (list != null) {
            val adapter = MostPopularAdapter(list, this)
            val layoutManager = LinearLayoutManager(this)
            recyclerview_mostpopular_list.layoutManager = layoutManager
            recyclerview_mostpopular_list.addItemDecoration(
                DividerItemDecoration(
                    this,
                    layoutManager.orientation
                )
            )
            recyclerview_mostpopular_list.adapter = adapter
        }
    }

    override fun onItemClick(result: Results, view: View) {
        DetailActivity.startActivity(this, result)
    }
}
