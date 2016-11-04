package com.apischan.stanfytest.guice

import java.util

import com.apischan.stanfytest.dto.{CandidateDto, SkillDto}
import com.apischan.stanfytest.guice.RepositoryMockModule.{CandidateRepositoryMock, SkillRepositoryImpl}
import com.apischan.stanfytest.repository.{CandidateRepository, SkillRepository}
import com.google.inject.{AbstractModule, Scopes}
import org.jooq.DSLContext

class RepositoryMockModule extends AbstractModule {
  override def configure() = {
    bind(classOf[CandidateRepository]).to(classOf[CandidateRepositoryMock]).in(Scopes.SINGLETON)
    bind(classOf[SkillRepository]).to(classOf[SkillRepositoryImpl]).in(Scopes.SINGLETON)
  }
}

object RepositoryMockModule {
  class CandidateRepositoryMock extends CandidateRepository {
    override def getCandidateById(id: Integer): CandidateDto = CandidateDto.of(1, "Vasya", "Pupkin")

    override def getAllCandidates: util.List[CandidateDto] = {
      val vasya = CandidateDto.of(1, "Vasya", "Pupkin")
      vasya.setSkills(util.Arrays.asList(
        SkillDto.of(1, "html"),
        SkillDto.of(2, "css")
      ))
      val petya = CandidateDto.of(2, "Petya", "Ivanchuk")
      petya.setSkills(util.Arrays.asList(
        SkillDto.of(3, "java"),
        SkillDto.of(2, "css")
      ))
      util.Arrays.asList(vasya, petya)
    }

    override def saveCandidate(candidate: CandidateDto): Unit = ()
  }

  class SkillRepositoryImpl extends SkillRepository {
    override def getSkillByName(name: String): SkillDto = ???

    override def getSkillById(id: Integer): SkillDto = ???

    override def saveSkill(skill: SkillDto, context: DSLContext): Integer = ???

    override def getAllSkills: util.List[SkillDto] = ???
  }
}
