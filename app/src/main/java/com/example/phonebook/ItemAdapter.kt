import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.phonebook.ItemModel
import com.example.phonebook.R
import com.example.phonebook.SecondActivity

class ItemAdapter(val items: ArrayList<ItemModel>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.contact_img)
        val name = itemView.findViewById<TextView>(R.id.contact_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.img.setImageResource(items[position].profileImg)
        holder.name.text = items[position].nameAcc
        holder.name.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("name", items[position].nameAcc)
            context.startActivity(intent)
        }
        holder.itemView.setOnCreateContextMenuListener { menu, v, menuInfo ->
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}
