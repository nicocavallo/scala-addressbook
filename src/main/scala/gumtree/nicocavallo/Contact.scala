package gumtree.nicocavallo

import java.text.DateFormat
import java.util.Date

/**
 * Created by ncavallo on 22/05/15.
 */
case class Contact(name: String, gender: String, birthDay: Date) {
  override def toString = name
}

object Contact {

  def apply(line: String)(implicit dateFormat: DateFormat): Contact = {
    val fields = line.split(",")
    val name =fields(0).trim
    val gender = fields(1).trim
    val birthDateStr = fields(2).trim

    Contact(name,gender,dateFormat.parse(birthDateStr))
  }
}

