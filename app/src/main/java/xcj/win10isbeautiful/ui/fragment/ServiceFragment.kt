package xcj.win10isbeautiful.ui.fragment

import xcj.win10isbeautiful.R

class ServiceFragment:BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_service
    companion object{
        fun getInstance():ServiceFragment{
            return ServiceFragment()
        }
    }
}