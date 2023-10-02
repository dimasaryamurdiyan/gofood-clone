package com.singaludra.gofood.feature.user.local.usecase

import com.singaludra.gofood.feature.user.domain.SaveUserInfo
import com.singaludra.gofood.feature.user.domain.UserEntity
import com.singaludra.gofood.feature.user.local.IUserInfoRepository
import com.singaludra.shared.domain.UserRoot

class LocalSaveUserInfo constructor(
    private val userInfoRepository: IUserInfoRepository
): SaveUserInfo {
    override suspend fun save(userRoot: com.singaludra.shared.domain.UserRoot) {
        val userEntity = UserEntity.mapFromDomain(userRoot)
        userInfoRepository.save(userEntity)
    }
}