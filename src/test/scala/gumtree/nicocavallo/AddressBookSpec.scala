package gumtree.nicocavallo

import java.util.concurrent.TimeUnit

import com.typesafe.config.{ConfigFactory, Config}
import org.scalatest.{Matchers, WordSpec}
import scala.collection.JavaConversions._

/**
 * Created by ncavallo on 22/05/15.
 */
class AddressBookSpec extends WordSpec with Matchers with Settings with AddressBookReader with GumtreeCodingChallenge {

  "AddressBook" should {
    "return 3 for counting males " in {
      countMales shouldBe 3
    }

    "return 'Wes Jackson' for the oldest person " in {
      oldest.name shouldBe "Wes Jackson"
    }

    "return 2863 for how many days is Bill older than Paul" in {
      val bill = Contact("Bill McKnight, Male, 16/03/77")
      val paul = Contact("Paul Robinson, Male, 15/01/85")
      daysDiff(bill,paul) shouldBe 2863 //Including Paul's birthday
    }
  }
  override val config: Config = ConfigFactory.parseMap(Map("app.addressBook" -> "AddressBook"))
}
