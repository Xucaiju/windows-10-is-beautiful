package xcj.win10isbeautiful

import android.content.*
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import xcj.win10isbeautiful.service.ClipboardChangeService
import java.lang.reflect.Modifier
import java.util.*


class MainActivity : AppCompatActivity() {
    private var clipServiceIntent: Intent?=null
    private lateinit var clipboard: ClipboardManager
    val mtext:AppCompatTextView by lazy { findViewById<AppCompatTextView>(R.id.text) }
    lateinit var mRecyclerView:RecyclerView
    lateinit var mAdapter:SimpleAdapter
    val contextStaticFields = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView = findViewById<RecyclerView>(R.id.main_recycler)
        mAdapter = SimpleAdapter()
        with(mRecyclerView){
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mAdapter
        }
        val contextJavaClass = Context::class.java
        Log.e("yellow", contextJavaClass.canonicalName)
        val declaredFields = contextJavaClass.declaredFields

        for(field in declaredFields){
            if(Modifier.isStatic(field.modifiers)&&field.type.toString().endsWith("java.lang.String")){
                contextStaticFields.add(field.name)
            }
        }
        val sb = StringBuilder()
        for(fieldName in contextStaticFields){
            sb.append("\n${fieldName}")
        }

        clipServiceIntent = Intent(this, ClipboardChangeService::class.java)


    }
    companion object{
        var mOnResume = false
    }

    override fun onResume() {
        super.onResume()
        mOnResume = true
        bindService(clipServiceIntent, mConnection, BIND_AUTO_CREATE)
        timer = Timer()
        if(timer!=null){
            timer!!.apply {
                schedule(object : TimerTask() {
                    override fun run() {
                        Log.e("pink1", "timer运作中...")
                        if(mClipServiceBinder!=null){
                            val clipData = mClipServiceBinder!!.getCollectData()
                            runOnUiThread{
                                mAdapter.mDataList = clipData
                            }
                        }
                    }
                },0, 500)
            }
        }
    }
    var mClipServiceBinder:ClipboardChangeService.SimpleBinder?=null
    private var mConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            Log.e("pink", "onServiceConnected")
            mClipServiceBinder = service as ClipboardChangeService.SimpleBinder
        }

        override fun onServiceDisconnected(name: ComponentName) {
            Log.e("pink", "onServiceDisconnected")
        }
    }

    override fun onPause() {
        super.onPause()
        mOnResume = false
        stopService(clipServiceIntent)
        if(timer!=null){
            timer!!.cancel()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        //clipboard.removePrimaryClipChangedListener(clipChangeListener)
    }
    var timer:Timer?=null
    inner class SimpleAdapter: RecyclerView.Adapter<SimpleAdapter.SimpleHolder>() {
        var mDataList = mutableListOf<String>()
            set(value) {
                field = value
                val sb = StringBuilder()
                for(fieldName in contextStaticFields){
                    sb.append("\n${fieldName}")
                }
                //Log.e("blue", sb.toString())
                notifyDataSetChanged()
            }
        override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
        ): SimpleHolder {
            val view = android.view.LayoutInflater.from(parent.context)
                    .inflate(xcj.win10isbeautiful.R.layout.item_basic_region, parent, false)
            return SimpleHolder(view)
        }

        override fun getItemCount(): Int {
            return mDataList.size
        }

        override fun onBindViewHolder(holder: SimpleHolder, position: Int) {
            holder.regionTextView.apply {
                text = mDataList[position]
                setTextColor(getColor(R.color.black))
            }
        }
        inner class SimpleHolder(itemView: View):RecyclerView.ViewHolder(itemView){
            val regionTextView = itemView.findViewById<AppCompatTextView>(R.id.tv_region)
        }
    }
}