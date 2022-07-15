package neilsayok.github.apilib.api

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class APITest {
    private lateinit var api: ResponseAPI

    @Before
    fun setUp() {
        api = RetrofitBuilder.getRetrofitBuilder().create(ResponseAPI::class.java)
    }

    @Test
    fun `test fetch data`(){
        val res = api.getmyHierarchy().execute()
        println(res.body())
        assertThat(res.body()!!.statusCode).isEqualTo(200)

    }
}