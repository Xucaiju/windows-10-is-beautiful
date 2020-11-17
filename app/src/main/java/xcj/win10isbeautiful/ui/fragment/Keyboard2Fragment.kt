package xcj.win10isbeautiful.ui.fragment

import xcj.win10isbeautiful.R

class Keyboard2Fragment:BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_keyboard2
    companion object{
        fun getInstance():Keyboard2Fragment{
            return Keyboard2Fragment()
        }
    }
}