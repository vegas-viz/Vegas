package vegas.util

import java.util.{Calendar, GregorianCalendar, TimeZone}

/**
  * Annoying but necessary (open to other suggestions though) utils for dealing with
  * dates / times in Scala/Java
  */
object Time {

  /**
    * Makes a java.util.Date with the given year, month, day, and adjusts for local timezone.
    * @param year The year (i.e. 2015)
    * @param month The month number: 1-12 (i.e. 12 == December)
    * @param day The day of the month: 1-31.
    * @param hour The hour of the day (e.g. 23)
    * @param minutes The minutes of the hour (e.g. 59)
    * @param seconds The seconds of minute (e.g. 59)
    * @param timeZone The timezone of given date (i.e. "PST"). Defaults to PST.
    * @return A java.util Date object
    */
  def mkDate(year: Int, month: Int, day: Int, hour: Int = 0, minutes: Int = 0, seconds: Int = 0, timeZone: String = "PST"): java.util.Date = {
    val refTimeZone = TimeZone.getTimeZone(timeZone)
    val time = new GregorianCalendar(refTimeZone)
    time.set(year, month - 1, day, hour, minutes, seconds)

    // Annoying but necessary to make sure timezones on different machines don't break
    // the test.
    val localOffset: Int = TimeZone.getDefault.getRawOffset
    val refOffset: Int = refTimeZone.getRawOffset
    time.add(Calendar.MILLISECOND, refOffset - localOffset)

    time.getTime
  }

  def mkSqlDate(year: Int, month: Int, day: Int, timeZone: String = "PST") = new java.sql.Date(mkDate(year, month, day, timeZone=timeZone).getTime)
  def mkSqlTimestamp(year: Int, month: Int, day: Int, hour: Int, minutes: Int, seconds: Int,
                     timeZone: String = "PST") = new java.sql.Timestamp(mkDate(year, month, day, hour, minutes, seconds, timeZone).getTime)


}
