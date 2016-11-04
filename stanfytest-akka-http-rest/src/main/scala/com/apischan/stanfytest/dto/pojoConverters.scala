package com.apischan.stanfytest.dto

import com.apischan.stanfytest.service.{Candidate, Skill}

import scala.collection.JavaConverters._

object pojoConverters {

  implicit def java2ScalaSkill(skill: SkillDto): Skill =
    Skill(skill.getId, skill.getSkillName)

  implicit def java2ScalaCandidate(candidate: CandidateDto): Candidate =
    Candidate(candidate.getId, candidate.getFirstname, candidate.getLastname, candidate.getSkills.asScala.toList.map(java2ScalaSkill))

  implicit def scala2javaSkill(skill: Skill): SkillDto =
    SkillDto.of(skill.id, skill.name)

  implicit def scala2javaCandidate(candidate: Candidate): CandidateDto = {
    val candidateDto: CandidateDto = CandidateDto.of(candidate.id, candidate.firstname, candidate.lastname)
    candidateDto.setSkills(candidate.skills.map(scala2javaSkill).asJava)
    candidateDto
  }
}
