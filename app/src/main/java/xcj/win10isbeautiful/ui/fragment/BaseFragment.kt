package xcj.win10isbeautiful.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import xcj.win10isbeautiful.R

abstract class BaseFragment :Fragment(){
    abstract val layoutId:Int
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View.inflate(context, layoutId, container)
    }

}