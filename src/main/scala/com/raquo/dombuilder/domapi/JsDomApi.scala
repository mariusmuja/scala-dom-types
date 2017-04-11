package com.raquo.dombuilder.domapi

import org.scalajs.dom
import org.scalajs.dom.document

import scala.scalajs.js

object JsDomApi extends DomApi[js.Function1, dom.Event, dom.html.Element, dom.Element, dom.Text, dom.Comment, dom.Node] {

  @inline override def parentNode(node: dom.Node): Option[dom.Node] = {
    Option(node.parentNode)
  }

  @inline override def createElement(tagName: String): dom.Element = {
    document.createElement(tagName)
  }

  @inline override def createTextNode(text: String): dom.Text = {
    document.createTextNode(text)
  }

  @inline override def createComment(text: String): dom.Comment = {
    document.createComment(text)
  }

  @inline override def insertBefore(parentNode: dom.Node, newNode: dom.Node, referenceNode: dom.Node): Unit = {
    parentNode.insertBefore(newNode, referenceNode)
  }

  @inline override def removeChild(node: dom.Node, child: dom.Node): Unit = {
    node.removeChild(child)
  }

  @inline override def appendChild(node: dom.Node, child: dom.Node): Unit = {
    node.appendChild(child)
  }

  @inline override def setTextContent(node: dom.Node, text: String): Unit = {
    node.textContent = text
  }

  @inline override def setAttribute[V](element: dom.Element, attrName: String, value: V): Unit = {
    value match {
      case true => element.setAttribute(attrName, "")
      case false => removeAttribute(element, attrName)
      case _ => element.setAttribute(attrName, value.toString)
    }
  }

  @inline override def removeAttribute(element: dom.Element, attrName: String): Unit = {
    element.removeAttribute(attrName)
  }

  @inline override def addEventListener[E <: dom.Event](
    element: dom.Node,
    eventName: String,
    eventHandler: js.Function1[E, Unit],
    useCapture: Boolean = false
  ): Unit = {
    element.addEventListener(eventName, eventHandler, useCapture)
  }

  @inline override def removeEventListener[E <: dom.Event](
    element: dom.Node,
    eventName: String,
    eventHandler: js.Function1[E, Unit],
    useCapture: Boolean = false
  ): Unit = {
    element.removeEventListener(eventName, eventHandler, useCapture)
  }

  @inline override def setProp[V](element: dom.Node, propName: String, value: V): Unit = {
    element.asInstanceOf[js.Dynamic].updateDynamic(propName)(value.asInstanceOf[js.Any])
  }

  @inline override def setStyle[V](element: dom.html.Element, stylePropName: String, value: V): Unit = {
    element.style.asInstanceOf[js.Dynamic].updateDynamic(stylePropName)(value.asInstanceOf[js.Any])
  }
}
