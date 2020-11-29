package jp.com.elm.youtube.live.viewer.model

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import jp.com.elm.youtube.live.viewer.viewmodel.LiveInfoItem
import jp.com.elm.youtube.live.viewer.viewmodel.LiveInfoViewModel
import okhttp3.Response

abstract class FragmentLiveInfoOperation(
    private val api:OperationYoutubeApi,
    protected val maker:OperationLiveInfoMaker,
    protected val view : View,
    protected val layoutId : Int
                                         ) {

    fun updateList(context:Context){
        val response = getLiveInfoAsync(api)
        val liveInfo = makeLiveInfo(response)
        updateLiveInfoList(liveInfo)
    }

    protected abstract fun getLiveInfoAsync(api:OperationYoutubeApi):String

    protected abstract fun makeLiveInfo(response: String) : MutableList<LiveInfoItem>

    protected abstract fun updateLiveInfoList(liveInfo:MutableList<LiveInfoItem>)
}