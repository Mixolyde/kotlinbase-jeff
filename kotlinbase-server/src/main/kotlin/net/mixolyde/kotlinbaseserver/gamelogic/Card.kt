package net.mixolyde.kotlinbaseserver.gamelogic

enum class CardDirection { up, right, down, left }

enum class Card (val name:String, val priority: Int, val cost: Int, val isCap: Boolean) {
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
  val deckSize = 20;
  val handSize = 5;
  fun opposite(orientation: CardDirection) =
      CardDirection.values()[(orientation.index + 2) % 4];
  fun cw(orientation: CardDirection) =
      CardDirection.values()[(orientation.index + 1) % 4];
  fun ccw(orientation: CardDirection) =
      CardDirection.values()[(orientation.index + 3) % 4];
  
  fun exits(Card card, CardDirection dir) {
    Set<CardDirection> exits = Set<CardDirection>();

    switch (card) {
      case Card.rec:
      case Card.doc:
      case Card.com:
        exits = Set<CardDirection>.from([dir]);
        break;
      case Card.lab:
        exits = Set<CardDirection>.from([dir, cw(dir)]);
        break;
      case Card.fac:
        exits = Set<CardDirection>.from([dir, opposite(dir)]);
        break;
      case Card.hab:
        exits = Set<CardDirection>.from(CardDirection.values);
        exits.removeWhere((exitdir) => exitdir == dir);
        break;
      case Card.pow:
        exits = Set<CardDirection>.from(CardDirection.values);
        break;
      case Card.sab:
        throw ArgumentError.value(Card.sab);
        break;
    }

    return exits;
  }

  fun cardsToString(cards: List<Card>):String {
    var shortNames = cards.map{it.shortName}.joinToString(",");
    return "[${shortNames}]";
  }
}
