package com.aarh.borutoapp.domain.use_case.read_onboarding

import com.aarh.borutoapp.data.preferences.ConstantsPreferences
import com.aarh.borutoapp.domain.repository.DataStoreHandle
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(
    private val repository: DataStoreHandle,
) {

    operator fun invoke(): Flow<Boolean> {
        return repository.readState(key = ConstantsPreferences.OnBoardingPreferences)
    }
}
