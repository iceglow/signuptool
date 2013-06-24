
package ladok.lpw.service.register.facadeclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for regVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="regVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="admission" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="callStatusImpl" type="{http://facadeclient.register.service.lpw.ladok/}callStatusImpl" minOccurs="0"/>
 *         &lt;element name="examen" type="{http://facadeclient.register.service.lpw.ladok/}examenVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="messages" type="{http://facadeclient.register.service.lpw.ladok/}message" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="person" type="{http://facadeclient.register.service.lpw.ladok/}personVO" minOccurs="0"/>
 *         &lt;element name="programAntagning" type="{http://facadeclient.register.service.lpw.ladok/}antlinRegVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="programCourses" type="{http://facadeclient.register.service.lpw.ladok/}courseAdmissionVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="programs" type="{http://facadeclient.register.service.lpw.ladok/}programAdmissionVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="regList" type="{http://facadeclient.register.service.lpw.ladok/}regListEntVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="register" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="resultList" type="{http://facadeclient.register.service.lpw.ladok/}resultListVO" minOccurs="0"/>
 *         &lt;element name="resultat" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="samarbeten" type="{http://facadeclient.register.service.lpw.ladok/}educationalCooperationVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="singleSubjectCourses" type="{http://facadeclient.register.service.lpw.ladok/}courseAdmissionVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="studieavgift" type="{http://facadeclient.register.service.lpw.ladok/}studAvgVO" minOccurs="0"/>
 *         &lt;element name="studyBreaks" type="{http://facadeclient.register.service.lpw.ladok/}upphprogrVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="termin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tuitionfee" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="valid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "regVO", propOrder = {
    "admission",
    "callStatusImpl",
    "examen",
    "messages",
    "person",
    "programAntagning",
    "programCourses",
    "programs",
    "regList",
    "register",
    "resultList",
    "resultat",
    "samarbeten",
    "singleSubjectCourses",
    "studieavgift",
    "studyBreaks",
    "termin",
    "tuitionfee",
    "valid"
})
public class RegVO {

    protected boolean admission;
    protected CallStatusImpl callStatusImpl;
    @XmlElement(nillable = true)
    protected List<ExamenVO> examen;
    @XmlElement(nillable = true)
    protected List<Message> messages;
    protected PersonVO person;
    @XmlElement(nillable = true)
    protected List<AntlinRegVO> programAntagning;
    @XmlElement(nillable = true)
    protected List<CourseAdmissionVO> programCourses;
    @XmlElement(nillable = true)
    protected List<ProgramAdmissionVO> programs;
    @XmlElement(nillable = true)
    protected List<RegListEntVO> regList;
    protected boolean register;
    protected ResultListVO resultList;
    protected boolean resultat;
    @XmlElement(nillable = true)
    protected List<EducationalCooperationVO> samarbeten;
    @XmlElement(nillable = true)
    protected List<CourseAdmissionVO> singleSubjectCourses;
    protected StudAvgVO studieavgift;
    @XmlElement(nillable = true)
    protected List<UpphprogrVO> studyBreaks;
    protected String termin;
    protected boolean tuitionfee;
    protected boolean valid;

    /**
     * Gets the value of the admission property.
     * 
     */
    public boolean isAdmission() {
        return admission;
    }

    /**
     * Sets the value of the admission property.
     * 
     */
    public void setAdmission(boolean value) {
        this.admission = value;
    }

    /**
     * Gets the value of the callStatusImpl property.
     * 
     * @return
     *     possible object is
     *     {@link CallStatusImpl }
     *     
     */
    public CallStatusImpl getCallStatusImpl() {
        return callStatusImpl;
    }

    /**
     * Sets the value of the callStatusImpl property.
     * 
     * @param value
     *     allowed object is
     *     {@link CallStatusImpl }
     *     
     */
    public void setCallStatusImpl(CallStatusImpl value) {
        this.callStatusImpl = value;
    }

    /**
     * Gets the value of the examen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the examen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExamen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExamenVO }
     * 
     * 
     */
    public List<ExamenVO> getExamen() {
        if (examen == null) {
            examen = new ArrayList<ExamenVO>();
        }
        return this.examen;
    }

    /**
     * Gets the value of the messages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Message }
     * 
     * 
     */
    public List<Message> getMessages() {
        if (messages == null) {
            messages = new ArrayList<Message>();
        }
        return this.messages;
    }

    /**
     * Gets the value of the person property.
     * 
     * @return
     *     possible object is
     *     {@link PersonVO }
     *     
     */
    public PersonVO getPerson() {
        return person;
    }

    /**
     * Sets the value of the person property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonVO }
     *     
     */
    public void setPerson(PersonVO value) {
        this.person = value;
    }

    /**
     * Gets the value of the programAntagning property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the programAntagning property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProgramAntagning().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AntlinRegVO }
     * 
     * 
     */
    public List<AntlinRegVO> getProgramAntagning() {
        if (programAntagning == null) {
            programAntagning = new ArrayList<AntlinRegVO>();
        }
        return this.programAntagning;
    }

    /**
     * Gets the value of the programCourses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the programCourses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProgramCourses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CourseAdmissionVO }
     * 
     * 
     */
    public List<CourseAdmissionVO> getProgramCourses() {
        if (programCourses == null) {
            programCourses = new ArrayList<CourseAdmissionVO>();
        }
        return this.programCourses;
    }

    /**
     * Gets the value of the programs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the programs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrograms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProgramAdmissionVO }
     * 
     * 
     */
    public List<ProgramAdmissionVO> getPrograms() {
        if (programs == null) {
            programs = new ArrayList<ProgramAdmissionVO>();
        }
        return this.programs;
    }

    /**
     * Gets the value of the regList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegListEntVO }
     * 
     * 
     */
    public List<RegListEntVO> getRegList() {
        if (regList == null) {
            regList = new ArrayList<RegListEntVO>();
        }
        return this.regList;
    }

    /**
     * Gets the value of the register property.
     * 
     */
    public boolean isRegister() {
        return register;
    }

    /**
     * Sets the value of the register property.
     * 
     */
    public void setRegister(boolean value) {
        this.register = value;
    }

    /**
     * Gets the value of the resultList property.
     * 
     * @return
     *     possible object is
     *     {@link ResultListVO }
     *     
     */
    public ResultListVO getResultList() {
        return resultList;
    }

    /**
     * Sets the value of the resultList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultListVO }
     *     
     */
    public void setResultList(ResultListVO value) {
        this.resultList = value;
    }

    /**
     * Gets the value of the resultat property.
     * 
     */
    public boolean isResultat() {
        return resultat;
    }

    /**
     * Sets the value of the resultat property.
     * 
     */
    public void setResultat(boolean value) {
        this.resultat = value;
    }

    /**
     * Gets the value of the samarbeten property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the samarbeten property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSamarbeten().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EducationalCooperationVO }
     * 
     * 
     */
    public List<EducationalCooperationVO> getSamarbeten() {
        if (samarbeten == null) {
            samarbeten = new ArrayList<EducationalCooperationVO>();
        }
        return this.samarbeten;
    }

    /**
     * Gets the value of the singleSubjectCourses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the singleSubjectCourses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSingleSubjectCourses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CourseAdmissionVO }
     * 
     * 
     */
    public List<CourseAdmissionVO> getSingleSubjectCourses() {
        if (singleSubjectCourses == null) {
            singleSubjectCourses = new ArrayList<CourseAdmissionVO>();
        }
        return this.singleSubjectCourses;
    }

    /**
     * Gets the value of the studieavgift property.
     * 
     * @return
     *     possible object is
     *     {@link StudAvgVO }
     *     
     */
    public StudAvgVO getStudieavgift() {
        return studieavgift;
    }

    /**
     * Sets the value of the studieavgift property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudAvgVO }
     *     
     */
    public void setStudieavgift(StudAvgVO value) {
        this.studieavgift = value;
    }

    /**
     * Gets the value of the studyBreaks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the studyBreaks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStudyBreaks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UpphprogrVO }
     * 
     * 
     */
    public List<UpphprogrVO> getStudyBreaks() {
        if (studyBreaks == null) {
            studyBreaks = new ArrayList<UpphprogrVO>();
        }
        return this.studyBreaks;
    }

    /**
     * Gets the value of the termin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermin() {
        return termin;
    }

    /**
     * Sets the value of the termin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermin(String value) {
        this.termin = value;
    }

    /**
     * Gets the value of the tuitionfee property.
     * 
     */
    public boolean isTuitionfee() {
        return tuitionfee;
    }

    /**
     * Sets the value of the tuitionfee property.
     * 
     */
    public void setTuitionfee(boolean value) {
        this.tuitionfee = value;
    }

    /**
     * Gets the value of the valid property.
     * 
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * Sets the value of the valid property.
     * 
     */
    public void setValid(boolean value) {
        this.valid = value;
    }

}
