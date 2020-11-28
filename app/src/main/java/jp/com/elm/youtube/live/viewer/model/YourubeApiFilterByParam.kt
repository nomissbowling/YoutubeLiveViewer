package jp.com.elm.youtube.live.viewer.model

class YoutubeApiFilterByParam(private val queryParameter: String) : OperationYoutubeApi {

    override fun getApi(): String  = "https://www.googleapis.com/youtube/v3/search?part=snippet&key=AIzaSyA-TbYMp0Bpz1_B2ihMvwdxYdwA8t9dppI&type=video&eventType=live&order=viewCount&q=${queryParameter}"

}
