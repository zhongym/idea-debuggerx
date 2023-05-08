package com.github.zhongym.debuggerx

/**
 * @author Edoardo Luppi
 */
internal enum class ForceType(private val value: String) {
  VALUE("Value"),
  EXCEPTION("Exception"),
  EVALUATE("Evaluate"),
  ;

  override fun toString(): String =
    value
}
