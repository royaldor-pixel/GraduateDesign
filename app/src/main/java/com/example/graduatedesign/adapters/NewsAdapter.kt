package com.example.graduatedesign.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.graduatedesign.R
import com.example.graduatedesign.models.Project
import okhttp3.internal.http2.Http2Connection

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ProjectViewHolder>() {


    inner class ProjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Project>() {
        override fun areItemsTheSame(oldItem: Project, newItem: Project): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Project, newItem: Project): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        return ProjectViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_article_preview, parent,
                false
            ),
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        val project = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(project.envelopePic).into(findViewById(R.id.ivArticleImage))
            findViewById<TextView>(R.id.tvTitle).text = project.title
            findViewById<TextView>(R.id.tvSource).text = project.author
            findViewById<TextView>(R.id.tvDescription).text = project.desc
            findViewById<TextView>(R.id.tvPublishedAt).text = project.niceDate
            setOnItemClickListener {
                onItemClickListener?.let { it(project) }
            }
        }
    }

    private var onItemClickListener: ((Project) -> Unit)? = null

    fun setOnItemClickListener(listener: (Project) -> Unit) {
        onItemClickListener = listener
    }

}