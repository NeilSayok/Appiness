package neilsayok.github.apilib.model


import com.google.gson.annotations.SerializedName

data class MyHierarchy(
    @SerializedName("heirarchyList")
    var heirarchyList: List<Heirarchy> = listOf()
)