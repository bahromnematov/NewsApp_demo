package uz.bahrom.newsapp_demo.presentation.screns.main.home

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.bahrom.newsapp_demo.R
import uz.bahrom.newsapp_demo.data.local.entity.NewsEntity
import uz.bahrom.newsapp_demo.databinding.ListItemNewsBinding
import uz.bahrom.newsapp_demo.utils.Constants
import uz.bahrom.newsapp_demo.utils.inflate

class NewsAdapter : ListAdapter<NewsEntity, NewsAdapter.ViewHolder>(itemNewsCallback) {
    private var itemClickListener: ((NewsEntity) -> Unit)? = null

    fun setItemClickListener(block: (NewsEntity) -> Unit) {
        itemClickListener = block
    }


    inner class ViewHolder(private val binding: ListItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                itemClickListener?.invoke(getItem(absoluteAdapterPosition))
            }
        }

        @SuppressLint("SetTextI18n")
        fun onBind() {
            val data = getItem(absoluteAdapterPosition)

            binding.apply {
                Picasso.get()
                    .load(data.imgUrl)
                    .placeholder(R.drawable.news_logo)
                    .into(imageNews)
                tvNewsTitle.text = data.title
                tvDescript.text = data.description
                tvNewsAuthor.text = "Author : ${data.author ?: data.source ?: "Unknown source"}"
                tvNewsTime.text = "Realize news : ${Constants.getTime(data.time)}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ListItemNewsBinding.bind(parent.inflate(R.layout.list_item_news))
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()

}

private var itemNewsCallback = object : DiffUtil.ItemCallback<NewsEntity>() {
    override fun areItemsTheSame(oldItem: NewsEntity, newItem: NewsEntity): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: NewsEntity, newItem: NewsEntity): Boolean =
        oldItem.saved == newItem.saved &&
                oldItem.title == newItem.title &&
                oldItem.time == newItem.time

}