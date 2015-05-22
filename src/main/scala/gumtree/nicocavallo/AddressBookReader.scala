package gumtree.nicocavallo

import scala.io.Source

/**
 * Created by ncavallo on 22/05/15.
 */
trait AddressBookReader { self:Settings =>

  lazy val addresses = Source.fromFile(addressBookFileName).getLines.map(Contact(_)).toStream

}
