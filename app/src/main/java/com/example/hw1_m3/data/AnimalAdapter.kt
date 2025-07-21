package com.example.hw1_m3.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw1_m3.databinding.ItemAnimalBinding

class AnimalAdapter(private val animalList: ArrayList<AnimalModel>,
    private val onItemClick: (position: Int) -> Unit
): RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {
  inner  class ViewHolder(private  val binding: ItemAnimalBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(animalModel: AnimalModel) {
            animalList
            binding.tvAnimal.text = animalModel.title
            Glide.with(binding.tvAnimal).load(animalModel.image).into(binding.ivAnimal);
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            ItemAnimalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(animalList[position])

        holder.itemView.setOnClickListener {
            onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return animalList.size
    }


}