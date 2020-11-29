package jp.com.elm.youtube.live.viewer.model

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import jp.com.elm.youtube.live.viewer.common.YoutubeHttpClient
import jp.com.elm.youtube.live.viewer.viewmodel.LiveInfoItem
import jp.com.elm.youtube.live.viewer.viewmodel.LiveInfoViewModel

class LiveInfoListOperationStandard(api: OperationYoutubeApi,
                                    maker: OperationLiveInfoMaker,
                                    view: View,
                                    layoutId:Int
                                    ) : FragmentLiveInfoOperation(api,maker,view,layoutId) {

    override fun getLiveInfoAsync(api: OperationYoutubeApi): String
        = YoutubeHttpClient(api).getLiveInfoAsync()

    override fun makeLiveInfo(response: String): MutableList<LiveInfoItem>
        = maker.makeViewModels(response)

    override fun updateLiveInfoList(liveInfo: MutableList<LiveInfoItem>){
        val adapter = GroupAdapter<ViewHolder>()
        view.findViewById<RecyclerView>(layoutId).adapter = adapter
        adapter.update(liveInfo)
    }

}