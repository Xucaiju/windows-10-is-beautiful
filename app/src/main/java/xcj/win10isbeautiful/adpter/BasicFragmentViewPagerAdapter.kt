package xcj.win10isbeautiful.adpter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import xcj.win10isbeautiful.ui.fragment.*

class BasicFragmentViewPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{RegionFragment.getInstance()}
            1->{KeyboardFragment.getInstance()}
            3->{Keyboard2Fragment.getInstance()}
            2->{KeyboardFragment.getInstance()}
            else->{RegionFragment.getInstance()}
        }
    }
}