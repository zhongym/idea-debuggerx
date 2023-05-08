package com.github.zhongym.debuggerx

/**
 * @author Edoardo Luppi
 */
internal enum class ForceType(private val value: String) {
  VALUE("Force Return"),
  EXCEPTION("Throw Exception"),
  EVALUATE("Evaluate Expression"),
  ;

  override fun toString(): String =
    value
}
