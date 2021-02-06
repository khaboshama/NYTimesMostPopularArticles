package com.khaled.nytimesmostpopulararticles.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "article", indices = [Index(value = ["title"])])
data class ArticleItem(
    @PrimaryKey
    @NonNull
    val id: Long,
    @SerializedName("published_date")
    val publishedDate: String?,
    val byline: String?,
    val title: String?,
    @SerializedName("abstract")
    val description: String?,
    @SerializedName("media_url")
    val mediaUrl: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(publishedDate)
        parcel.writeString(byline)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(mediaUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ArticleItem> {
        override fun createFromParcel(parcel: Parcel): ArticleItem {
            return ArticleItem(parcel)
        }

        override fun newArray(size: Int): Array<ArticleItem?> {
            return arrayOfNulls(size)
        }
    }
}