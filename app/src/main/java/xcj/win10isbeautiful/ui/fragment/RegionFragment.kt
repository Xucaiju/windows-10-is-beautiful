package xcj.win10isbeautiful.ui.fragment

import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.os.EnvironmentCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import xcj.win10isbeautiful.JsonFileReader
import xcj.win10isbeautiful.R
import xcj.win10isbeautiful.model.Country
import java.util.jar.Manifest

class RegionFragment :BaseFragment(){
    private lateinit var regionRecyclerView: RecyclerView
    override val layoutId: Int
        get() = R.layout.fragment_region
    companion object{
        fun getInstance():RegionFragment{
            return RegionFragment()
        }
    }
    val countries = mutableListOf<Country>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(requireActivity().checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED){
            val externalStoragePublicDirectory =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            val filepath = "${externalStoragePublicDirectory}/country_list.txt"
            val countryJsonArray = JsonFileReader.read(filePath = filepath).toObject()
            countryJsonArray?.let {
                for(i in countryJsonArray){
                    val country = JSON.toJavaObject(i as JSONObject, Country::class.java)
                    if(country!=null&&country is Country){
                        countries.add(country)
                    }
                }
            }

        }
        initView()
    }
    val mAdatper = SimpleAdapter()
    fun initView(){
        regionRecyclerView = view?.findViewById(R.id.rv_region)!!
        with(regionRecyclerView){
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
            adapter = mAdatper
        }
        if(countries.isNotEmpty()){
            mAdatper.mDataList = countries
        }
    }
    inner class SimpleAdapter: RecyclerView.Adapter<SimpleAdapter.SimpleHolder>() {
        var mDataList = mutableListOf<Country>()
        set(value) {
            field = value
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
            holder.regionTextView.text = mDataList[position].cn
            if(position==3){
                holder.itemView.setBackgroundResource(R.drawable.bg_for_item_selected)
            }else{
                holder.itemView.setBackgroundResource(0)
            }
        }
        inner class SimpleHolder(itemView:View):RecyclerView.ViewHolder(itemView){
            val regionTextView = itemView.findViewById<AppCompatTextView>(R.id.tv_region)
        }
    }
}