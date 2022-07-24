package com.business.easycore.room

import androidx.room.*
import com.business.easycore.room.entities.User

/**
 * Note:{}
 * Author:YangCheng
 * Email:874349119@qq.com
 * Date:2022-04-17
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(vararg user: User)

    @Delete
    fun deleteUser(vararg user: User)

    @Update
    fun updateUser(vararg user: User)

    @Query("SELECT * FROM user")
    fun getAllUser(): List<User>

    @Query("SELECT * FROM user WHERE user_name IN (:sql)")
    fun excute(sql:String)

}