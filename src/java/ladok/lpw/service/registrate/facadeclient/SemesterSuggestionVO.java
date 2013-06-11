
package ladok.lpw.service.registrate.facadeclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for semesterSuggestionVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="semesterSuggestionVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="coursesForSemesters" type="{http://facadeclient.registrate.service.lpw.ladok/}courseRegistrationVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="enamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="existingSemesterRegistrations" type="{http://facadeclient.registrate.service.lpw.ladok/}semesterRegistrationVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="messages" type="{http://facadeclient.registrate.service.lpw.ladok/}message" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="pnr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="semester" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="semesterRegSuggestions" type="{http://facadeclient.registrate.service.lpw.ladok/}semesterRegistrationVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="tnamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "semesterSuggestionVO", propOrder = {
    "coursesForSemesters",
    "enamn",
    "existingSemesterRegistrations",
    "messages",
    "pnr",
    "semester",
    "semesterRegSuggestions",
    "tnamn",
    "valid"
})
public class SemesterSuggestionVO {

    @XmlElement(nillable = true)
    protected List<CourseRegistrationVO> coursesForSemesters;
    protected String enamn;
    @XmlElement(nillable = true)
    protected List<SemesterRegistrationVO> existingSemesterRegistrations;
    @XmlElement(nillable = true)
    protected List<Message> messages;
    protected String pnr;
    protected String semester;
    @XmlElement(nillable = true)
    protected List<SemesterRegistrationVO> semesterRegSuggestions;
    protected String tnamn;
    protected boolean valid;

    /**
     * Gets the value of the coursesForSemesters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the coursesForSemesters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCoursesForSemesters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CourseRegistrationVO }
     * 
     * 
     */
    public List<CourseRegistrationVO> getCoursesForSemesters() {
        if (coursesForSemesters == null) {
            coursesForSemesters = new ArrayList<CourseRegistrationVO>();
        }
        return this.coursesForSemesters;
    }

    /**
     * Gets the value of the enamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnamn() {
        return enamn;
    }

    /**
     * Sets the value of the enamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnamn(String value) {
        this.enamn = value;
    }

    /**
     * Gets the value of the existingSemesterRegistrations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the existingSemesterRegistrations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExistingSemesterRegistrations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SemesterRegistrationVO }
     * 
     * 
     */
    public List<SemesterRegistrationVO> getExistingSemesterRegistrations() {
        if (existingSemesterRegistrations == null) {
            existingSemesterRegistrations = new ArrayList<SemesterRegistrationVO>();
        }
        return this.existingSemesterRegistrations;
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
     * Gets the value of the pnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPnr() {
        return pnr;
    }

    /**
     * Sets the value of the pnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPnr(String value) {
        this.pnr = value;
    }

    /**
     * Gets the value of the semester property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Sets the value of the semester property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSemester(String value) {
        this.semester = value;
    }

    /**
     * Gets the value of the semesterRegSuggestions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the semesterRegSuggestions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSemesterRegSuggestions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SemesterRegistrationVO }
     * 
     * 
     */
    public List<SemesterRegistrationVO> getSemesterRegSuggestions() {
        if (semesterRegSuggestions == null) {
            semesterRegSuggestions = new ArrayList<SemesterRegistrationVO>();
        }
        return this.semesterRegSuggestions;
    }

    /**
     * Gets the value of the tnamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTnamn() {
        return tnamn;
    }

    /**
     * Sets the value of the tnamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTnamn(String value) {
        this.tnamn = value;
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
