package com.singaludra.gofood.feature.user.local

import com.singaludra.gofood.feature.user.domain.UserEntity

interface IUserInfoRepository {
    suspend fun save(userEntity: UserEntity)
}