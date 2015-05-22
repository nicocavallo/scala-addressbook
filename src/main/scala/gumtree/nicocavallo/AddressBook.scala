package gumtree.nicocavallo

import com.typesafe.config.{ConfigFactory, Config}
import scala.collection.JavaConversions._

/**
 * Created by ncavallo on 22/05/15.
 */
object AddressBook extends App with GumtreeCodingChallenge with AddressBookReader with Settings {
  override val config: Config = ConfigFactory.parseMap(Map("app.addressBook" -> "AddressBook"))

  println(s"1. $countMales are males in AddressBook")
  println(s"2. $oldest is the oldest contact in AddressBook")
  val bill = addresses.find(_.name.startsWith("Bill "))
  val paul = addresses.find(_.name.startsWith("Paul "))
  if (bill.isEmpty || paul.isEmpty) {
    throw new RuntimeException("Either Paul or Bill do not exist in this address book")
  }
  println(s"3. ${bill.get} is ${daysDiff(bill.get,paul.get)} days older than ${paul.get} according to AddressBook")

}
