package com.github.axiomzzz.jsoupparsinghtml

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.IOException

class RootViewModel : ViewModel() {
    var test=0
    private val _imageUrl = MutableLiveData<String>()
    val imageUrl: LiveData<String>
        get() = _imageUrl


    private val _data = MutableLiveData<Document>()
    val data: LiveData<Document>
        get() = _data


         fun _getl(barCode:String) {
             Log.i("AAAA", "$barCode")
             viewModelScope.launch {
                 withContext(Dispatchers.IO) {
                     try {
                         val doc = Jsoup.connect("https://barcode.monster/code/$barCode").get()
                         _data.postValue(doc)
                         _imageUrl.postValue(
                             doc.select("div[id=features]").select("img").attr("src")
                         )
                         val elements = doc.select("div[id=features]")
                         Log.i("AAAA", "Hello ${elements.select("img").attr("src")}")
                     } catch (e: IOException) {

                         Log.i("AAAA", "${e.message}")

                     }
                 }
             }
         }


}


