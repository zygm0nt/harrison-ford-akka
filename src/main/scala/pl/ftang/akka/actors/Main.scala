package pl.ftang.akka.actors

import akka.actor.ActorDSL._
import akka.actor.{Props, ActorSystem}

object Main extends App {
  // ActorSystem is a heavy object: create only one per application
  val system = ActorSystem("mySystem")
  val myActor = system.actorOf(Props[MyActor], "myactor2")

  // communicate with actors
  implicit val i = inbox()
  myActor ! "hello"
  i.receive()
  // or
  i watch myActor
}