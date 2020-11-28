package jp.com.elm.youtube.live.viewer.common

import jp.com.elm.youtube.live.viewer.model.YoutubeApiFilterByParam
import jp.com.elm.youtube.live.viewer.model.YoutubeApiOrderByRanking
import junit.framework.Assert.assertEquals
import org.junit.Test

class YoutubeHttpClientTest{

    @Test
    fun testHttpClient(){
        val api = YoutubeApiFilterByParam("hikakin")
        val httpClient = YoutubeHttpClient(api)
        val actual = httpClient.getLiveInfoAsync()
        assertEquals(actual, "a")
    }

    @Test
    fun testHttpClientOrderByRanking(){
        val api = YoutubeApiOrderByRanking()
        val httpClient = YoutubeHttpClient(api)
        val actual = httpClient.getLiveInfoAsync()
        assertEquals(actual.body?.string(), "")
    }
}
