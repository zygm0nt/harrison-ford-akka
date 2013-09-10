package pl.ftang.akka.actors

import akka.actor.ActorDSL._
import akka.actor.ActorSystem

class DefineActorWithAct {

  implicit val system = ActorSystem("demo")

  val a = actor(new Act {
    become {
      case "hello" => sender ! "hi"
    }
  })

  // become() + unbecome()
  val b = actor(new Act {
    become { // this will replace the initial (empty) behavior
      case "info" => sender ! "A"
      case "switch" =>
        becomeStacked { // this will stack upon the "A" behavior
          case "info"   => sender ! "B"
          case "switch" => unbecome() // return to the "A" behavior
        }
      case "lobotomize" => unbecome() // OH NOES: Actor.emptyBehavior
    }
  })

  // lifecycle hooks
  val c = actor(new Act {
    whenStarting { b ! "started" }
    whenStopping { b ! "stopped" }
  })

  // restart hooks
  val d = actor(new Act {
    become {
      case "die" ⇒ throw new Exception
    }
    whenFailing { case m @ (cause, msg) => b ! m }
    whenRestarted { cause => b ! cause }
  })
}
