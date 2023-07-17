package com.example.webviewlearning.core.base

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import kotlinx.parcelize.Parcelize
import org.mongodb.kbson.ObjectId

class LinkModel : RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId()
    var name = ""
    var link = ""
    var description = ""

    fun convertToLocalItem() = LinkItem(
        id.toString(), name, link, description
    )
}

@Parcelize
data class LinkItem(
    var id: String,
    val name: String,
    val link: String,
    val description: String,
): Parcelable

/*@Parcelize
data class Status(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
) : Parcelable*/

