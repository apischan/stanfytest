package com.apischan.stanfytest.service

import com.apischan.stanfytest.repository.SkillRepository
import com.google.inject.Injector

class SkillService(val skillRepository: SkillRepository) {

}

case class Skill(id: Int, name: String)

object SkillService {
  def apply()(implicit injector: Injector): SkillService =
    new SkillService(injector.getInstance(classOf[SkillRepository]))
}