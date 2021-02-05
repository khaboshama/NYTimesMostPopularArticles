package com.khaled.nytimesmostpopulararticles.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Article(
    val id: Long,
    @SerializedName("published_date")
    val publishedDate: String?,
    val byline: String?,
    val title: String?,
    @SerializedName("abstract")
    val description: String?,
    @SerializedName("media")
    val mediaList: List<Media>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        arrayListOf<Media>().apply {
            parcel.readList(this as List<Media>, Media::class.java.classLoader)
        }
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(publishedDate)
        parcel.writeString(byline)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeList(mediaList)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Article> {
        override fun createFromParcel(parcel: Parcel): Article {
            return Article(parcel)
        }

        override fun newArray(size: Int): Array<Article?> {
            return arrayOfNulls(size)
        }
    }
}