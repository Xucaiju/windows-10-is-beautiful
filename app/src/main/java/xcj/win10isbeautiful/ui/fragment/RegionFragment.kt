package xcj.win10isbeautiful.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import xcj.win10isbeautiful.R

class RegionFragment :BaseFragment(){
    private lateinit var regionRecyclerView: RecyclerView
    override val layoutId: Int
        get() = R.layout.fragment_region
    companion object{
        fun getInstance():RegionFragment{
            return RegionFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    fun initView(){
        regionRecyclerView = view?.findViewById(R.id.rv_region)!!
        with(regionRecyclerView){
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
            adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
                override fun onCreateViewHolder(
                        parent: ViewGroup,
                        viewType: Int
                ): RecyclerView.ViewHolder {
                    val inflate = android.view.LayoutInflater.from(parent.context)
                            .inflate(xcj.win10isbeautiful.R.layout.item_basic_region, parent, false)
                    return object : RecyclerView.ViewHolder(inflate){

                    }
                }

                override fun getItemCount(): Int {
                    return 100
                }

                override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                    val regionTextView = holder.itemView.findViewById<AppCompatTextView>(xcj.win10isbeautiful.R.id.tv_region)
                    regionTextView.text = "赞比亚${position}"
                    if(position==3){
                        holder.itemView.setBackgroundResource(xcj.win10isbeautiful.R.drawable.bg_for_item_selected)
                    }
                }
            }
        }
    }
}