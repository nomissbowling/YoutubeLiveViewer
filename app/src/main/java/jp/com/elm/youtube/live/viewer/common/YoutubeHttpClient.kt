package jp.com.elm.youtube.live.viewer.common

import jp.com.elm.youtube.live.viewer.model.OperationYoutubeApi
import okhttp3.*

class YoutubeHttpClient(api:OperationYoutubeApi){
    private val httpCall : Call

    init {
        httpCall = createCall(api)
    }

    private fun createCall(api: OperationYoutubeApi) : Call{
        val httpClient = OkHttpClient()
        val request = Request.Builder().url(api.getApi()).build()
        return httpClient.newCall(request)
    }

    fun getLiveInfoAsync() : Response = httpCall.execute()
}
