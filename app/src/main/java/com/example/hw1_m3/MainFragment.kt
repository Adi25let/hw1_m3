package com.example.hw1_m3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw1_m3.data.AnimalAdapter
import com.example.hw1_m3.data.AnimalModel
import com.example.hw1_m3.databinding.FragmentMainBinding
import com.example.hw1_m3.databinding.ItemAnimalBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private var animalList = arrayListOf<AnimalModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initAdapter()
    }
        private  fun initData(){
        animalList.add(AnimalModel(title = "Tiger", image = "https://png.pngtree.com/png-clipart/20230507/ourmid/pngtree-tiger-walking-wildlife-scene-transparent-background-png-image_7088126.png"
        ),
        )
            animalList.add(AnimalModel(title = "Parrot", image = "https://e7.pngegg.com/pngimages/273/337/png-clipart-bird-feeding-parrot-domestic-canary-bird-food-bird-food-animals-thumbnail.png"
            ),
                )
            animalList.add(AnimalModel(title = "Bear", image = "https://purepng.com/public/uploads/large/bear-tqc.png"
            ),
                )
        }


    private fun initAdapter() {
        val adapter = AnimalAdapter(animalList){ position ->
            val bundle = Bundle()
            bundle.putSerializable("animal" , animalList[position])

            findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(
                "Hello World"
            ))
//            val detailFragment = DetailFragment()
//            detailFragment.arguments = bundle
//            requireActivity().supportFragmentManager.beginTransaction()
//                .add(R.id.fragment_container, detailFragment)
//                .addToBackStack(null).commit()
        }
        binding.rvAnimal.adapter = adapter;
    }
}