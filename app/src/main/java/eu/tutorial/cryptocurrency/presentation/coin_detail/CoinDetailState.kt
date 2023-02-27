package eu.tutorial.cryptocurrency.presentation.coin_detail

import eu.tutorial.cryptocurrency.di.domain.model.Coin
import eu.tutorial.cryptocurrency.di.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error:String = ""
)
