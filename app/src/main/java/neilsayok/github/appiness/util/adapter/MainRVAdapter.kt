package neilsayok.github.appiness.util.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import neilsayok.github.apilib.model.Heirarchy
import neilsayok.github.appiness.databinding.ItemRvHierarchyBinding
import neilsayok.github.appiness.util.duffutil.HeirarchyDiff


class MainRVAdapter : RecyclerView.Adapter<MainRVAdapter.MainRVViewHolder>() {

    val heirarchyList = mutableListOf<Heirarchy>()
    private lateinit var mCtx: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRVViewHolder {
        val binding = ItemRvHierarchyBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        mCtx = parent.context
        return MainRVViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainRVViewHolder, position: Int) {
        with(holder.binding) {
            with(heirarchyList[position]) {
                contactNameTv.text = contactName
                designationTv.text = designationName
                callIv.setOnClickListener {
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel:${contactNumber}")
                    mCtx.startActivity(intent)
                }
                messageIv.setOnClickListener{
                    val smsIntent = Intent(Intent.ACTION_VIEW)
                    smsIntent.data = Uri.parse("sms:${contactNumber}")
                    mCtx.startActivity(smsIntent)
                }
            }
        }
    }

    override fun getItemCount(): Int = heirarchyList.size

    public fun updateList(newHierarchyList: List<Heirarchy>) {
        val hierarchyDiff = HeirarchyDiff(heirarchyList, newHierarchyList)
        val diffresult = DiffUtil.calculateDiff(hierarchyDiff)

        heirarchyList.clear()
        heirarchyList.addAll(newHierarchyList)
        diffresult.dispatchUpdatesTo(this)

    }


    class MainRVViewHolder(val binding: ItemRvHierarchyBinding) :
        RecyclerView.ViewHolder(binding.root)

}