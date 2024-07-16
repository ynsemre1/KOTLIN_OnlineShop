package com.example.kotlin_onlineshop.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_onlineshop.Model.BrandModel
import com.example.kotlin_onlineshop.Model.ItemsModel
import com.example.kotlin_onlineshop.Model.SliderModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainViewModel():ViewModel() {

    private val firebaseDatabase = FirebaseDatabase.getInstance()

    private val _banner = MutableLiveData<List<SliderModel>>()
    private val _brand = MutableLiveData<MutableList<BrandModel>>()
    private val _popular = MutableLiveData<MutableList<ItemsModel>>()

    val brands : LiveData<MutableList<BrandModel>> = _brand
    val banners:LiveData<List<SliderModel>> = _banner
    val popular:LiveData<MutableList<ItemsModel>> = _popular

    fun loadBanners(){
        val ref = firebaseDatabase.getReference("Banner")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot){
                val lists = mutableListOf<SliderModel>()
                for (childSnapshot in snapshot.children){
                    val list = childSnapshot.getValue(SliderModel::class.java)
                    if (list!=null){
                        lists.add(list)
                    }
                }
                _banner.value = lists
            }

            override fun onCancelled(error : DatabaseError){

            }
        })
    }
    fun loadBrand(){
        val Ref = firebaseDatabase.getReference("Category")
        Ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<BrandModel>()
                for (childSnapshot in snapshot.children){
                    val list = childSnapshot.getValue(BrandModel::class.java)
                    if (list != null){
                        lists.add(list)
                    }
                }
                _brand.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
    fun loadPupolar(){
        val Ref = firebaseDatabase.getReference("Items")
        Ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<ItemsModel>()
                for (childSnapshot in snapshot.children){
                    val list = childSnapshot.getValue(ItemsModel::class.java)
                    if (list != null){
                        lists.add(list)
                    }
                }
                _popular.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}