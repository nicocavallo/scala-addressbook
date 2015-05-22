package gumtree.nicocavallo

import java.text.{SimpleDateFormat, DateFormat}

import com.typesafe.config.Config

/**
 * Created by ncavallo on 22/05/15.
 */
trait Settings {

  val config:Config

  lazy val dateFormat = new SimpleDateFormat(config.getString("app.dateFormat"))

  lazy val addressBookFileName = config.getString("app.addressBook")

}
