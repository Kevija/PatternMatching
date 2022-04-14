package com.github.Evija

object ReadingFiles extends App {
  val url = "https://gutenberg.org/files/345/345-0.txt"
  //val text = Util.getTextFromWeb(url) //we make a get request on the web resource
  val dst = "src/resources/StokerB_Dracula.txt"
 // Util.saveText(dst, text)

  val src = "src/resources"
  val files = Util.getListOfFiles(src)

 val text = Util.getTextFromWebAndSave(url, dst)

  val lines = Util.getLinesFromFile(dst)
  val wordCountPerLine = Util.getWordCountPerLine(lines)

  val characterCount = Util.getCharacterCount(lines)
  val wordCount = wordCountPerLine.sum
  println(s"Total words in ${files.tail.toString} are $wordCount")

  val avgCount = wordCount*1.0 / lines.length
  val roundedCount = Util.myRound(avgCount, 2)

  val lineCount = Util.getLinesFromFile(dst).length
  println(s"Total number of characters is ${characterCount}")
  println(s"Total number of lines is ${lineCount}")
  println(s"Total word count is $wordCount")
  println(s"Average word count in each line is $roundedCount")
}


