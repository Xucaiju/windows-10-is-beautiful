package xcj.win10isbeautiful.ui.fragment

import xcj.win10isbeautiful.R

class NetworkFragment:BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_network
    companion object{
        fun getInstance():NetworkFragment{
            return NetworkFragment()
        }
    }
}