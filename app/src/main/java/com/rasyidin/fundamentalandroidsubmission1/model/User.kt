package com.rasyidin.fundamentalandroidsubmission1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    var username: String?,
    var name: String?,
    var location: String?,
    var repository: Int?,
    var company: String?,
    var followers: Int?,
    var following: Int?,
    var avatars: Int?
) : Parcelable