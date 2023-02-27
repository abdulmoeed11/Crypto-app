package eu.tutorial.cryptocurrency.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eu.tutorial.cryptocurrency.common.Constants
import eu.tutorial.cryptocurrency.data.remote.CoinPaprikaApi
import eu.tutorial.cryptocurrency.data.repository.CoinRepositoryImp
import eu.tutorial.cryptocurrency.di.domain.repository.CoinRepository
import eu.tutorial.cryptocurrency.di.domain.use_case.get_coins.GetCoinsUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository{
        return CoinRepositoryImp(api)
    }

    @Provides
    @Singleton
    fun provideGetCoinsUseCase(repository: CoinRepository) : GetCoinsUseCase{
        return GetCoinsUseCase(repository)
    }
}