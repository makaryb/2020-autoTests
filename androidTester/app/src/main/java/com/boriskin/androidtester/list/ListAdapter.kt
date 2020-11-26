package com.boriskin.androidtester.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.boriskin.androidtester.R
import kotlinx.android.synthetic.main.view_list_item.view.viewItemText

class ListAdapter : RecyclerView.Adapter<ListAdapter.Element>() {

    private var items = List(ITEMS_AMOUNT) { idx ->
        "Element $idx"
    }

    private val removeListener: (String) -> Unit = { itemToRemove ->
        val idx = items.indexOf(itemToRemove)
        items = items.filterIndexed { index, _ -> index != idx }
        notifyItemRemoved(idx)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Element =
        Element(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_list_item, parent, false),
            removeListener
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: Element, position: Int) = holder.bind(items[position])

    class Element(view: View, private val removeListener: (String) -> Unit) :
        RecyclerView.ViewHolder(view) {
        fun bind(name: String) = with(itemView) {
            viewItemText.text = name
            viewItemText.setOnClickListener { removeListener(name) }
        }
    }

    companion object {
        const val ITEMS_AMOUNT = 20
    }
}
