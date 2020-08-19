package com.rove.androidinternshipproject.MVVM

/*Created by Talha Siddiqui on 17/08/2020.
 Copyright (c) 2020 Rove. All rights reserved.
*/


object DependencyInjectorUtility {

    fun getUserViewModelFactory():UserViewModelFactoryClass{
        return UserViewModelFactoryClass(UserRepository() as UserRepositoryInterface)
    }

}