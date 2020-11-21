package xcj.win10isbeautiful.service

import android.app.Service
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import xcj.win10isbeautiful.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class ClipboardChangeService:Service() {
    lateinit var mBinder:SimpleBinder
    private lateinit var clipboard: ClipboardManager
    private val clipChangedListener = {
        /*if(MainActivity.mOnResume){
            Thread.sleep(1200)
        }*/
        val primaryClip = clipboard.primaryClip
        if(primaryClip?.itemCount?:0>0){
            val text = primaryClip?.getItemAt(0)!!.text
            mBinder.add(text.toString())
            Log.e("pink", "itemCount=${primaryClip?.itemCount}\t粘贴板的内容:$text")
        }

    }
    override fun onBind(intent: Intent?): IBinder? {
        return mBinder
    }

    override fun onDestroy() {
        super.onDestroy()
        //clipboard.removePrimaryClipChangedListener(clipChangedListener)
    }
    override fun onCreate() {
        super.onCreate()
        Log.e("pink", "监听粘贴板的service启动了!")
        mBinder = SimpleBinder()
        clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboard.addPrimaryClipChangedListener(clipChangedListener)
    }
    inner class SimpleBinder:Binder(){
        private val mCollectData = mutableListOf<String>()
        fun add(clipContent:String){
           mCollectData.add("${SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(Calendar.getInstance().time)}:${clipContent}")
        }
        fun getCollectData():MutableList<String>{
            return mCollectData
        }
    }
}