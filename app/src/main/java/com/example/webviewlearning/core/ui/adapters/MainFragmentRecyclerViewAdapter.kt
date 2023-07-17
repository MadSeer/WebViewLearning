package com.example.webviewlearning.core.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.webviewlearning.R
import com.example.webviewlearning.core.base.LinkItem
import com.example.webviewlearning.core.base.LinkModel
import com.example.webviewlearning.core.ui.WebView.WebViewActivity
import com.example.webviewlearning.core.ui.main.MainActivity
import com.example.webviewlearning.core.ui.main.MainFragment
import kotlinx.coroutines.NonDisposableHandle.parent

class MainFragmentRecyclerViewAdapter(
    private var links: MutableList<LinkItem>,
    var callback: (LinkItem) -> Unit)
    : RecyclerView.Adapter<ViewHolder>() {

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_link_card,parent,false)
        return ViewHolder(viewHolder)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val currentLink = links.get(position)
        val name = viewHolder.itemView.findViewById<TextView>(R.id.name)
        val description = viewHolder.itemView.findViewById<TextView>(R.id.description)
        name.text = currentLink.name
        description.text = currentLink.description
        viewHolder.itemView.setOnClickListener {
            callback.invoke(currentLink)
        }
    }

    override fun getItemCount(): Int {
        return links.size
    }

}