package cgy.com.common.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class OneBean(
        val str: String,
        val num: Int
) : Parcelable