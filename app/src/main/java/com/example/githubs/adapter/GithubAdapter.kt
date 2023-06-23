package com.example.githubs.adapterimport android.view.LayoutInflaterimport android.view.ViewGroupimport androidx.recyclerview.widget.RecyclerViewimport com.bumptech.glide.Glideimport com.example.githubs.databinding.LayoutMainBindingimport com.example.githubs.model.ListUsersclass GithubAdapter(val listUsers: List<ListUsers>, val onItemCallback: OnItemCallback): RecyclerView.Adapter<GithubAdapter.GithubViewHolder>() {    class GithubViewHolder(val binding: LayoutMainBinding): RecyclerView.ViewHolder(binding.root)    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubAdapter.GithubViewHolder {        return GithubViewHolder(LayoutMainBinding.inflate(LayoutInflater.from(parent.context),parent,false))    }    override fun onBindViewHolder(holder: GithubAdapter.GithubViewHolder, position: Int) {        holder.binding.apply {            tvUsername.text = listUsers[position].username            Glide.with(holder.itemView.context)                .load(listUsers[position].avatar)                .circleCrop()                .into(ivAvatar)            holder.itemView.setOnClickListener {                onItemCallback.onItemClicked(listUsers[position])            }        }    }    override fun getItemCount(): Int = listUsers.size    interface OnItemCallback{        fun onItemClicked(list: ListUsers)    }}