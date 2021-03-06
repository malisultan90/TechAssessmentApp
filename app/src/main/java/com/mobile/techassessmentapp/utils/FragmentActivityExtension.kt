/*
 * The MIT License (MIT)
 *
 * Designed and developed by 2018 skydoves (Jaewoong Eum)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.skydoves.githubfollows.extension

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.mobile.techassessmentapp.R
import kotlin.reflect.KClass

/**
 * Developed by skydoves on 2019-06-07.
 * Copyright (c) 2018 skydoves rights reserved.
 */

fun <T : ViewModel> FragmentActivity.vm(factory: ViewModelProvider.Factory, model: KClass<T>): T {
    return ViewModelProviders.of(this, factory).get(model.java)
}


fun loadImage(
    context: Context,
    imageView: ImageView,
    url: String
) {
    val requestOptions = RequestOptions()
        .placeholder(ColorDrawable(ContextCompat.getColor(context, R.color.dark_grey)))
        .error(ColorDrawable(ContextCompat.getColor(context, R.color.dark_grey)))
        .format(DecodeFormat.PREFER_RGB_565)
    Glide.with(context)
        .load(url)
        .apply(requestOptions)
        .apply(RequestOptions.circleCropTransform())
        .into(imageView)
}