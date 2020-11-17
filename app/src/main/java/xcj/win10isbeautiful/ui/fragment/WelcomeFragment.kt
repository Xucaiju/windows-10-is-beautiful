package xcj.win10isbeautiful.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import xcj.win10isbeautiful.R

class WelcomeFragment: BaseFragment(){
    override val layoutId: Int
        get() = R.layout.fragment_welcome
    companion object{
        fun getInstance():WelcomeFragment{
            return WelcomeFragment()
        }
    }
}