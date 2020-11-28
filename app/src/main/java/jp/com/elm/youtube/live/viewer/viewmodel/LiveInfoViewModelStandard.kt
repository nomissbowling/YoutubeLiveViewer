package jp.com.elm.youtube.live.viewer.viewmodel

data class LiveInfoViewModelStandard(override val title: String,
                                     override val videoId: String,
                                     override val thumbnail: String) : LiveInfoViewModel{
}
