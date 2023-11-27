package com.aarh.borutoapp.domain.use_case.read_onboarding

import com.aarh.borutoapp.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(
    private val repository: Repository,
) {

    operator fun invoke(): Flow<Boolean> {
        return repository.readOnBoardingState()
    }
}
