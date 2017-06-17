package com.raquo.dombuilder.generic.definitions.eventProps

import com.raquo.dombuilder.generic.builders.Builder

/**
  * Miscellaneous Events
  */
trait MiscellaneousEventProps[P[_], Ev] { this: Builder[P] =>

  /**
    * Fires when a <menu> element is shown as a context menu
    */
  lazy val onShow: P[Ev] = build("show")

  /**
    * Fires when the user opens or closes the <details> element
    */
  lazy val onToggle: P[Ev] = build("toggle")
}