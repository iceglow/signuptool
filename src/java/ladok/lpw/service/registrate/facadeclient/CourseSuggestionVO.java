
package ladok.lpw.service.registrate.facadeclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for courseSuggestionVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="courseSuggestionVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="courseRegSuggestions" type="{http://facadeclient.registrate.service.lpw.ladok/}courseRegistrationVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="enamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="existingCourseRegistrations" type="{http://facadeclient.registrate.service.lpw.ladok/}courseRegistrationVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="messages" type="{http://facadeclient.registrate.service.lpw.ladok/}message" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="pnr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="semester" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "courseSuggestionVO", propOrder = {
    "courseRegSuggestions",
    "enamn",
    "existingCourseRegistrations",
    "messages",
    "pnr",
    "semester",
    "tnamn",
    "valid"
})
public class CourseSuggestionVO {

    @XmlElement(nillable = true)
    protected List<CourseRegistrationVO> courseRegSuggestions;
    protected String enamn;
    @XmlElement(nillable = true)
    protected List<CourseRegistrationVO> existingCourseRegistrations;
    @XmlElement(nillable = true)
    protected List<Message> messages;
    protected String pnr;
    protected String semester;
    protected String tnamn;
    protected boolean valid;

    /**
     * Gets the value of the courseRegSuggestions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the courseRegSuggestions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourseRegSuggestions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CourseRegistrationVO }
     * 
     * 
     */
    public List<CourseRegistrationVO> getCourseRegSuggestions() {
        if (courseRegSuggestions == null) {
            courseRegSuggestions = new ArrayList<CourseRegistrationVO>();
        }
        return this.courseRegSuggestions;
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
     * Gets the value of the existingCourseRegistrations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the existingCourseRegistrations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExistingCourseRegistrations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CourseRegistrationVO }
     * 
     * 
     */
    public List<CourseRegistrationVO> getExistingCourseRegistrations() {
        if (existingCourseRegistrations == null) {
            existingCourseRegistrations = new ArrayList<CourseRegistrationVO>();
        }
        return this.existingCourseRegistrations;
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
