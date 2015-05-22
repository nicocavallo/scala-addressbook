package gumtree.nicocavallo

import java.util.concurrent.TimeUnit

/**
 * Created by ncavallo on 22/05/15.
 */
trait GumtreeCodingChallenge { self: AddressBookReader =>

  def countMales = {
    addresses.count(c => "Male".equals(c.gender))
  }

  def oldest =  addresses.minBy(_.birthDay)

  def daysDiff(from: Contact, to: Contact) = {
    val diff = to.birthDay.getTime - from.birthDay.getTime
    val timeUnit = TimeUnit.DAYS
    timeUnit.convert(diff, TimeUnit.MILLISECONDS) + 1
  }

}
