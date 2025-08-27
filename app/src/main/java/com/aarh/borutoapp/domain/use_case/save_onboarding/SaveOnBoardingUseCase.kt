package com.aarh.borutoapp.domain.use_case.save_onboarding

import com.aarh.borutoapp.data.preferences.ConstantsPreferences
import com.aarh.borutoapp.domain.repository.DataStoreHandle

class SaveOnBoardingUseCase(
    private val repository: DataStoreHandle,
) {

    suspend operator fun invoke(completed: Boolean) {
        repository.saveState(
            key = ConstantsPreferences.OnBoardingPreferences,
            value = completed
        )
    }
}
