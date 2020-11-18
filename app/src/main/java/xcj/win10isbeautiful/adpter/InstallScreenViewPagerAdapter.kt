package xcj.win10isbeautiful.adpter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import xcj.win10isbeautiful.ui.fragment.*

class InstallScreenViewPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{WelcomeFragment.getInstance()}
            1->{RegionFragment.getInstance()}
            2->{KeyboardFragment.getInstance()}
            3->{Keyboard2Fragment.getInstance()}
            4->{ServiceFragment.getInstance()}
            else->{WelcomeFragment.getInstance()}
        }
    }
}