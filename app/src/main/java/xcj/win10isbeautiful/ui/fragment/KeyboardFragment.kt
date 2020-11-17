package xcj.win10isbeautiful.ui.fragment

import xcj.win10isbeautiful.R

class KeyboardFragment:BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_keyboard
    companion object{
        fun getInstance():KeyboardFragment{
            return KeyboardFragment()
        }
    }
}