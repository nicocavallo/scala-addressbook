package gumtree.nicocavallo

import java.util.concurrent.TimeUnit

import org.scalatest.{Matchers, WordSpec}

/**
 * Created by ncavallo on 22/05/15.
 */
class AddressBookSpec extends WordSpec with Matchers{

  /*
Bill McKnight, Male, 16/03/77
Paul Robinson, Male, 15/01/85
Gemma Lane, Female, 20/11/91
Sarah Stone, Female, 20/09/80
Wes Jackson, Male, 14/08/74
   */

  val addresses = List(
    Contact("Bill McKnight, Male, 16/03/77"),
    Contact("Paul Robinson, Male, 15/01/85"),
    Contact("Gemma Lane, Female, 20/11/91"),
    Contact("Sarah Stone, Female, 20/09/80"),
    Contact("Wes Jackson, Male, 14/08/74"))

  "AddressBook" should {
    "return 3 for counting males " in {
      addresses.count(c => "Male".equals(c.gender)) shouldBe 3
    }

    "return 'Wes Jackson' for the oldest person " in {
      val oldest = addresses.minBy(_.birthDay)
      oldest.name shouldBe "Wes Jackson"
    }

    "return 2863 for how many days is Bill older than Paul" in {
      val bill = Contact("Bill McKnight, Male, 16/03/77")
      val paul = Contact("Paul Robinson, Male, 15/01/85")
      val diff = paul.birthDay.getTime - bill.birthDay.getTime
      val timeUnit = TimeUnit.DAYS
      val diffDays = timeUnit.convert(diff, TimeUnit.MILLISECONDS) + 1
      diffDays shouldBe 2863 //Including Paul's birthday
    }
  }


}
