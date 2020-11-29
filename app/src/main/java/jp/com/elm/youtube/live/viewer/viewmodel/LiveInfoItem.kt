package jp.com.elm.youtube.live.viewer.viewmodel

import android.net.Uri
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso
import com.xwray.groupie.databinding.BindableItem
import jp.com.elm.youtube.live.viewer.R
import jp.com.elm.youtube.live.viewer.databinding.VideoItemBinding
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class LiveInfoItem(private val title:String,
                   private val videoId : String,
                   private val thumbnail : String
                   ) : BindableItem<VideoItemBinding>(){
    override fun bind(viewBinding: VideoItemBinding, position: Int) {
        viewBinding.videoItemTitle.text = title
        //TODO ユーザーアイコンの取得
        loadVideoImage(viewBinding.videoItemThumbnail,"https://www.youtube.com/watch?v=${videoId}")
        viewBinding.videoItemThumbnail.setOnClickListener {  }
    }


    private fun loadUserIcon(view:ImageView, src:String){
        Picasso
            .get()
            .load(Uri.parse(src))
            .transform(CropCircleTransformation())
            .into(view)
    }

    private fun loadVideoImage(view: ImageView, src: String){
        Picasso
            .get()
            .load(src)
            .fit()
            .into(view)
    }

    override fun getLayout(): Int = R.layout.video_item

}