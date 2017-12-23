package net.mixolyde.kotlinbaseserver.gamelogic

enum class CardDirection { up, right, down, left }

enum class Card (val longName:String, val priority: Int, val cost: Int, val isCap: Boolean) {
  rec("Recreation", 0, -1, true),
  doc("Docking Bay", 1, -1, true),
  com("Communication", 2, -1, true),
  lab("Laboratory", 3, 1, false),
  fac("Factory", 4, 1, false),
  hab("Habitat", 5, 2, false),
  pow("Power Station", 6, 3, false),
  sab("Sabotage", 7, 1, false);


  // String toString() => "Type: $shortName " +
  //    "Name: $name Priority: $priority Cost: $cost isCap: $isCap";

  val shortName:String
    get () = name.substring(0, 3).toLowerCase();
}


object CardUtil {
  val deckSize = 20
  val handSize = 5
  fun opposite(orientation: CardDirection) =
      CardDirection.values()[(orientation.ordinal + 2) % 4]
  fun cw(orientation: CardDirection) =
      CardDirection.values()[(orientation.ordinal + 1) % 4]
  fun ccw(orientation: CardDirection) =
      CardDirection.values()[(orientation.ordinal + 3) % 4]
  
  fun exits(card: Card, dir: CardDirection):Set<CardDirection> {
    val exits:Set<CardDirection>

    when (card) {
      Card.rec, Card.doc, Card.com ->
        exits = setOf(dir)
      Card.lab ->
        exits = setOf(dir, cw(dir))
      Card.fac ->
        exits = setOf(dir, opposite(dir))
      Card.hab -> {
        exits = CardDirection.values().toMutableSet()
        exits.filterNot{exit:CardDirection -> exit == dir}
      }
      Card.pow ->
        exits = CardDirection.values().toSet()
      Card.sab ->
        throw IllegalArgumentException(Card.sab.shortName)
    }

    return exits
  }

  fun cardsToString(cards: List<Card>):String {
    var shortNames = cards.map{it.shortName}.joinToString(",")
    return "[${shortNames}]";
  }
}
