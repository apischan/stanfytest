/**
 * This class is generated by jOOQ
 */
package com.apischan.stanfytest.jooq.tables.records;


import com.apischan.stanfytest.jooq.tables.Skill;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
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
public class SkillRecord extends TableRecordImpl<SkillRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = -549446249;

    /**
     * Setter for <code>public.skill.id</code>.
     */
    public SkillRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.skill.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.skill.name</code>.
     */
    public SkillRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.skill.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Skill.SKILL.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Skill.SKILL.NAME;
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
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SkillRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SkillRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SkillRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SkillRecord
     */
    public SkillRecord() {
        super(Skill.SKILL);
    }

    /**
     * Create a detached, initialised SkillRecord
     */
    public SkillRecord(Integer id, String name) {
        super(Skill.SKILL);

        set(0, id);
        set(1, name);
    }
}