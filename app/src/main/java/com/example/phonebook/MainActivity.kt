package com.example.phonebook

import ItemAdapter
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)






        val items = arrayListOf<ItemModel>()
        repeat(15) {
            items.add(
                ItemModel(
                    resources.getIdentifier("img", "drawable", packageName), "Hồng Hạnh VN03"
                )
            )
        }



        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = ItemAdapter(items)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter



        registerForContextMenu(recyclerView)


    }
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.sub_menu, menu)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val pos = (item.menuInfo as AdapterView.AdapterContextMenuInfo).position
        if (item.itemId == R.id.call)
            {
                Log.v("TAG", "Calling..." )
        }
            else if (item.itemId == R.id.sms){
            Log.v("TAG", "Chatting..." )

            }
         else if (item.itemId == R.id.mail){
            Log.v("TAG", "Sending..." )


         }
        return super.onContextItemSelected(item)
    }

    //

}