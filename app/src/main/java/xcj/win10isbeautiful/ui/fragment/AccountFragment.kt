package xcj.win10isbeautiful.ui.fragment

import xcj.win10isbeautiful.R

class AccountFragment:BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_account
    companion object{
        fun getInstance():AccountFragment{
            return AccountFragment()
        }
    }
}