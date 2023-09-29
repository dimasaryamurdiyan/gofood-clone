package com.singaludra.gofood.feature.user.local

import android.content.Context
import android.content.SharedPreferences
import com.singaludra.gofood.feature.user.domain.UserEntity

class UserInfoRepository constructor(
    private val sharedPreferences: SharedPreferences
) : IUserInfoRepository {
    companion object {
        private const val tokenPref = "TOKEN"
        private const val tokenType = "TOKEN_TYPE"
        private const val namePref = "NAME"
        private const val emailPref = "EMAIL"
        private const val houseNumberPref = "HOUSE_NUMBER"
        private const val phoneNumberPref = "PHONE_NUMBER"
        private const val addressPref = "ADDRESS"
        private const val cityPref = "CITY"
    }
    override suspend fun save(userEntity: UserEntity) {
        with(sharedPreferences.edit()) {
            putString(tokenPref, userEntity.accesToken)
            putString(tokenType, userEntity.tokenType)
            putString(namePref, userEntity.user.name)
            putString(emailPref, userEntity.user.email)
            putString(houseNumberPref, userEntity.user.houseNumber)
            putString(phoneNumberPref, userEntity.user.phoneNumber)
            putString(addressPref, userEntity.user.address)
            putString(cityPref, userEntity.user.city)
            apply()
        }
    }
}