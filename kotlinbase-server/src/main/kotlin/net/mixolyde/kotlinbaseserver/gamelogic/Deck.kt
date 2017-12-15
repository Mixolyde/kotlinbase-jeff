package net.mixolyde.kotlinbaseserver.gamelogic

object Decks {
  static const Map<Card, int> cardCounts = const {
    Card.rec: 3,
    Card.doc: 2,
    Card.com: 3,
    Card.lab: 4,
    Card.fac: 3,
    Card.hab: 2,
    Card.pow: 1,
    Card.sab: 2
  };

  static List<Card> _sortedDeck() {
    return Card.values
        .expand((card) => new List.filled(DeckUtil.cardCounts[card], card))
        .toList();
  }

  static List<Card> shuffledDeck() {
    var cards = _sortedDeck();
    cards.shuffle(serverRandom);
    return cards;
  }
}