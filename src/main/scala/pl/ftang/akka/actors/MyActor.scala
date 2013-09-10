package pl.ftang.akka.actors

import akka.actor.Actor
import akka.actor.Props
import akka.event.Logging

class MyActor extends Actor {
  val log = Logging(context.system, this)

  // The result of the receive method is a partial function object,
  // which is stored within the actor as its “initial behavior”
  def receive = {
    case "test" => log.info("received test")
    case _      => log.info("received unknown message")
  }

  // lifecycle methods - defined in Actor trait
  override def preStart(): Unit = ()

  override def postStop(): Unit = ()

  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    context.children foreach { child ⇒
      context.unwatch(child)
      context.stop(child)
    }
    postStop()
  }

  override def postRestart(reason: Throwable): Unit = {
    preStart()
  }
}

object MyActor {

  // usage: context.actorOf(DemoActor.props("hello"))
  def props(name: String): Props = Props(classOf[MyActor], name)
}