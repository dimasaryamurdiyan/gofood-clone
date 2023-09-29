package com.singaludra.gofood.feature.user.domain

import com.singaludra.gofood.shared.domain.UserRoot

interface SaveUserInfo {
    suspend fun save(userRoot: UserRoot)
}