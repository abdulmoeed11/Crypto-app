package eu.tutorial.cryptocurrency.presentation.coin_list

import eu.tutorial.cryptocurrency.di.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error:String = ""
)
