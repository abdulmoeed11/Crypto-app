package eu.tutorial.cryptocurrency.data.repository

import eu.tutorial.cryptocurrency.data.remote.CoinPaprikaApi
import eu.tutorial.cryptocurrency.data.remote.dto.CoinDetailDto
import eu.tutorial.cryptocurrency.data.remote.dto.CoinDto
import eu.tutorial.cryptocurrency.di.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImp @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}