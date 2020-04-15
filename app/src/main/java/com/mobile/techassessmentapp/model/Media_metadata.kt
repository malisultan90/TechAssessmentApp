package com.mobile.techassessmentapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Media_metadata(

    @SerializedName("url") val url: String,
    @SerializedName("format") val format: String,
    @SerializedName("height") val height: Int,
    @SerializedName("width") val width: Int
) : Parcelable