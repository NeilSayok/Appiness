package neilsayok.github.apilib.model


import com.google.gson.annotations.SerializedName

data class Heirarchy(
    @SerializedName("contactName")
    var contactName: String? = "",
    @SerializedName("contactNumber")
    var contactNumber: String? = "",
    @SerializedName("designationName")
    var designationName: String? = ""
)