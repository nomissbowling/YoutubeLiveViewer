package jp.com.elm.youtube.live.viewer.model

import jp.com.elm.youtube.live.viewer.viewmodel.LiveInfoItem
import jp.com.elm.youtube.live.viewer.viewmodel.LiveInfoViewModel
import jp.com.elm.youtube.live.viewer.viewmodel.LiveInfoViewModelStandard
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL

class LiveInfoMakerStandard : OperationLiveInfoMaker {

    companion object{
        private const val SNIPPET = "snippet"
        private const val TITLE    = "title"
        private const val ID       = "id"
        private const val VIDEO_ID = "videoId"
        private const val THUMBNAILS = "thumbnails"
        private const val DEFAULT   = "default"
        private const val URL       = "url"
    }



    private fun createLivesJson(response: String) : JSONArray = JSONObject(response).getJSONArray("items")

    override fun makeViewModels(response: String): MutableList<LiveInfoItem> {
        val liveInfo : JSONArray = createLivesJson(response)
        val infoList = mutableListOf<LiveInfoItem>()
        for(i in 0 until liveInfo.length()){
            infoList.add(makeViewModel(liveInfo.getJSONObject(i)))
        }
        return infoList
    }

    override fun makeViewModel(liveInfo: JSONObject): LiveInfoItem
        = LiveInfoItem(
                title     = getVideoTitle(liveInfo),
                videoId   = getVideoId(liveInfo),
                thumbnail = getVideoThumbNail(liveInfo)
        )


    fun getVideoId(liveInfo: JSONObject): String = liveInfo.getJSONObject(ID).getString(VIDEO_ID)

    fun getVideoTitle(liveInfo  : JSONObject): String = liveInfo.getJSONObject(SNIPPET).getString(TITLE)

    fun getVideoThumbNail(liveInfo: JSONObject): String
    = liveInfo
            .getJSONObject(SNIPPET)
            .getJSONObject(THUMBNAILS)
            .getJSONObject(DEFAULT)
            .getString(URL)
}
