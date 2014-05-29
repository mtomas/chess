name := "chess-assignment-scalac"

version := "1.0"

//for larger boards we need more memory in run configuration
fork in run := true

javaOptions in run ++= Seq("-Xms4G", "-Xmx4G")
    