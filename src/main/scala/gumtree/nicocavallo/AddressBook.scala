package gumtree.nicocavallo

import com.typesafe.config.{ConfigFactory, Config}
import scala.collection.JavaConversions._

/**
 * Created by ncavallo on 22/05/15.
 */
object AddressBook extends App with GumtreeCodingChallenge with AddressBookFileReader with Settings {
  override val config: Config = ConfigFactory.parseMap(Map("app.addressBook" -> "AddressBook"))

  println(s"1. $countMales are males in AddressBook")
  println(s"2. $oldest is the oldest contact in AddressBook")
  val bill = "Bill McKnight"
  val paul = "Paul Robinson"
  println(s"3. ${bill} is ${daysDiff(bill,paul)} days older than ${paul} according to AddressBook")

}
