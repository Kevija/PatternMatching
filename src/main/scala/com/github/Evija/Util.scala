package com.github.Evija

import java.io.{File, FileWriter}
import java.nio.file.{Files, Paths}
import scala.io.Source

object Util {

  def myRound(n: Double, precision: Int = 0): Double = {
    val multiplier = Math.pow(10, precision)
    (n * multiplier).round / multiplier
  }

  def getTextFromFile(src: String):String = {
    val bufferedSource = Source.fromFile(src)
    val text = bufferedSource.mkString
    bufferedSource.close()
    text
  }

  def getLinesFromFile(src: String):Array[String] = {
    val bufferedSource = Source.fromFile(src)
    val lines = bufferedSource.getLines().toArray
    bufferedSource.close()
    lines
  }

  /**
   *
   * @param dstPath - save Path
   * @param text - string to save
   */
  def saveText(dstPath: String, text: String, append:Boolean=false, verbose:Boolean=false):Unit = {
    //    import java.io.{PrintWriter, File} //explicit import
    if (verbose) println(s"Saving ${text.length} characters to $dstPath")
    //so writing to file can be done either by overwriting the whole file (the default)
    //or by appending to the end of the file
    val fw = new FileWriter(dstPath, append) //so by default old dstPath will be overWritten
    //    val pw = new PrintWriter(new File(dstPath))
    if (append) fw.write("\n") //TODO think about appending custom header
    fw.write(text)
    fw.close() //when writing it is especially important to close as early as possible
  }


  /**
   *
   * @param url - web resource locator
   * @return - we return the whole web page as string
   */
  def getTextFromWeb(url: String): String = {
    val html = Source.fromURL(url) //this gets us BuffereSource stream
    html.mkString //so we just get a string representation it could be pure txt, it be html, it be xml,
  }

  /**
   *
   * @param url - web resource locator
   * @param dst - destination file path
   * @return - returns text string from the url (could be txt, html, xml, json, etc)
   */
  def getTextFromWebAndSave(url: String, dst: String):String = {
    val text = getTextFromWeb(url)
    saveText(dst, text)
    text //we return the text just in case we want to save and do some work as well
  }

  /**
   * get a list of Files
   * adopted from https://alvinalexander.com/scala/how-to-list-files-in-directory-filter-names-scala/
   * @param dir - listing path
   * @param regex - match to filter by, default is all files of name length 1 or more
   * @return - returns list of Files
   */
  def getListOfFiles(dir: String, regex:String=".*"):List[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
      //      d.listFiles.filter(_.isFile).toList
      d.listFiles.filter(file => file.isFile && file.getName.matches(regex) ).toList //FIXME regex
    } else {
      List[File]() //we return an empty list of Files if nothing is found
    }
  }

  /**
   *
   * @param filePath
   * @return true or false whether file exists at the location
   */
  def isFileTHere(filePath:String):Boolean = {
    val path = Paths.get(filePath)
    Files.exists(path)
  }

  /**
   *
   * @param lines
   * @param newLine
   * @return
   */
  def getCharacterCount(lines: Array[String], newLine:String="\n"):Int = {
    lines.mkString(newLine).length //we build up a string and return its length
  }

  //return wordCount for each Line
  def getWordCountPerLine(lines: Array[String], sep:String=" +"):Array[Int] = {
    val wordsLines = lines.map(_.split(sep))
    val wordsPerLine = wordsLines.map(_.length)
    wordsPerLine
  }
}

