package gumtree.nicocavallo

import java.util.concurrent.TimeUnit

import scala.util.Try

/**
 * Created by ncavallo on 22/05/15.
 */
trait GumtreeCodingChallenge { self: AddressBookReader =>

  private lazy val byGender = addresses.groupBy[String](c => c.gender).mapValues(_.size)

  /**
   * Counts how many males are in the Address Book
   * @return number of males in the Address Book, 0 if it is empty
   */
  def countMales = {
   countByGender("Male")
  }

  private def countByGender(gender: String) = byGender.get(gender).getOrElse(0)

  /**
   * This method returns the oldest contact (if Address Book is not empty).
   * @return an Option: 'Some oldest contact' or 'None' if the Address Book is empty
   */
  def oldest:Option[Contact] = {
    Try(addresses.minBy(_.birthDay)) map { c =>
      Some(c)
    } recover {
      case _ => None
    } get

  }

  /**
   *
   * @param fromName - Oldest person's name to compare
   * @param toName - Youngest person's name to compare
   * @return an Option:
   *         - Some(days) where days can be 0 if 'from' and 'to' are the same person or were born in the same day
   *         - None if any or both of them does not exist in the AddressBook
   */
  def daysDiff(fromName: String, toName: String):Option[Long] = {

    require(fromName != null && toName != null)

    val fromOpt = addresses.find(_.name.equals(fromName))
    val toOpt = addresses.find(_.name.equals(toName))
    for {
      from <- fromOpt
      to <- toOpt
    } yield {
      val diff = to.birthDay.getTime - from.birthDay.getTime
      val timeUnit = TimeUnit.DAYS
      timeUnit.convert(diff, TimeUnit.MILLISECONDS)
    }
  }

}
