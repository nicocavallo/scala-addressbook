package gumtree.nicocavallo

import scala.io.Source

/**
 * Created by ncavallo on 22/05/15.
 */
trait AddressBookReader {

  val addresses:Seq[Contact]

}

trait AddressBookFileReader extends AddressBookReader { self:Settings =>

  implicit lazy val simpleDateFormat = dateFormat

  override lazy val addresses = Source.fromFile(addressBookFileName).getLines.map(line => Contact(line)).toSeq

}
