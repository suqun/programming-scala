def processCoordinates(input: Any) {
  input match {
    case (a,b) => printf("Processing (%d,%d)...",a,b)
    case "done" => println("done")
    case _ => null
  }
}

processCoordinates((39,-104))
processCoordinates("done")
/*
Processing (39,-104)...done
*/




