package layout

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.android.firstprogrammingassignment.Feed
import com.example.android.firstprogrammingassignment.R
import kotlinx.android.synthetic.main.recycler_row.view.*


class DisplayAdapter(val feed: Feed): RecyclerView.Adapter<CustomViewHolder>()  {

    val videoTitles = listOf("First title","Second","Third")

    override fun getItemCount(): Int {
        return feed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.recycler_row,parent,false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val video = feed.videos.get(position)
        holder?.view?.hello_text?.text = video.name

    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {
}
