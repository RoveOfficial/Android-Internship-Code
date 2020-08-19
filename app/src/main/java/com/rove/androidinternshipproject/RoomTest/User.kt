package com.rove.androidinternshipproject.RoomTest

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/*Created by Talha Siddiqui on 19/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/

@Entity
data class User(val firstName: String, val lastName: String, val age: Int, val email: String, @PrimaryKey(autoGenerate = true) val uid: Int = 0) {
   @Ignore var userName: String? = null
}

