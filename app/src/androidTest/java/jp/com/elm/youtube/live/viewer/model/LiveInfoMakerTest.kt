package jp.com.elm.youtube.live.viewer.model

import jp.com.elm.youtube.live.viewer.common.YoutubeHttpClient
import jp.com.elm.youtube.live.viewer.viewmodel.LiveInfoViewModel
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.json.JSONObject
import org.junit.Before
import org.junit.Test
import java.util.*

class LiveInfoMakerTest{
    private val response : String = "[{\n" +
            "  \"kind\": \"youtube#searchListResponse\",\n" +
            "  \"etag\": \"03YdyRJn4rf-UeL0yueBZtVlMNE\",\n" +
            "  \"nextPageToken\": \"CAUQAA\",\n" +
            "  \"regionCode\": \"JP\",\n" +
            "  \"pageInfo\": {\n" +
            "    \"totalResults\": 43546,\n" +
            "    \"resultsPerPage\": 5\n" +
            "  },\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"kind\": \"youtube#searchResult\",\n" +
            "      \"etag\": \"2AX8IqTL9RIH7seykSUDR6UbM18\",\n" +
            "      \"id\": {\n" +
            "        \"kind\": \"youtube#video\",\n" +
            "        \"videoId\": \"UsJf1PNPwdE\"\n" +
            "      },\n" +
            "      \"snippet\": {\n" +
            "        \"publishedAt\": \"2020-11-27T14:08:18Z\",\n" +
            "        \"channelId\": \"UCLo2xigvxv9ksxp78AyCBTw\",\n" +
            "        \"title\": \"مباشر القناة الرياضية السعودية | مباراة الاتحاد VS القادسية ( الجولة 6 )\",\n" +
            "        \"description\": \"تابعونا على تويتر القنوات الرياضيه السعودية https://twitter.com/riyadiyatv ــــــــــــــــــــــــــــــــــــــــــــــــــــ\",\n" +
            "        \"thumbnails\": {\n" +
            "          \"default\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/UsJf1PNPwdE/default_live.jpg\",\n" +
            "            \"width\": 120,\n" +
            "            \"height\": 90\n" +
            "          },\n" +
            "          \"medium\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/UsJf1PNPwdE/mqdefault_live.jpg\",\n" +
            "            \"width\": 320,\n" +
            "            \"height\": 180\n" +
            "          },\n" +
            "          \"high\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/UsJf1PNPwdE/hqdefault_live.jpg\",\n" +
            "            \"width\": 480,\n" +
            "            \"height\": 360\n" +
            "          }\n" +
            "        },\n" +
            "        \"channelTitle\": \"القنوات الرياضية السعودية\",\n" +
            "        \"liveBroadcastContent\": \"live\",\n" +
            "        \"publishTime\": \"2020-11-27T14:08:18Z\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"youtube#searchResult\",\n" +
            "      \"etag\": \"CasGLUgs3uCpJtENMFVdRKslAUo\",\n" +
            "      \"id\": {\n" +
            "        \"kind\": \"youtube#video\",\n" +
            "        \"videoId\": \"4REM8L3yNeo\"\n" +
            "      },\n" +
            "      \"snippet\": {\n" +
            "        \"publishedAt\": \"2020-11-27T11:27:52Z\",\n" +
            "        \"channelId\": \"UCam8T03EOFBsNdR0thrFHdQ\",\n" +
            "        \"title\": \"AMONG US: LA MEJOR MENTIRA! \uD83D\uDE31\",\n" +
            "        \"description\": \"Hoy vuestro impostor de confianza estará listo para acabar con los tripulantes! espero que lo paséis genial! Un enorme abrazo! \uD83E\uDD84 Hazte miembro del canal aquí ...\",\n" +
            "        \"thumbnails\": {\n" +
            "          \"default\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/4REM8L3yNeo/default_live.jpg\",\n" +
            "            \"width\": 120,\n" +
            "            \"height\": 90\n" +
            "          },\n" +
            "          \"medium\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/4REM8L3yNeo/mqdefault_live.jpg\",\n" +
            "            \"width\": 320,\n" +
            "            \"height\": 180\n" +
            "          },\n" +
            "          \"high\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/4REM8L3yNeo/hqdefault_live.jpg\",\n" +
            "            \"width\": 480,\n" +
            "            \"height\": 360\n" +
            "          }\n" +
            "        },\n" +
            "        \"channelTitle\": \"VEGETTA777\",\n" +
            "        \"liveBroadcastContent\": \"live\",\n" +
            "        \"publishTime\": \"2020-11-27T11:27:52Z\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"youtube#searchResult\",\n" +
            "      \"etag\": \"3VuNf_fKm6jtaOPkCaGjZPXVWEE\",\n" +
            "      \"id\": {\n" +
            "        \"kind\": \"youtube#video\",\n" +
            "        \"videoId\": \"Ac6ra3eyh8w\"\n" +
            "      },\n" +
            "      \"snippet\": {\n" +
            "        \"publishedAt\": \"2020-11-27T12:28:28Z\",\n" +
            "        \"channelId\": \"UCi7TVXyvrIwqeS9tfYD8UDA\",\n" +
            "        \"title\": \"DIRECTO ESPECIAL 24 HORAS - DjMaRiiO\",\n" +
            "        \"description\": \"MENSAJES DE VOZ EN PANTALLA: https://streamlabs.com/djmariio3 (hoy he puesto mínimo de 3€ para evitar demasiado spam) - Toda la info sobre el nuevo ...\",\n" +
            "        \"thumbnails\": {\n" +
            "          \"default\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/Ac6ra3eyh8w/default_live.jpg\",\n" +
            "            \"width\": 120,\n" +
            "            \"height\": 90\n" +
            "          },\n" +
            "          \"medium\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/Ac6ra3eyh8w/mqdefault_live.jpg\",\n" +
            "            \"width\": 320,\n" +
            "            \"height\": 180\n" +
            "          },\n" +
            "          \"high\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/Ac6ra3eyh8w/hqdefault_live.jpg\",\n" +
            "            \"width\": 480,\n" +
            "            \"height\": 360\n" +
            "          }\n" +
            "        },\n" +
            "        \"channelTitle\": \"DjMaRiiO\",\n" +
            "        \"liveBroadcastContent\": \"live\",\n" +
            "        \"publishTime\": \"2020-11-27T12:28:28Z\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"youtube#searchResult\",\n" +
            "      \"etag\": \"vhcljOSJH96H1_I3fJ0hdfjpfdk\",\n" +
            "      \"id\": {\n" +
            "        \"kind\": \"youtube#video\",\n" +
            "        \"videoId\": \"Jh9VAlOmXQ8\"\n" +
            "      },\n" +
            "      \"snippet\": {\n" +
            "        \"publishedAt\": \"2020-11-27T12:23:06Z\",\n" +
            "        \"channelId\": \"UChXi_PlJkRMPYFQBOJ3MpxA\",\n" +
            "        \"title\": \"2 Day Titan Scar Code Giveaway - Garena Free Fire Live\",\n" +
            "        \"description\": \"Phone Giveaway- https://discord.gg/gyangaming Duo Dj Alok Hacker K New September Update Maps Bermuda 2.0 2020 Free Fire Live Gyan Gaming Live ...\",\n" +
            "        \"thumbnails\": {\n" +
            "          \"default\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/Jh9VAlOmXQ8/default_live.jpg\",\n" +
            "            \"width\": 120,\n" +
            "            \"height\": 90\n" +
            "          },\n" +
            "          \"medium\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/Jh9VAlOmXQ8/mqdefault_live.jpg\",\n" +
            "            \"width\": 320,\n" +
            "            \"height\": 180\n" +
            "          },\n" +
            "          \"high\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/Jh9VAlOmXQ8/hqdefault_live.jpg\",\n" +
            "            \"width\": 480,\n" +
            "            \"height\": 360\n" +
            "          }\n" +
            "        },\n" +
            "        \"channelTitle\": \"Gyan Gaming\",\n" +
            "        \"liveBroadcastContent\": \"live\",\n" +
            "        \"publishTime\": \"2020-11-27T12:23:06Z\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"youtube#searchResult\",\n" +
            "      \"etag\": \"gfdDwoUk2yLV0Mb0QK6-o4XcxYU\",\n" +
            "      \"id\": {\n" +
            "        \"kind\": \"youtube#video\",\n" +
            "        \"videoId\": \"yRtZWY8ZpX0\"\n" +
            "      },\n" +
            "      \"snippet\": {\n" +
            "        \"publishedAt\": \"2020-11-27T15:47:48Z\",\n" +
            "        \"channelId\": \"UC0IWRLai-BAwci_e9MylNGw\",\n" +
            "        \"title\": \"ROZ KA STRUGGLE - NO PROMOTION\",\n" +
            "        \"description\": \"The PRESTIGE MEMBER OF THE HOMO-BAKCHODIAN SOCIETY: GO TO▶️https://www.youtube.com/channel/UC0IWRLai-BAwci_e9MylNGw/join For ...\",\n" +
            "        \"thumbnails\": {\n" +
            "          \"default\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/yRtZWY8ZpX0/default_live.jpg\",\n" +
            "            \"width\": 120,\n" +
            "            \"height\": 90\n" +
            "          },\n" +
            "          \"medium\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/yRtZWY8ZpX0/mqdefault_live.jpg\",\n" +
            "            \"width\": 320,\n" +
            "            \"height\": 180\n" +
            "          },\n" +
            "          \"high\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/yRtZWY8ZpX0/hqdefault_live.jpg\",\n" +
            "            \"width\": 480,\n" +
            "            \"height\": 360\n" +
            "          }\n" +
            "        },\n" +
            "        \"channelTitle\": \"CarryisLive\",\n" +
            "        \"liveBroadcastContent\": \"live\",\n" +
            "        \"publishTime\": \"2020-11-27T15:47:48Z\"\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}\n" +
            "]"



//    @Test
//    fun testMaker(){
//        val maker : OperationLiveInfoMaker  = LiveInfoMakerStandard(response)
//        val actual : List<LiveInfoViewModel> = maker.makeViewModels()
//        val expect = ""
//        assertTrue(Arrays.deepEquals(actual,expect))
//    }


