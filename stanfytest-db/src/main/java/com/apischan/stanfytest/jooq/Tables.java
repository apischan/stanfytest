/**
 * This class is generated by jOOQ
 */
package com.apischan.stanfytest.jooq;


import com.apischan.stanfytest.jooq.tables.Candidate;
import com.apischan.stanfytest.jooq.tables.CandidateSkill;
import com.apischan.stanfytest.jooq.tables.Skill;
import com.apischan.stanfytest.jooq.tables.Vacancy;
import com.apischan.stanfytest.jooq.tables.VacancySkill;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.candidate</code>.
     */
    public static final Candidate CANDIDATE = com.apischan.stanfytest.jooq.tables.Candidate.CANDIDATE;

    /**
     * The table <code>public.candidate_skill</code>.
     */
    public static final CandidateSkill CANDIDATE_SKILL = com.apischan.stanfytest.jooq.tables.CandidateSkill.CANDIDATE_SKILL;

    /**
     * The table <code>public.skill</code>.
     */
    public static final Skill SKILL = com.apischan.stanfytest.jooq.tables.Skill.SKILL;

    /**
     * The table <code>public.vacancy</code>.
     */
    public static final Vacancy VACANCY = com.apischan.stanfytest.jooq.tables.Vacancy.VACANCY;

    /**
     * The table <code>public.vacancy_skill</code>.
     */
    public static final VacancySkill VACANCY_SKILL = com.apischan.stanfytest.jooq.tables.VacancySkill.VACANCY_SKILL;
}
