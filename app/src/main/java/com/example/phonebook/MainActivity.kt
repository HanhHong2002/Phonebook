package com.example.phonebook

import ItemAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
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
        when (item.itemId) {
            R.id.call -> {
                call()
                return true
            }
            R.id.sms -> {
                sendMess()
                return true

            }
            R.id.mail -> {
                sendEmail()
                return true

            }
            else -> return super.onContextItemSelected(item)
        }
    }
    fun sendEmail() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        val emailAddresses = findViewById<TextView>(R.id.gmail).text.toString()

        intent.putExtra(Intent.EXTRA_EMAIL, emailAddresses)
        intent.putExtra(Intent.EXTRA_TEXT, "How are you?")
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
    fun call(){
        val intent = Intent(Intent.ACTION_DIAL)
        val selectedPhoneNumber = findViewById<TextView>(R.id.phone).text

        intent.data = Uri.parse("tel:$selectedPhoneNumber")
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }

    }

    fun sendMess(){
        val intent = Intent(Intent.ACTION_SENDTO)
        val selectedPhoneNumber = findViewById<TextView>(R.id.phone).text

        intent.data = Uri.parse("smsto:$selectedPhoneNumber")
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    //

}