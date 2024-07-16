package com.example.kotlin_onlineshop.activity

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_onlineshop.Adapter.ColorAdapter
import com.example.kotlin_onlineshop.Adapter.SizeAdapter
import com.example.kotlin_onlineshop.Adapter.SliderAdapter
import com.example.kotlin_onlineshop.Model.ItemsModel
import com.example.kotlin_onlineshop.Model.SliderModel
import com.example.kotlin_onlineshop.databinding.ActivityDeatilBinding
import com.example.kotlin_onlineshop.Helper.ManagmentCart

class DetailActivity : BaseActivity() {
    private lateinit var binding : ActivityDeatilBinding
    private lateinit var item: ItemsModel
    private var numberOrder= 1
    private lateinit var managmentCart: ManagmentCart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeatilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managmentCart= ManagmentCart(this)

        getBundle()
        banners()
        initLists()
    }

    private fun initLists() {
        val sizeList= ArrayList<String>()
        for (size in item.size){
            sizeList.add(size.toString())
        }

        binding.sizeList.adapter= SizeAdapter(sizeList)
        binding.sizeList.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val colorList= ArrayList<String>()
        for (imageUrl in item.picUrl){
            colorList.add(imageUrl)
        }

        binding.colorList.adapter= ColorAdapter(colorList)
        binding.colorList.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun banners() {
        val sliderItems= ArrayList<SliderModel>()
        for (imageUrl in item.picUrl){
            sliderItems.add(SliderModel(imageUrl))
        }

        binding.slider.adapter= SliderAdapter(sliderItems, binding.slider)
        binding.slider.clipToPadding = true
        binding.slider.clipChildren = true
        binding.slider.offscreenPageLimit = 1

        if (sliderItems.size>1){
            binding.dotIndicator.visibility= View.VISIBLE
            binding.dotIndicator.attachTo(binding.slider)
        }
    }

    private fun getBundle() {
        item= intent.getParcelableExtra("object")!!
        binding.titleTxt.text= item.title
        binding.descriptionTxt.text= item.description
        binding.priceTxt.text= "₺"+item.price
        binding.ratingTxt.text= "${item.rating} Rating"
        binding.addToCartBtn.setOnClickListener{
            item.numberInCart= numberOrder
            managmentCart.insertFood(item)
        }
        binding.backBtn.setOnClickListener{
            finish()
        }
        binding.cartBtn.setOnClickListener {

        }
    }
}