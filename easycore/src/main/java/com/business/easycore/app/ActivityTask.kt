package com.business.easycore.app

import android.app.Activity
import java.lang.reflect.Field
import java.lang.reflect.Method

object ActivityTask {

    @Suppress("UNCHECKED_CAST")
    fun getAllActivity(): MutableList<Activity> {
        val list = mutableListOf<Activity>()
        try {
            val activityThread = Class.forName("android.app.ActivityThread")
            val currentActivityThread: Method =
                activityThread.getDeclaredMethod("currentActivityThread")
            currentActivityThread.isAccessible = true
            //获取主线程对象
            val activityThreadObject: Any? = currentActivityThread.invoke(null)
            val mActivitiesField: Field = activityThread.getDeclaredField("mActivities")
            mActivitiesField.isAccessible = true
            val mActivities = mActivitiesField.get(activityThreadObject) as Map<Any, Any>
            for ((_, value) in mActivities) {
                val activityClientRecordClass: Class<*> = value.javaClass
                val activityField: Field = activityClientRecordClass.getDeclaredField("activity")
                activityField.isAccessible = true
                val o: Any? = activityField.get(value)
                if(o is Activity) list.add(o)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return list
    }


}