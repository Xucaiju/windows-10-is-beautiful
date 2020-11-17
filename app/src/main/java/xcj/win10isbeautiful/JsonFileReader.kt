package xcj.win10isbeautiful


import android.util.Log
import com.alibaba.fastjson.JSONArray
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStreamReader

object JsonFileReader {
    private var reader: BufferedReader?=null
    private var readedStr:String?=null
    fun read(filePath:String):JsonFileReader{
        val jsonStr:StringBuilder = StringBuilder()
        try{
            val fileInputStream = FileInputStream(filePath)
            val inputStreamReader = InputStreamReader(fileInputStream, Charsets.UTF_8)
            val bufferedReader = BufferedReader(inputStreamReader)
            while (bufferedReader.readLine()!=null){
                jsonStr.append(bufferedReader.readLine())
            }
            readedStr = jsonStr.toString()
        }catch(e:IOException){
            e.printStackTrace()
        }finally {
            if(reader!=null){
                try {
                    reader!!.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        return this
    }
    fun toObject():JSONArray?{
        readedStr?.let {
            val parseArray = JSONArray.parseArray(it)
            Log.e("yellow", parseArray.toJSONString())
        }?:doOther {

        }
        return null
    }
    private fun doOther(action:()->Unit){
        action()
    }
}