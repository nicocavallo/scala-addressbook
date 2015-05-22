package gumtree.nicocavallo

import org.scalatest.{Matchers, WordSpec}

/**
 * Created by ncavallo on 22/05/15.
 */
class AddressBookSpec extends WordSpec with Matchers {

  object SimpleAddressBook extends GumtreeCodingChallenge with AddressBookReader {
    override val addresses: Seq[Contact] = Seq(
      Contact("Bill McKnight, Male, 16/03/77"),
      Contact("Paul Robinson, Male, 15/01/85"),
      Contact("Gemma Lane, Female, 20/11/91"),
      Contact("Sarah Stone, Female, 20/09/80"),
      Contact("Wes Jackson, Male, 14/08/74"))
  }
  
  object EmptyAddressBook extends GumtreeCodingChallenge with AddressBookReader {
    override val addresses: Seq[Contact] = Seq()
  }

  "AddressBook" should {
    "return 3 for counting males " in {
      SimpleAddressBook.countMales shouldBe 3
    }

    "return 0 for counting males " in {
      EmptyAddressBook.countMales shouldBe 0
    }

    "return 'Wes Jackson' for the oldest person " in {
      val oldest = SimpleAddressBook.oldest
      oldest.isDefined shouldBe true
      oldest.get.name shouldBe "Wes Jackson"
    }

    "return 'None' for the oldest person " in {
      EmptyAddressBook.oldest shouldBe None
    }

    "return 2863 for how many days is Bill older than Paul" in {
      SimpleAddressBook.daysDiff("Bill McKnight","Paul Robinson") shouldBe Some(2862)
    }

    "return 0 for how many days is Bill older than Paul" in {
      SimpleAddressBook.daysDiff("Bill McKnight","Bill McKnight") shouldBe Some(0)
    }

    "return value < 0 (-2862) for how many days is Bill older than Paul" in {
      SimpleAddressBook.daysDiff("Paul Robinson","Bill McKnight") shouldBe Some(-2862)
    }

    "return 'None' for how many days is Bill older than Paul" in {
      EmptyAddressBook.daysDiff("Bill McKnight","Paul Robinson") shouldBe None
    }
  }

}
