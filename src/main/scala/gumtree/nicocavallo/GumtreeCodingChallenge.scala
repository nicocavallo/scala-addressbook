package gumtree.nicocavallo

import java.util.concurrent.TimeUnit._

import scala.util.Try

/**
 * Created by ncavallo on 22/05/15.
 */
trait GumtreeCodingChallenge {
  self: AddressBookReader =>

  /**
   * Helper storage for optimizing count by gender
   */
  private lazy val byGender = addresses.groupBy[String](c => c.gender).mapValues(_.size)

  /**
   * Another helper storage for optimizing access to the users by name.
   */
  private lazy val byName = addresses.groupBy(_.name)

  /**
   * Counts how many males are in the Address Book
   * @return number of males in the Address Book, 0 if it is empty
   */
  def countMales = {
    countByGender("Male")
  }

  private def countByGender(gender: String) = byGender.getOrElse(gender,0)

  /**
   * This method returns the oldest contact (if Address Book is not empty).
   * @return an Option: 'Some oldest contact' or 'None' if the Address Book is empty
   */
  def oldest: Option[Contact] = {
    Try(addresses.minBy(_.birthDay)).toOption
  }

  /**
   *
   * @param fromName - Oldest person's name to compare. Should not be null
   * @param toName - Youngest person's name to compare. Should not be null
   * @return an Option:
   *         - Some(days) where days can be 0 if 'from' and 'to' are the same person or were born in the same day
   *         - None if any or both of them does not exist or if there is a duplicated name in the AddressBook
   */
  def daysDiff(fromName: String, toName: String): Option[Long] = {
    require(Option(fromName).isDefined && Option(toName).isDefined)

    val fromOpt = byName.get(fromName)
    val toOpt = byName.get(toName)
    for {
      from <- fromOpt
      to <- toOpt
      if from.size == 1 && to.size == 1
    } yield {
      val diff = to.head.birthDay.getTime - from.head.birthDay.getTime
      DAYS.convert(diff, MILLISECONDS)
    }
  }

}
