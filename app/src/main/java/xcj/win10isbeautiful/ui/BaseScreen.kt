package xcj.win10isbeautiful.ui

import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
import android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import xcj.win10isbeautiful.viewmodel.BaseViewModel
import java.lang.ClassCastException
import java.lang.reflect.ParameterizedType

abstract class BaseScreen<VM: BaseViewModel>():AppCompatActivity() {
    private lateinit var mViewModel:VM
    abstract val layoutId:Int
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.decorView.systemUiVisibility = SYSTEM_UI_FLAG_HIDE_NAVIGATION or SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        supportActionBar?.hide()
        setContentView(layoutId)
        initViewModel()
        initView()
        setListener()
        createObserver()
    }
    private fun initViewModel(){
        try{
            val parameterizedType: ParameterizedType? = this::class.java.genericSuperclass as? ParameterizedType
            parameterizedType?.let {
                val get = it.actualTypeArguments?.get(0) as? Class<VM>
                get?.let{ clazz->
                    mViewModel = ViewModelProvider.AndroidViewModelFactory(application).create(clazz)
                }
            }
        }catch (e: ClassCastException){
            e.printStackTrace()
        }
    }
    abstract fun initView()
    abstract fun setListener()
    abstract fun createObserver()
}