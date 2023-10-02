package com.singaludra.shared.user.local.usecase

import com.singaludra.shared.user.domain.SaveUserInfo
import com.singaludra.shared.user.domain.UserEntity
import com.singaludra.shared.user.local.IUserInfoRepository
import com.singaludra.shared.domain.UserRoot

class LocalSaveUserInfo constructor(
    private val userInfoRepository: IUserInfoRepository
): SaveUserInfo {
    override suspend fun save(userRoot: UserRoot) {
        val userEntity = UserEntity.mapFromDomain(userRoot)
        userInfoRepository.save(userEntity)
    }
}