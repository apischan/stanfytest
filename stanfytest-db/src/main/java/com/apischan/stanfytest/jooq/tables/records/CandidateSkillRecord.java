/**
 * This class is generated by jOOQ
 */
package com.apischan.stanfytest.jooq.tables.records;


import com.apischan.stanfytest.jooq.tables.CandidateSkill;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CandidateSkillRecord extends TableRecordImpl<CandidateSkillRecord> implements Record3<Integer, Integer, Integer> {

    private static final long serialVersionUID = 1112211444;

    /**
     * Setter for <code>public.candidate_skill.id</code>.
     */
    public CandidateSkillRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.candidate_skill.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.candidate_skill.candidate_id</code>.
     */
    public CandidateSkillRecord setCandidateId(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.candidate_skill.candidate_id</code>.
     */
    public Integer getCandidateId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.candidate_skill.skill_id</code>.
     */
    public CandidateSkillRecord setSkillId(Integer value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.candidate_skill.skill_id</code>.
     */
    public Integer getSkillId() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return CandidateSkill.CANDIDATE_SKILL.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return CandidateSkill.CANDIDATE_SKILL.CANDIDATE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return CandidateSkill.CANDIDATE_SKILL.SKILL_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getCandidateId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getSkillId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CandidateSkillRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CandidateSkillRecord value2(Integer value) {
        setCandidateId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CandidateSkillRecord value3(Integer value) {
        setSkillId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CandidateSkillRecord values(Integer value1, Integer value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CandidateSkillRecord
     */
    public CandidateSkillRecord() {
        super(CandidateSkill.CANDIDATE_SKILL);
    }

    /**
     * Create a detached, initialised CandidateSkillRecord
     */
    public CandidateSkillRecord(Integer id, Integer candidateId, Integer skillId) {
        super(CandidateSkill.CANDIDATE_SKILL);

        set(0, id);
        set(1, candidateId);
        set(2, skillId);
    }
}
