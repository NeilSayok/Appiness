package neilsayok.github.appiness.util.duffutil

import androidx.recyclerview.widget.DiffUtil
import neilsayok.github.apilib.model.Heirarchy

class HeirarchyDiff(val oldHeirarchy: List<Heirarchy>, val newHeirarchy: List<Heirarchy>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldHeirarchy.size

    override fun getNewListSize(): Int = newHeirarchy.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldHeirarchy[oldItemPosition].contactNumber == newHeirarchy[newItemPosition].contactNumber


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldHeirarchy[oldItemPosition] == newHeirarchy[newItemPosition]

}