package gumtree.nicocavallo

import com.typesafe.config.Config

/**
 * Created by ncavallo on 22/05/15.
 */
trait Settings {

  val config:Config

  lazy val addressBookFileName = config.getString("app.addressBook")

}
