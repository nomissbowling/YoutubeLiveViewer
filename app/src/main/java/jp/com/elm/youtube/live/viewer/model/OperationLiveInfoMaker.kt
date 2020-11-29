package jp.com.elm.youtube.live.viewer.model

import jp.com.elm.youtube.live.viewer.viewmodel.LiveInfoItem
import jp.com.elm.youtube.live.viewer.viewmodel.LiveInfoViewModel
import org.json.JSONObject

interface OperationLiveInfoMaker {
    fun makeViewModels(response:String) : MutableList<LiveInfoItem>
    fun makeViewModel(liveInfo:JSONObject) : LiveInfoItem
}
