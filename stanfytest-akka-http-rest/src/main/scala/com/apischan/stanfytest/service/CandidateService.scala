package com.apischan.stanfytest.service

import akka.Done
import com.apischan.stanfytest.dto.pojoConverters._
import com.apischan.stanfytest.repository.CandidateRepository
import com.google.inject.Injector

import scala.concurrent.Future
import scala.collection.JavaConverters._
import scala.concurrent.ExecutionContext.Implicits.global

class CandidateService(val candidateRepository: CandidateRepository) {
  def allCandidates: Future[List[Candidate]] = Future {
    candidateRepository.getAllCandidates.asScala.toList.map(java2ScalaCandidate)
  }

  def findCandidateById(id: Int): Future[Option[Candidate]] = Future {
    Option(candidateRepository.getCandidateById(id))
  }

  def saveCandidate(candidate: Candidate): Future[Done] = Future {
    candidateRepository.saveCandidate(candidate)
    Done
  }
}

case class Candidate(id: Int, firstname: String, lastname: String, skills: List[Skill])

object CandidateService {

  def apply()(implicit injector: Injector): CandidateService =
    new CandidateService(injector.getInstance(classOf[CandidateRepository]))

}
