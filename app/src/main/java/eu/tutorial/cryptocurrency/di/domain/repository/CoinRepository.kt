package eu.tutorial.cryptocurrency.di.domain.repository

import eu.tutorial.cryptocurrency.data.remote.dto.CoinDetailDto
import eu.tutorial.cryptocurrency.data.remote.dto.CoinDto
import retrofit2.http.Path

interface CoinRepository {

    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinById(coinId:String): CoinDetailDto
}