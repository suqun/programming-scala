package society{

  package professional {
    class Executive {
      private[professional] var workDetails = null
      private[society] var friends = null
      private[this] var secrets = null
      
      def help(another : Executive){
        println(another.workDetails)
        println(another.secrets)//Error
      }
    }
  }

  package social {
   class Acquaintance {
     def socialize(person: professional.Executive) {
       println(person.friends)
       println(person.workDetails)
     }
   }
  }
}
