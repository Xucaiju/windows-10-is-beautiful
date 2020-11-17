package xcj.win10isbeautiful

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity() {
    @SuppressWarnings
    private lateinit var ms_recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ms_recycler = findViewById(R.id.ms_recycler)
        ms_recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
                override fun onCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
                ): RecyclerView.ViewHolder {
                    val inflate = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_ms_recycler, parent, false)
                    return object : RecyclerView.ViewHolder(inflate){}
                }

                override fun getItemCount(): Int {
                    return 100
                }

                override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

                }
            }
        }
    }
}