package com.singaludra.gofood.main.factories.user

import android.content.Context
import com.singaludra.shared.user.domain.SaveUserInfo
import com.singaludra.shared.user.local.IUserInfoRepository
import com.singaludra.shared.user.local.UserInfoRepository
import com.singaludra.shared.user.local.usecase.LocalSaveUserInfo
import com.singaludra.shared.frameworks.LocalFactory

class PreferenceFactory {
    companion object{
        fun createUserInfoRepository(context: Context): IUserInfoRepository {
            val sharedPreferences = LocalFactory.createSharedPreference(context)
            return UserInfoRepository(sharedPreferences)
        }
        fun createLocalSaveUserInfo(context: Context): SaveUserInfo {
            return LocalSaveUserInfo(createUserInfoRepository(context))
        }
    }
}