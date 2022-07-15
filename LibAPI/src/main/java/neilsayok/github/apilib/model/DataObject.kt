package neilsayok.github.apilib.model


import com.google.gson.annotations.SerializedName

data class DataObject(
    @SerializedName("myHierarchy")
    var myHierarchy: List<MyHierarchy?>? = listOf()
)