package neilsayok.github.apilib.model


import com.google.gson.annotations.SerializedName

data class APIResponse(
    @SerializedName("dataObject")
    var dataObject: List<DataObject?>? = listOf(),
    @SerializedName("status")
    var status: Boolean? = false,
    @SerializedName("statusCode")
    var statusCode: Int? = 0
)