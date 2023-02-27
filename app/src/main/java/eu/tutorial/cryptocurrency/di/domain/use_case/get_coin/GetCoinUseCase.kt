package eu.tutorial.cryptocurrency.di.domain.use_case.get_coin

import eu.tutorial.cryptocurrency.common.Resource
import eu.tutorial.cryptocurrency.data.remote.dto.toCoin
import eu.tutorial.cryptocurrency.data.remote.dto.toCoinDetail
import eu.tutorial.cryptocurrency.di.domain.model.Coin
import eu.tutorial.cryptocurrency.di.domain.model.CoinDetail
import eu.tutorial.cryptocurrency.di.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase  @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}