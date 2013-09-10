package pl.ftang.akka.actors

import akka.actor.{Actor, Props}

class HierarchicalActor extends Actor {

  /*
    The call to actorOf returns an instance of ActorRef. This is a handle to
    the actor instance and the only way to interact with it. The ActorRef is
    immutable and has a one to one relationship with the Actor it represents.
    The ActorRef is also serializable and network-aware. This means that you can
    serialize it, send it over the wire and use it on a remote host and it will
    still be representing the same Actor on the original node, across the network.
   */
  val child = context.actorOf(Props[MyActor], name = "myChild")

  def receive = ???
}
