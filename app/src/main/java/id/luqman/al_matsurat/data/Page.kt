package id.luqman.al_matsurat.data

import com.google.gson.annotations.SerializedName

data class Page(
    @SerializedName("no")
    var id: Int,

    @SerializedName("judul")
    var title: String,

    @SerializedName("arab")
    var arabic: String,

    @SerializedName("terjemah")
    var translation: String,

    @SerializedName("pengulangan")
    var repetition: Int
)