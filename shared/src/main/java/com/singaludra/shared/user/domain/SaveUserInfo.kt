package com.singaludra.shared.user.domain

import com.singaludra.shared.domain.UserRoot

interface SaveUserInfo {
    suspend fun save(userRoot: UserRoot)
}