    @Test
    fun testGetVideoId(){
        val expect = "UsJf1PNPwdE"
        val response = JSONObject(json)
        val maker = LiveInfoMakerStandard()
        val actual = maker.getVideoId(response)
        assertEquals(expect, actual)
    }
    @Test
    fun testGetVideoTitle(){
        val expected = "مباشر القناة الرياضية السعودية | مباراة الاتحاد VS القادسية ( الجولة 6 )"
        val response = JSONObject(json)
        val actual = LiveInfoMakerStandard().getVideoTitle(response)
        assertEquals(expected, actual)
    }
    @Test
    fun testGetVideoThumbNails(){
        val expected = "https://i.ytimg.com/vi/UsJf1PNPwdE/default_live.jpg"
        val response = JSONObject(json)
        val actual = LiveInfoMakerStandard().getVideoThumbNail(response)
        assertEquals(expected, actual)
    }



    private val json = "{\n" +
            "      \"kind\": \"youtube#searchResult\",\n" +
            "      \"etag\": \"2AX8IqTL9RIH7seykSUDR6UbM18\",\n" +
            "      \"id\": {\n" +
            "        \"kind\": \"youtube#video\",\n" +
            "        \"videoId\": \"UsJf1PNPwdE\"\n" +
            "      },\n" +
            "      \"snippet\": {\n" +
            "        \"publishedAt\": \"2020-11-27T14:08:18Z\",\n" +
            "        \"channelId\": \"UCLo2xigvxv9ksxp78AyCBTw\",\n" +
            "        \"title\": \"مباشر القناة الرياضية السعودية | مباراة الاتحاد VS القادسية ( الجولة 6 )\",\n" +
            "        \"description\": \"تابعونا على تويتر القنوات الرياضيه السعودية https://twitter.com/riyadiyatv ــــــــــــــــــــــــــــــــــــــــــــــــــــ\",\n" +
            "        \"thumbnails\": {\n" +
            "          \"default\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/UsJf1PNPwdE/default_live.jpg\",\n" +
            "            \"width\": 120,\n" +
            "            \"height\": 90\n" +
            "          },\n" +
            "          \"medium\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/UsJf1PNPwdE/mqdefault_live.jpg\",\n" +
            "            \"width\": 320,\n" +
            "            \"height\": 180\n" +
            "          },\n" +
            "          \"high\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/UsJf1PNPwdE/hqdefault_live.jpg\",\n" +
            "            \"width\": 480,\n" +
            "            \"height\": 360\n" +
            "          }\n" +
            "        },\n" +
            "        \"channelTitle\": \"القنوات الرياضية السعودية\",\n" +
            "        \"liveBroadcastContent\": \"live\",\n" +
            "        \"publishTime\": \"2020-11-27T14:08:18Z\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"youtube#searchResult\",\n" +
            "      \"etag\": \"3VuNf_fKm6jtaOPkCaGjZPXVWEE\",\n" +
            "      \"id\": {\n" +
            "        \"kind\": \"youtube#video\",\n" +
            "        \"videoId\": \"Ac6ra3eyh8w\"\n" +
            "      },\n" +
            "      \"snippet\": {\n" +
            "        \"publishedAt\": \"2020-11-27T12:28:28Z\",\n" +
            "        \"channelId\": \"UCi7TVXyvrIwqeS9tfYD8UDA\",\n" +
            "        \"title\": \"DIRECTO ESPECIAL 24 HORAS - DjMaRiiO\",\n" +
            "        \"description\": \"MENSAJES DE VOZ EN PANTALLA: https://streamlabs.com/djmariio3 (hoy he puesto mínimo de 3€ para evitar demasiado spam) - Toda la info sobre el nuevo ...\",\n" +
            "        \"thumbnails\": {\n" +
            "          \"default\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/Ac6ra3eyh8w/default_live.jpg\",\n" +
            "            \"width\": 120,\n" +
            "            \"height\": 90\n" +
            "          },\n" +
            "          \"medium\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/Ac6ra3eyh8w/mqdefault_live.jpg\",\n" +
            "            \"width\": 320,\n" +
            "            \"height\": 180\n" +
            "          },\n" +
            "          \"high\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/Ac6ra3eyh8w/hqdefault_live.jpg\",\n" +
            "            \"width\": 480,\n" +
            "            \"height\": 360\n" +
            "          }\n" +
            "        },\n" +
            "        \"channelTitle\": \"DjMaRiiO\",\n" +
            "        \"liveBroadcastContent\": \"live\",\n" +
            "        \"publishTime\": \"2020-11-27T12:28:28Z\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"kind\": \"youtube#searchResult\",\n" +
            "      \"etag\": \"2_IwEoQbyyoPbFj2hEtuYIXD9vk\",\n" +
            "      \"id\": {\n" +
            "        \"kind\": \"youtube#video\",\n" +
            "        \"videoId\": \"AEG8WzKbiEI\"\n" +
            "      },\n" +
            "      \"snippet\": {\n" +
            "        \"publishedAt\": \"2020-11-27T16:49:37Z\",\n" +
            "        \"channelId\": \"UCo3i0nUzZjjLuM7VjAVz4zA\",\n" +
            "        \"title\": \"J&#39;AI UNE TECHNIQUE POUR ÊTRE IMPOSTEUR SUR AMONG US ! (c&#39;est faux)\",\n" +
            "        \"description\": \"Code Créateur dans la boutique Fortnite : \\\"michoucroute\\\" Mon Instagram : http://bit.ly/MichouINSTA Mon Twitter : http://bit.ly/MichouTweet Mon Twitch ...\",\n" +
            "        \"thumbnails\": {\n" +
            "          \"default\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/AEG8WzKbiEI/default_live.jpg\",\n" +
            "            \"width\": 120,\n" +
            "            \"height\": 90\n" +
            "          },\n" +
            "          \"medium\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/AEG8WzKbiEI/mqdefault_live.jpg\",\n" +
            "            \"width\": 320,\n" +
            "            \"height\": 180\n" +
            "          },\n" +
            "          \"high\": {\n" +
            "            \"url\": \"https://i.ytimg.com/vi/AEG8WzKbiEI/hqdefault_live.jpg\",\n" +
            "            \"width\": 480,\n" +
            "            \"height\": 360\n" +
            "          }\n" +
            "        },\n" +
            "        \"channelTitle\": \"Michou\",\n" +
            "        \"liveBroadcastContent\": \"live\",\n" +
            "        \"publishTime\": \"2020-11-27T16:49:37Z\"\n" +
            "      }\n" +
            "    }"
}