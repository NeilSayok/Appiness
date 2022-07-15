package neilsayok.github.appiness.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import neilsayok.github.appiness.databinding.ActivityMainBinding
import neilsayok.github.appiness.ui.Main.MainActiviityViewModel
import neilsayok.github.appiness.util.adapter.MainRVAdapter


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainActiviityViewModel
    val rvAdapter by lazy { MainRVAdapter() }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this)[MainActiviityViewModel::class.java]
        run {
            mainViewModel.getHierarchy()
            binding.progressBar.visibility = View.VISIBLE
        }


        mainViewModel.hierarchyList.observe(this@MainActivity, Observer {
            rvAdapter.updateList(it)
            binding.progressBar.visibility = View.GONE
        })

        val layoutmanager = LinearLayoutManager(this)

        binding.mainRV.adapter = rvAdapter
        binding.mainRV.layoutManager = layoutmanager

        val dividerItemDecoration = DividerItemDecoration(
            binding.mainRV.context,
            layoutmanager.orientation
        )

        binding.mainRV.addItemDecoration(dividerItemDecoration)


        binding.searchTIL.editText?.addTextChangedListener {
            //val s : String = it.toString()
            mainViewModel.filetr(it.toString())
        }












    }
}