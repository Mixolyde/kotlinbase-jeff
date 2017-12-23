package net.mixolyde.kotlinbaseserver.gamelogic

import kotlin.test.*

class CardTests{

  @Test
  fun `test Opposite Orientations`(){
      expect(CardDirection.up){CardUtil.opposite(CardDirection.down)}
      expect(CardDirection.right){CardUtil.opposite(CardDirection.left)}
  }
}
