package xcj.win10isbeautiful.ui

import android.Manifest
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import dalvik.system.DexFile
import xcj.win10isbeautiful.JsonFileReader
import xcj.win10isbeautiful.R
import xcj.win10isbeautiful.adpter.InstallScreenViewPagerAdapter
import xcj.win10isbeautiful.viewmodel.SimpleViewModel
import java.security.Permission
import java.util.*


class InstallScreen :BaseScreen<SimpleViewModel>(){
    private lateinit var mViewPager2: ViewPager2

    override fun initView() {
        mViewPager2 = findViewById(R.id.vp2_install_screen)
        with(mViewPager2){
            if(getChildAt(0) is RecyclerView){
                getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            }
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = InstallScreenViewPagerAdapter(this@InstallScreen)
        }
    }

    override fun setListener() {

    }

    override fun createObserver() {

    }
    val permissions = arrayOf<String>(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==PERMISSION_GRANTED){

        }else{
            ActivityCompat.requestPermissions(this, permissions, 1001)
        }
       /* val dexFile = DexFile(this.packageCodePath)
        dexFile.
        val enumeration: Enumeration<String> = dexFile.entries()
        while (enumeration.hasMoreElements()) {
            val className: String = enumeration.nextElement()
            if(className.contains("country_list")){
                enumeration.nextElement()
            }
            //Log.i("classname", className)
        }*/
       /* Log.e("yellow", packageCodePath)
        Log.e("yellow", packageResourcePath)*/
        //JsonFileReader.read("$packageResourcePath/country_list.txt").toObject()
    }
    override val layoutId: Int
        get() = R.layout.screen_install
}