package com.singaludra.shared.user.local

import com.singaludra.shared.user.domain.UserEntity

interface IUserInfoRepository {
    suspend fun save(userEntity: UserEntity)
}