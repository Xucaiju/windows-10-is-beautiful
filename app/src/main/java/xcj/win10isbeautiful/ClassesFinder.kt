package xcj.win10isbeautiful

import android.os.Build
import android.util.Log
import xcj.win10isbeautiful.annotation.VersionName
import java.lang.Exception
import java.lang.StringBuilder
import java.lang.reflect.Modifier

object ClassesFinder {
    @VersionName("Android 11", "11")
    val API_30 = ""
    @VersionName("Android 10", "10")
    val API_29 = ""
    @VersionName("Android 9", "Pie")
    val API_28 = ""
    @VersionName("Android 8.1", "Oreo")
    val API_27 = ""
    @VersionName("Android 8", "Oreo")
    val API_26 = ""
    @VersionName("Android 7.1.x", "Nougat")
    val API_25 = ""
    @VersionName("Android 7.0","Nougat")
    val API_24 = ""
    @VersionName("Android 6.0", "Marshmallow")
    val API_23 = ""
    @VersionName("Android 5.1.x", "Lollipop")
    val API_22 = ""
    @VersionName("Android 5.0", "Lollipop")
    val API_21 = ""
    @VersionName("Android 4.4.4" , "kitkat")
    val API_20 = ""
    @VersionName("Android 4.4.x" , "kitkat")
    val API_19 = ""
    @VersionName("Android 4.3", "Jelly Bean")
    val API_18 = ""
    @VersionName("Android 4.2", "Jelly Bean")
    val API_17 = ""
    @VersionName("Android 4.1", "Jelly Bean")
    val API_16 = ""
    @VersionName("Android 4.0.x", "Ice Cream Sandwich")
    val API_15 = ""
    @VersionName("Android 4.0.0", "Ice Cream Sandwich")
    val API_14 = ""
    @VersionName("Android 3.2", "Honeycomb")
    val API_13 = ""
    @VersionName("Android 3.1", "Honeycomb")
    val API_12 = ""
    @VersionName("Android 3.0.x", "Honeycomb")
    val API_11 = ""
    @VersionName("Android 2.3.x", "Gingerbread")
    val API_10 = ""
    @VersionName("Android 2.2.x", "Froyo")
    val API_9 = ""
    @VersionName("Android 2.1.x", "Eclair")
    val API_8 = ""
    @VersionName("Android 2.0.x", "Eclair")
    val API_7 = ""
    val apis = listOf(
        API_30,
        API_29,
        API_28,
        API_27,
        API_26,
        API_25,
        API_24,
        API_23,
        API_22,
        API_21,
        API_20,
        API_19,
        API_18,
        API_17,
        API_16,
        API_15,
        API_14,
        API_13,
        API_12,
        API_11,
        API_10,
        API_9,
        API_8,
        API_7
    )
    init {
        loadPackages()
    }
    private fun loadPackages(ignorePlatformsDifference:Boolean=true){
        val loadedClassField = mutableListOf<String>()
        val currentPlatformSDKVersion = Build.VERSION.SDK_INT
        /*for(api in apis){
           *//* if(currentPlatfromSDKVersion.equals())
            this::class.java.getDeclaredField()*//*
        }*/
        val systemClassLoader = ClassLoader.getSystemClassLoader()
        try{

            val loadedClass = systemClassLoader.loadClass("android.content.pm.ActivityInfo")
            val declaredFields = loadedClass.declaredFields

            for(field in declaredFields){
                if(Modifier.isStatic(field.modifiers)&&field.type.toString().endsWith("java.lang.String")){
                    loadedClassField.add(field.name)
                }
            }
            val sb = StringBuilder()
            for(fieldName in loadedClassField){
                sb.append("\n${fieldName}")
            }
            e(content = sb.toString())
        }catch (e:Exception){
            e.printStackTrace()
        }

    }
    fun e(tag:String="blue", content:String){
        Log.e(tag, content)
    }
}