/**
 * This class is generated by jOOQ
 */
package com.apischan.stanfytest.jooq.tables.records;


import com.apischan.stanfytest.jooq.tables.Vacancy;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class VacancyRecord extends TableRecordImpl<VacancyRecord> implements Record4<Integer, String, String, String> {

    private static final long serialVersionUID = -1615892164;

    /**
     * Setter for <code>public.vacancy.id</code>.
     */
    public VacancyRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.vacancy.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.vacancy.company_name</code>.
     */
    public VacancyRecord setCompanyName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.vacancy.company_name</code>.
     */
    public String getCompanyName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.vacancy.title</code>.
     */
    public VacancyRecord setTitle(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.vacancy.title</code>.
     */
    public String getTitle() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.vacancy.description</code>.
     */
    public VacancyRecord setDescription(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.vacancy.description</code>.
     */
    public String getDescription() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Vacancy.VACANCY.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Vacancy.VACANCY.COMPANY_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Vacancy.VACANCY.TITLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Vacancy.VACANCY.DESCRIPTION;
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
        return getCompanyName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VacancyRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VacancyRecord value2(String value) {
        setCompanyName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VacancyRecord value3(String value) {
        setTitle(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VacancyRecord value4(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VacancyRecord values(Integer value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached VacancyRecord
     */
    public VacancyRecord() {
        super(Vacancy.VACANCY);
    }

    /**
     * Create a detached, initialised VacancyRecord
     */
    public VacancyRecord(Integer id, String companyName, String title, String description) {
        super(Vacancy.VACANCY);

        set(0, id);
        set(1, companyName);
        set(2, title);
        set(3, description);
    }
}
