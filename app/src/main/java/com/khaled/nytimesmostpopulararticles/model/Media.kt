package com.khaled.nytimesmostpopulararticles.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Media(@SerializedName("media-metadata") val mediaMetaDataList: List<MediaMetaData>) : Parcelable {

    constructor(parcel: Parcel) : this(
        arrayListOf<MediaMetaData>().apply {
            parcel.readList(this as List<MediaMetaData>, MediaMetaData::class.java.classLoader)
        }
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeList(mediaMetaDataList)
    }

    companion object CREATOR : Parcelable.Creator<Media> {
        override fun createFromParcel(parcel: Parcel): Media {
            return Media(parcel)
        }

        override fun newArray(size: Int): Array<Media?> {
            return arrayOfNulls(size)
        }
    }
}