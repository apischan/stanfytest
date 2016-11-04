package com.apischan.stanfytest

import akka.Done
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.marshalling.ToResponseMarshallable
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.model.StatusCodes.ClientError
import akka.http.scaladsl.server._
import com.apischan.stanfytest.service.{Candidate, CandidateService, Skill}
import com.google.inject.Guice
import spray.json.DefaultJsonProtocol

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

// domain model
final case class Item(name: String, id: Long)
final case class Order(items: List[Item])

// formats for unmarshalling and marshalling
trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val itemFormat = jsonFormat2(Item)
  implicit val orderFormat = jsonFormat1(Order)
  implicit val skillFormat = jsonFormat2(Skill)
  implicit val candidateFormat = jsonFormat4(Candidate)

  implicit def statusCodeConvert(err: ClientError): ToResponseMarshallable = ToResponseMarshallable(err)
}

class RestRoute extends Directives with JsonSupport {

  def fetchItem(itemId: Long): Future[Option[Item]] = Future {
    None
  }
  def saveOrder(order: Order): Future[Done] = ???

  import com.apischan.stanfytest.guice.RepositoryMockModule
//    implicit val injector = Guice.createInjector(new DatabaseModule())
  implicit val injector = Guice.createInjector(new RepositoryMockModule())
  val route: Route =
  get {
      path("candidates") {
        val candidateService = CandidateService()
        onSuccess(candidateService.allCandidates) {
          case Nil        => complete(StatusCodes.NotFound)
          case candidates => complete(candidates)
        }
      }

      pathPrefix("candidates" / LongNumber) { id =>
        // there might be no item for a given id
        val maybeItem: Future[Option[Item]] = fetchItem(id)

        onSuccess(maybeItem) {
          case Some(item) => complete(item)
          case None       => complete(StatusCodes.NotFound)
        }
      }

      path("skills") {
        complete(StatusCodes.NotFound)
      }

      pathPrefix("skills" / LongNumber) { id =>
        complete(ToResponseMarshallable(StatusCodes.NotFound))
      }
  } ~
  post {
    path("candidates") {
      entity(as[Order]) { order =>
        val saved: Future[Done] = ??? //saveOrder(order)
        onComplete(saved) { done =>
          complete("order created")
        }
      }
    }
  }
}
