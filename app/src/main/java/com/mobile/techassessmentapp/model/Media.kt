package com.mobile.techassessmentapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Media(

    @SerializedName("type") val type: String,
    @SerializedName("subtype") val subtype: String,
    @SerializedName("caption") val caption: String,
    @SerializedName("copyright") val copyright: String,
    @SerializedName("approved_for_syndication") val approved_for_syndication: Int,
    @SerializedName("media-metadata") val media_metadata: List<Media_metadata>
) : Parcelable