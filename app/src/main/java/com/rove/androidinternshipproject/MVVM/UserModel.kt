package com.rove.androidinternshipproject.MVVM

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*Created by Talha Siddiqui on 17/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/

@Entity
data class UserModel(val firstName: String, val lastName: String, val age: Int, val email: String, @PrimaryKey(autoGenerate = true) val uid: Int = 0 ) {
    var userName: String? = null
}