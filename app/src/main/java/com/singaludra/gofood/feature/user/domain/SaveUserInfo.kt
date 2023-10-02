package com.singaludra.gofood.feature.user.domain

import com.singaludra.shared.domain.UserRoot

interface SaveUserInfo {
    suspend fun save(userRoot: com.singaludra.shared.domain.UserRoot)
}