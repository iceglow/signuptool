
package ladok.lpw.service.registrate.facadeclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for registrateVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="registrateVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="courseRegistrations" type="{http://facadeclient.registrate.service.lpw.ladok/}courseRegistrationVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="messages" type="{http://facadeclient.registrate.service.lpw.ladok/}message" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="pnr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="semester" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="semesterRegistrations" type="{http://facadeclient.registrate.service.lpw.ladok/}semesterRegistrationVO" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "registrateVO", propOrder = {
    "courseRegistrations",
    "messages",
    "pnr",
    "semester",
    "semesterRegistrations",
    "valid"
})
public class RegistrateVO {

    @XmlElement(nillable = true)
    protected List<CourseRegistrationVO> courseRegistrations;
    @XmlElement(nillable = true)
    protected List<Message> messages;
    protected String pnr;
    protected String semester;
    @XmlElement(nillable = true)
    protected List<SemesterRegistrationVO> semesterRegistrations;
    protected boolean valid;

    /**
     * Gets the value of the courseRegistrations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the courseRegistrations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourseRegistrations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CourseRegistrationVO }
     * 
     * 
     */
    public List<CourseRegistrationVO> getCourseRegistrations() {
        if (courseRegistrations == null) {
            courseRegistrations = new ArrayList<CourseRegistrationVO>();
        }
        return this.courseRegistrations;
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
     * Gets the value of the semesterRegistrations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the semesterRegistrations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSemesterRegistrations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SemesterRegistrationVO }
     * 
     * 
     */
    public List<SemesterRegistrationVO> getSemesterRegistrations() {
        if (semesterRegistrations == null) {
            semesterRegistrations = new ArrayList<SemesterRegistrationVO>();
        }
        return this.semesterRegistrations;
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
