package xcj.win10isbeautiful.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import xcj.win10isbeautiful.R
import xcj.win10isbeautiful.adpter.BasicFragmentViewPagerAdapter
import xcj.win10isbeautiful.adpter.InstallScreenViewPagerAdapter

class BasicFragment:BaseFragment() {

    private lateinit var mViewPager2: ViewPager2
    override val layoutId: Int
        get() = R.layout.fragment_basic
    companion object{
        fun getInstance():BasicFragment{
            return BasicFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    fun initView(){
        mViewPager2 = view?.findViewById(R.id.vp2_basic_fragment)!!
        with(mViewPager2){
            if(getChildAt(0) is RecyclerView){
                getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            }
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = BasicFragmentViewPagerAdapter(this@BasicFragment.requireActivity())
        }

    }
}