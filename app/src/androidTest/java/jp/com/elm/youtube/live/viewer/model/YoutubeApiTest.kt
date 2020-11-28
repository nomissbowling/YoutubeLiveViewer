package jp.com.elm.youtube.live.viewer.model

import junit.framework.Assert.assertEquals
import org.junit.Test

class YoutubeApiTest {
    @Test
    fun testGetApi(){
        val api : OperationYoutubeApi = YoutubeApiOrderByRanking()
        val actual = api.getApi()
        val expect = "https://www.googleapis.com/youtube/v3/search?part=snippet&type=video&eventType=live&order=viewCount"
        assertEquals(expect, actual)
    }

    @Test
    fun testGetApiFilterByParam(){
        val param = "java"
        val api : OperationYoutubeApi =YoutubeApiFilterByParam(param)
        val actual = api.getApi()
        val expect = "https://www.googleapis.com/youtube/v3/search?part=snippet&type=video&eventType=live&order=viewCount&q=java"
        assertEquals(expect, actual)
    }
}