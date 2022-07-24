package com.business.easycore.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey

/**
 * Note:{}
 * Author:YangCheng
 * Email:874349119@qq.com
 * Date:2022-04-17
 */
@Fts4
@Entity(tableName = "user", ignoredColumns = [])
data class User(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "rowid") val uid: Int,
    @ColumnInfo(name = "user_name") val userName: String?,
    @ColumnInfo(name = "account") val account: String?,
    @ColumnInfo(name = "sex") val sex: String?,
    @ColumnInfo(name = "pwd") val pwd: String?
)
