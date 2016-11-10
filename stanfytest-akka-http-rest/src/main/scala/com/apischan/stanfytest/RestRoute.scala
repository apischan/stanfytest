package com.apischan.stanfytest

import akka.Done
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.marshalling.ToResponseMarshallable
import akka.http.scaladsl.model.{StatusCode, StatusCodes}
import akka.http.scaladsl.server._
import com.apischan.stanfytest.guice.RepositoryMockModule
import com.apischan.stanfytest.service.{Candidate, CandidateService, Skill}
import com.google.inject.Guice
import spray.json.DefaultJsonProtocol

import scala.concurrent.Future

// formats for unmarshalling and marshalling
trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val skillFormat = jsonFormat2(Skill)
  implicit val candidateFormat = jsonFormat4(Candidate)
}

class RestRoute extends Directives with JsonSupport {
  import RestRoute._
  //    implicit val injector = Guice.createInjector(new DatabaseModule())
  implicit val injector = Guice.createInjector(new RepositoryMockModule())

  val candidateService = CandidateService()

  val route: Route =
  get {
    path("candidates") {
      onSuccess(candidateService.allCandidates) {
        candidates => complete(candidates)
      }
    }

    pathPrefix("candidates" / IntNumber) { id =>
      // there might be no item for a given id
      val maybeCandidate: Future[Option[Candidate]] = candidateService.findCandidateById(id)
      onSuccess(maybeCandidate) {
        case Some(candidate) => complete(candidate)
        case None            => complete(StatusCodes.NotFound)
      }
    }

    path("skills") {
      complete(StatusCodes.NotFound)
    }

    pathPrefix("skills" / LongNumber) { id =>
      complete(StatusCodes.NotFound)
    }
  } ~
    post {
      path("candidates") {
        entity(as[Candidate]) { candidate =>
          val saved: Future[Done] = candidateService.saveCandidate(candidate)
          onComplete(saved) { done =>
            complete(StatusCodes.OK)
          }
        }
      }
    }
}

object RestRoute {
  implicit def statusCodeConvert(code: StatusCode): ToResponseMarshallable = ToResponseMarshallable(code)
}

