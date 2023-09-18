package com.example.musicapp

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val dataList: List<Data>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
     val itemView = LayoutInflater.from(context).inflate(R.layout.item_vew,parent,false).rootView
        return  MyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentData = dataList[position]
        holder.title.text= currentData.title
        Picasso.get().load(currentData.album.cover).into(holder.coverImg);

        holder.play.setOnClickListener{
           playMusic(currentData.preview.toUri().toString())
            holder.play.setBackgroundResource(R.color.black)
        }

        holder.pause.setOnClickListener{
           stopMusic()
            holder.play.setBackgroundResource(R.color.white)
        }
    }


    override fun getItemCount(): Int {
        return dataList.size
    }

    class MyViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val coverImg: ImageView
      public  val play: ImageButton
        val pause: ImageButton
        val title: TextView

        init {
            coverImg = itemView.findViewById(R.id.imgCover)
            play = itemView.findViewById(R.id.btnplay)
            pause = itemView.findViewById(R.id.btnPause)
            title = itemView.findViewById(R.id.txttitle)
        }
    }


    private var mediaPlayer:MediaPlayer? = null
     private fun playMusic(url:String){
         mediaPlayer?.stop()
         mediaPlayer?.release()

         mediaPlayer= MediaPlayer().apply {
             setDataSource(url)
             prepare()
             start()
         }
     }

    private fun stopMusic() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

}