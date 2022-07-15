package neilsayok.github.appiness.ui.Main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import neilsayok.github.apilib.api.ResponseAPI
import neilsayok.github.apilib.api.RetrofitBuilder
import neilsayok.github.apilib.model.APIResponse
import neilsayok.github.apilib.model.Heirarchy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActiviityViewModel: ViewModel() {

    val hierarchyList = MutableLiveData<List<Heirarchy>>()
    private lateinit var localList: List<Heirarchy>

    companion object{
        private val api: ResponseAPI  = RetrofitBuilder.getRetrofitBuilder().create(ResponseAPI::class.java)

    }

    fun getHierarchy(){
        viewModelScope.launch {
            api.getmyHierarchy().enqueue(object : Callback<APIResponse>{
                override fun onResponse(call: Call<APIResponse>, response: Response<APIResponse>) {
                    try {
                        Log.i("Response", response.body().toString())
                        if (response.isSuccessful){
                            val l = mutableListOf<Heirarchy>()
                            for (dObj in response.body()?.dataObject!!)
                                for(h in dObj?.myHierarchy!!){
                                    if (h != null) {
                                        l.addAll(h.heirarchyList)
                                    }
                                }

                            hierarchyList.value = l
                            localList = l
                        }
                    }catch (e: Exception){
                        e.printStackTrace()
                    }
                }

                override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                    t.printStackTrace()
                }

            })
        }
    }

    fun filetr(filterStr: String?){
        Log.d("filterStr",filterStr.toString())
        if (!filterStr.isNullOrEmpty()){
            var l = hierarchyList.value
            l = l?.filter { s -> s.contactName!!.contains(filterStr) }
            hierarchyList.value = l ?: emptyList<Heirarchy>()
        }else{
            hierarchyList.value = localList
        }

    }








}