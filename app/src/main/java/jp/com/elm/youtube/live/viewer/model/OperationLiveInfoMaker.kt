package jp.com.elm.youtube.live.viewer.model

import jp.com.elm.youtube.live.viewer.viewmodel.LiveInfoViewModel
import org.json.JSONObject

interface OperationLiveInfoMaker {
    fun makeViewModels(response:String) : List<LiveInfoViewModel>
    fun makeViewModel(liveInfo:JSONObject) : LiveInfoViewModel
}
