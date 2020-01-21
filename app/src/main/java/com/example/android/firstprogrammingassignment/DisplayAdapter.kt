package layout

import android.os.Build.VERSION_CODES.P
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.android.firstprogrammingassignment.Feed
import com.example.android.firstprogrammingassignment.R
import com.squareup.picasso.Picasso
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
        holder?.view?.video_title?.text = video.name
        holder?.view?.channel_name?.text =  video.channel.name
        holder?.view?.sub_count?.text = video.channel.numberOfSubscribers.toString() + " Subscribers"
        val thumbnail_imageView = holder?.view?.thumbnail
        Picasso.with(holder?.view?.context).load(video.imageUrl).into(thumbnail_imageView)
        val channel_imageView = holder?.view?.channel_profile
        Picasso.with(holder?.view?.context).load(video.channel.profileImageUrl).into(channel_imageView)
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {
}
