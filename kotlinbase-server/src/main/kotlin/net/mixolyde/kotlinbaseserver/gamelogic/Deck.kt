package net.mixolyde.kotlinbaseserver.gamelogic

object DeckUtil {
  private val cardCounts: Map<Card, Int> = kotlin.collections.mapOf(
    Pair(Card.rec,  3),
    Pair(Card.doc,  2),
    Pair(Card.com,  3),
    Pair(Card.lab,  4),
    Pair(Card.fac,  3),
    Pair(Card.hab,  2),
    Pair(Card.pow,  1),
    Pair(Card.sab,  2)
  )

  private fun sortedDeck(): List<Card>  {
    return Card.values()
    .flatMap { card ->
      val fillList: MutableList<Card> = mutableListOf()
      1.rangeTo(DeckUtil.cardCounts[card]!!).forEach {
        fillList.add(card)
      }
      fillList
    }
  }

  fun shuffledDeck(): List<Card> {
    return sortedDeck().shuffled()
  }
}