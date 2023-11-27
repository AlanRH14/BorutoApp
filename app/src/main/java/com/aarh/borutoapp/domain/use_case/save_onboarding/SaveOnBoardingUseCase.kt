package com.aarh.borutoapp.domain.use_case.save_onboarding

import com.aarh.borutoapp.data.repository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository,
) {

    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed = completed)
    }
}
