package gumtree.nicocavallo

import java.text.SimpleDateFormat
import java.util.Date

/**
 * Created by ncavallo on 22/05/15.
 */
case class Contact(name: String, gender: String, birthDay: Date)

object Contact {

  val DateFormat = new SimpleDateFormat("dd/MM/yy")

  def apply(line: String): Contact = {
    val fields = line.split(",")
    val name =fields(0).trim
    val gender = fields(1).trim
    val birthDateStr = fields(2).trim

    Contact(name,gender,DateFormat.parse(birthDateStr))
  }
}

